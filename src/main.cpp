#include <iostream>
#include "graph_analyze.h"

int main(int argc, char** argv) {
    normal_form_chomsky nf("grammar/trna_grammar");
    graph g(nf);
    std::string output("result.txt");
    if (argc > 1 && std::string(argv[1]) == std::string("-file")) {
        if (argc < 4) {
            std::cout << "forget input and output file\n";
            std::exit(-1);
        }
        g.read_graph(argv[2]);
        output = argv[3];
    } else {
        size_t vertex_count;
        size_t edge_count;
        std::cout << "input vertex and edge count\n";
        std::cin >> vertex_count >> edge_count;
        g.graph_generator(vertex_count, edge_count);
    }
    std::ofstream os(output);
    auto res = g.syntactic_analysis();
    g.print_res(os, res);
}
