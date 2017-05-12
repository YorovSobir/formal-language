#include <iostream>
#include "graph_analyze.h"

int main(int argc, char** argv) {
    size_t vertex_count;
    size_t edge_count;
    std::cout << "input vertex and edge count\n";
    std::cin >> vertex_count >> edge_count;
    normal_form_chomsky nf("../test/trna_grammar");
    graph g(nf);
    g.graph_generator(vertex_count, edge_count);
    g.print("../test/graph.dot");
    auto res = g.syntactic_analysis();
    for (auto& t: res) {
        std::cout << "(" << std::get<0>(t)
                  << ", " << std::get<1>(t)
                  << ", " << std::get<2>(t)
                  << ")" << std::endl;
    }
}
