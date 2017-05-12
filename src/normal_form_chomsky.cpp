#include "normal_form_chomsky.h"

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

normal_form_chomsky::normal_form_chomsky(const char* path)
{
    normalize(path);
}

void normal_form_chomsky::normalize(const char* path) {
    read_grammar(path);
    std::cout << "grammar before notmalize:\n";
    print(std::cout);
    elim_long_rules();
    elim_eps_rules();
    elim_unit_rules();
    elim_non_generating();
    replace_term();
    std::cout << "\n=======================================\n";
    std::cout << "grammar after normalize:\n";
    print(std::cout);
    std::cout << "\n=======================================\n";
}

void normal_form_chomsky::read_grammar(const char *path) {
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

void normal_form_chomsky::elim_long_rules() {
    for (auto p = rules.begin(); p != rules.end();) {
        auto& vec = p->second;
        if (vec.size() <= 2) {
            ++p;
            continue;
        }
        std::string key = p->first;
        size_t i;
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

std::set<std::string> normal_form_chomsky::eps_generating() {
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

void normal_form_chomsky::elim_eps_rules() {
    std::set<std::string> is_nullable = eps_generating();
    bool is_start_term_eps = false;
    if (is_nullable.find(start_non_term) != is_nullable.end()) {
        is_start_term_eps = true;
    }
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
    if (is_start_term_eps) {
        rules.emplace(std::make_pair(start_non_term + "0",
                                     std::vector<std::string>{start_non_term}));
        rules.emplace(std::make_pair(start_non_term + "0",
                                     std::vector<std::string>{"eps"}));
        start_non_term += "0";
    }
}

void normal_form_chomsky::elim_unit_rules() {
    std::set<std::pair<std::string, std::string>> unit_rules;
    while (true) {
        auto old = unit_rules.size();
        for (auto& node: rules) {
            if (node.second.size() != 1 || node.second[0][0] == '\''
                || node.second[0].compare("eps") == 0) {
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
        if (node->second.size() != 1 || node->second[0][0] == '\'' ||
            node->second[0].compare("eps") == 0) {
            ++node;
            continue;
        }
        node = rules.erase(node);
    }

}

void normal_form_chomsky::elim_non_generating() {
    std::set<std::string> generating;
    for (auto& node: rules) {
        bool is_gen = true;
        for (auto& term: node.second) {
            if (term[0] != '\'' && term.compare("eps") != 0) {
                is_gen = false;
                break;
            }
        }
        if (is_gen){
            generating.emplace(node.first);
        }
    }
    while (true) {
        auto old = generating.size();
        for (auto& node: rules) {
            if (generating.find(node.first) != generating.end()) {
                continue;
            }
            bool is_gen = true;
            for (auto& it: node.second) {
                if (it[0] == '\'' || it.compare("eps") == 0) {
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

}

void normal_form_chomsky::replace_term() {
    std::map<std::string, std::string> single_term;
    for (auto& node: rules) {
        if (node.second.size() == 1) {
            single_term[node.second[0]] = node.first;
        }
    }
    for (auto& node: rules) {
        if (node.second.size() != 2) {
            continue;
        }
        for (size_t i = 0; i < node.second.size(); ++i) {
            if (node.second[i][0] == '\'') {
                std::string non_term;
                if (single_term.find(node.second[i]) == single_term.end()) {
                    non_term = get_next_non_term();
                    single_term.emplace(node.second[i], non_term);
                    rules.emplace(std::make_pair(non_term,
                                                 std::vector<std::string>{node.second[i]}));
                } else {
                    non_term = single_term[node.second[i]];
                }
                node.second[i] = non_term;
            }
        }
    }
}

std::string normal_form_chomsky::get_next_non_term() {
    do {
        if (last_non_term.second == 9) {
            last_non_term.first.pop_back();
            last_non_term.first.back() = static_cast<char>(last_non_term.first.back() + 1);
            last_non_term.first.push_back('0');
            last_non_term.second = 0;
        } else {
            last_non_term.second++;
            last_non_term.first.back() = static_cast<char>(last_non_term.second + '0');
        }
    } while (rules.find(last_non_term.first) != rules.end());

    return last_non_term.first;
}

std::multimap<std::string, std::vector<std::string>> normal_form_chomsky::get_rules() {
    return rules;
}

std::string normal_form_chomsky::get_start_non_term() {
    return start_non_term;
}

void normal_form_chomsky::print(std::ostream& os) {
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


std::vector<std::string> normal_form_chomsky::find_rule(const std::vector<std::string>& prod) {
    std::vector<std::string> res;
    for (auto& rule: rules) {
        if (rule.second == prod) {
            res.push_back(rule.first);
        }
    }
    return res;
}