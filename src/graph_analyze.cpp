#include "graph_analyze.h"


graph::graph(const normal_form_chomsky& nf)
        : nf(nf)
        , adjlist()
{}


void graph::graph_generator(size_t vertex_count, size_t edge_count) {
    std::string alphabet = "acgt";
    std::default_random_engine generator;
    std::uniform_int_distribution<size_t> distribution(0, vertex_count - 1);
    auto dice = std::bind(distribution, generator);

    std::set<std::tuple<size_t, std::string, size_t>> temp;

    adjlist.resize(vertex_count);
    for (size_t i = 0; i < edge_count; ++i) {
        size_t from, to;
        std::string edge;
        from = dice();
        to = dice();
        edge.push_back('\'');
        edge.push_back(alphabet[dice() % 4]);
        edge.push_back('\'');
        if (temp.find(std::make_tuple(from, edge, to)) == temp.end()) {
            adjlist[from].push_back(std::make_pair(edge, to));
        }
    }
}


void graph::print(const char* path) {
    std::ofstream os(path);
    std::string res("digraph {\n");
    for (size_t i = 0; i < adjlist.size(); ++i) {
        for (auto& edge: adjlist[i]) {
            res.append(std::to_string(i) + " -> "
                       + std::to_string(edge.second)
                       + " [label = \"" + edge.first + "\"];\n");
        }
    }
    res.push_back('}');
    os.write(res.c_str(), res.size());
    os.close();
}


std::set<std::tuple<size_t, size_t, std::string>>
graph::syntactic_analysis() {
    std::set<std::tuple<size_t, size_t, std::string>> res;
    for (size_t i = 0; i < adjlist.size(); ++i) {
        for (auto edge: adjlist[i]) {
            auto rules = nf.find_rule(std::vector<std::string>{edge.first});
            for (auto term: rules) {
                res.emplace(std::make_tuple(i, edge.second, term));
            }
        }
    }

    while (true) {
        size_t old_size = res.size();
        for (auto& i: res) {
            for (auto& j: res) {
                if (std::get<1>(i) == std::get<0>(j)) {
                    auto rules = nf.find_rule(std::vector<std::string>{
                            std::get<2>(i), std::get<2>(j)
                    });
                    for (auto& term: rules) {
                        auto temp = std::make_tuple(std::get<0>(i),
                                                    std::get<1>(j),
                                                    term);
                        res.insert(temp);
                    }
                }
            }
        }
        if (res.size() == old_size) {
            break;
        }
    }

    return res;
}


void graph::read_graph(const char* path) {
    std::ifstream is(path);
    size_t vertex_count;
    size_t edge_count;
    is >> vertex_count;
    is >> edge_count;
    adjlist.resize(vertex_count);

    for (size_t i = 0; i < edge_count; ++i) {
        size_t from, to;
        std::string edge;
        is >> from >> edge >> to;
        adjlist[from - 1].push_back(std::make_pair(edge, to - 1));
    }
}
