#ifndef FORMAL_LANGUAGE_NORMAL_FORM_CHOMSKY_H
#define FORMAL_LANGUAGE_NORMAL_FORM_CHOMSKY_H

#include <fstream>
#include <string>
#include <iostream>
#include <map>
#include <vector>
#include <list>
#include <queue>
#include <algorithm>
#include <set>

std::string trim(const std::string& str);

struct normal_form_chomsky {

    normal_form_chomsky(const char* path);

    void normalize(const char* path);

    void read_grammar(const char *path);

    void elim_long_rules();

    std::set<std::string> eps_generating();

    void elim_eps_rules();

    void elim_unit_rules();

    void elim_non_generating();

    void replace_term();

    std::string get_next_non_term();

    std::multimap<std::string, std::vector<std::string>> get_rules();

    std::string get_start_non_term();

    void print(std::ostream& os);

    std::vector<std::string> find_rule(const std::vector<std::string>& prod);

private:
    std::multimap<std::string, std::vector<std::string>> rules;
    std::string start_non_term;
    std::pair<std::string, int> last_non_term = std::make_pair("A0", -1);
};

#endif //FORMAL_LANGUAGE_NORMAL_FORM_CHOMSKY_H
