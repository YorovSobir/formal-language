#ifndef FORMAL_LANGUAGE_GRAPH_ANALYZE_H
#define FORMAL_LANGUAGE_GRAPH_ANALYZE_H

#include <sstream>
#include <random>
#include <functional>
#include "normal_form_chomsky.h"

struct graph {

    graph(const normal_form_chomsky& nf);
    void read_graph(const char* path);
    void graph_generator(size_t vertex_count, size_t edge_count);
    void print_graph(std::ostream &os, size_t vertex_count, size_t edge_count);
    void print_res(std::ostream& os, std::set<std::tuple<size_t, size_t, std::string>>& res);
    std::set<std::tuple<size_t, size_t, std::string>> syntactic_analysis();

private:
    normal_form_chomsky nf;
    std::vector<std::vector<std::pair<std::string, size_t>>> adjlist;
};
#endif //FORMAL_LANGUAGE_GRAPH_ANALYZE_H
