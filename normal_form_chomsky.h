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

std::string trim(const std::string& str) {
    size_t start, end;
    for (start = 0; start < str.length(); ++start) {
        if (str[start] != ' ') {
            break;
        }
    }
    for (end = str.length() - 1; end > 0; --end) {
        if (str[end] != ' ') {
            break;
        }
    }
    return str.substr(start, end - start + 1);
}

struct normal_form_chomsky {

    void normalize(const char* path) {
        get_grammar(path);
        std::cout << "original grammar\n";
        print(std::cout);
        std::cout << "===============================\n";
        elim_start_term_from_right();
        std::cout << "after adding new start non-terminal\n";
        print(std::cout);
        std::cout << "===============================\n";
        replace_term();
        std::cout << "after replace term\n";
        print(std::cout);
        std::cout << "===============================\n";
        elim_long_rules();
        std::cout << "after elim long rules\n";
        print(std::cout);
        std::cout << "===============================\n";
        elim_eps_rules();
        std::cout << "after elim eps rules\n";
        print(std::cout);
        std::cout << "===============================\n";
        elim_unit_rules();
        std::cout << "after elim unit rules\n";
        print(std::cout);
        std::cout << "===============================\n";
        elim_non_generating();
        std::cout << "after elim non generating rules\n";
        print(std::cout);
        std::cout << "===============================\n";
    }
    void get_grammar(const char* path) {
        std::ifstream ifs(path);
        std::string line;
        std::getline(ifs, line);
        start_non_term = trim(line);
        while (std::getline(ifs, line)) {
            line = trim(line);
            size_t start = 0;
            size_t end = line.find('=');
            std::string non_term = trim(line.substr(start, end - start));
            start = end + 1;
            while (start < line.length()) {
                end = line.find('|', start);
                if (end == std::string::npos) {
                    end = line.length();
                }
                std::string right = trim(line.substr(start, end - start));
                std::vector<std::string> rule;
                size_t st_pos = 0;
                size_t end_pos = 0;
                for (auto it = right.begin(); it != right.end();) {
                    if (std::isspace(*it)) {
                        rule.emplace_back(right.substr(st_pos, end_pos - st_pos));
                        st_pos = end_pos + 1;
                        ++it;
                        while(it != right.end() && std::isspace(*it)) {
                            ++it;
                            ++st_pos;
                        }
                        end_pos = st_pos;
                        continue;
                    }
                    if (!std::isspace(*it)) {
                        ++end_pos;
                    }
                    ++it;
                }
                rule.emplace_back(right.substr(st_pos, end_pos - st_pos));
                rules.emplace(std::make_pair(non_term, std::move(rule)));
                start = end + 1;
            }
        }
    }

    void replace_term() {
        for (auto& node: rules) {
            if (node.second.size() < 2) {
                continue;
            }
            for (int i = 0; i < node.second.size(); ++i) {
                if (node.second[i][0] == '\'') {
                    std::string non_term = get_next_non_term();
                    rules.emplace(std::make_pair(non_term,
                                 std::vector<std::string>{node.second[i]}));
                    node.second[i] = non_term;
                }
            }
        }
    }

    void elim_long_rules() {
        for (auto p = rules.begin(); p != rules.end();) {
            auto& vec = p->second;
            if (vec.size() <= 2) {
                ++p;
                continue;
            }
            std::string key = p->first;
            int i;
            for (i = 0; i < vec.size() - 2; ++i) {
                std::string non_term = get_next_non_term();
                rules.emplace(std::make_pair(key,
                             std::vector<std::string>{vec[i], non_term}));
                key = non_term;
            }
            rules.emplace(std::make_pair(key, std::vector<std::string>{vec[i], vec[i + 1]}));
            p = rules.erase(p);
        }
    }

    void elim_start_term_from_right() {
        rules.emplace(std::make_pair(start_non_term + "0",
                                     std::vector<std::string>{start_non_term}));
        start_non_term += "0";
    }

    std::set<std::string> eps_generating() {
        std::set<std::string> nullable;
        for (auto& node: rules) {
            if (node.second.size() != 1) {
                continue;
            }
            if (node.second[0].compare("eps") == 0) {
                nullable.emplace(node.first);
            }
        }
        while (true) {
            auto old_size = nullable.size();
            for (auto& node: rules) {
                bool is_nullable = true;
                for (auto& term: node.second) {
                    if (std::find(nullable.begin(), nullable.end(), term) == nullable.end()) {
                        is_nullable = false;
                        break;
                    }
                }
                if (is_nullable) {
                    nullable.emplace(node.first);
                }
            }
            if (old_size == nullable.size()) {
                break;
            }
        }
        return nullable;
    }

    void elim_eps_rules() {
        std::set<std::string> is_nullable = eps_generating();
        for (auto& node: rules) {
            if (node.second.size() == 1) {
                continue;
            }

            if (is_nullable.find(node.second[0]) != is_nullable.end()) {
                rules.emplace(std::make_pair(node.first, std::vector<std::string>{node.second[1]}));
            }

            if (is_nullable.find(node.second[1]) != is_nullable.end()) {
                rules.emplace(std::make_pair(node.first, std::vector<std::string>{node.second[0]}));
            }
        }

        for (auto it = rules.begin(); it != rules.end();) {
            if (it->second.size() == 1) {
                if (it->second[0].compare("eps") == 0) {
                    it = rules.erase(it);
                    continue;
                }
            }
            ++it;
        }
    }

    void elim_unit_rules() {
        std::set<std::pair<std::string, std::string>> unit_rules;
        while (true) {
            auto old = unit_rules.size();
            for (auto& node: rules) {
                if (node.second.size() != 1 || node.second[0][0] == '\'') {
                    continue;
                }
                auto temp = std::make_pair(node.first, node.second[0]);
                if (unit_rules.find(temp) == unit_rules.end()) {
                    unit_rules.emplace(temp);
                    auto range = rules.equal_range(node.second[0]);
                    auto key_range = rules.equal_range(node.first);
                    for (auto it = range.first; it != range.second; ++it) {
                        bool exist = false;
                        for(auto it1 = key_range.first; it1 != key_range.second; ++it1) {
                            if (it1->second == it->second) {
                                exist = true;
                                break;
                            }
                        }
                        if (!exist) {
                            rules.emplace(std::make_pair(node.first, it->second));
                        }
                    }
                }
            }
            if (unit_rules.size() == old) {
                break;
            }
        }
        for (auto node = rules.begin(); node != rules.end();) {
            if (node->second.size() != 1 || node->second[0][0] == '\'') {
                ++node;
                continue;
            }
            node = rules.erase(node);
        }

    }

    void elim_non_generating() {
       std::set<std::string> generating;
       for (auto& node: rules) {
           if (node.second.size() != 1 || node.second[0][0] != '\'') {
               continue;
           }
           generating.emplace(node.first);
       }
       while (true) {
           auto old = generating.size();
           for (auto& node: rules) {
               if (generating.find(node.first) != generating.end()) {
                   continue;
               }
               bool is_gen = true;
               for (auto& it: node.second) {
                   if (it[0] == '\'') {
                       continue;
                   }
                   if (generating.find(it) == generating.end()) {
                       is_gen = false;
                       break;
                   }
               }
               if (is_gen) {
                   generating.emplace(node.first);
               }
           }
           if (generating.size() == old) {
               break;
           }
       }
       for (auto it = rules.begin(); it != rules.end();) {
            if (generating.find(it->first) == generating.end()) {
                it = rules.erase(it);
                continue;
            }
            ++it;
       }
       std::cout << "daa";

    }

    std::string get_next_non_term() {
        while (rules.find(last_non_term.first) != rules.end()) {
            if (last_non_term.second == 9) {
                last_non_term.first.pop_back();
                last_non_term.first.back() = static_cast<char>(last_non_term.first.back() + 1);
                last_non_term.first.push_back('0');
                last_non_term.second = 0;
            } else {
                last_non_term.second++;
                last_non_term.first.back() = static_cast<char>(last_non_term.second + '0');
            }
        }
        return last_non_term.first;
    }

    void print(std::ostream& os) {
        std::map<std::string, std::string> printer;
        for (auto& node: rules) {
            std::string rule;
            for (auto& it: node.second) {
                rule += it + " ";
            }
            rule += "| ";
            printer[node.first] += std::move(rule);
        }
        os.write((start_non_term + "\n").c_str(), start_non_term.size() + 1);
        for (auto& node: printer) {
            node.second.erase(node.second.size() - 3, 3);
            os.write((node.first + " = ").c_str(), node.first.size() + 3);
            os.write((node.second + "\n").c_str(), node.second.size() + 1);
        }
    }
private:
    std::multimap<std::string, std::vector<std::string>> rules;
    std::string start_non_term;
    std::pair<std::string, int> last_non_term = std::make_pair("A0", 0);
};

#endif //FORMAL_LANGUAGE_NORMAL_FORM_CHOMSKY_H
