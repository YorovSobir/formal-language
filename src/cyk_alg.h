#ifndef FORMAL_LANGUAGE_CYK_H
#define FORMAL_LANGUAGE_CYK_H

#include "normal_form_chomsky.h"

struct cyk_alg {
    cyk_alg(const char* gram, const char* str_file)
        : nf()
        , file_name(str_file)
        , check()
        , matrix()
    {
        std::ifstream ifs(str_file);
        std::string temp;
        while (std::getline(ifs, temp)) {
            check.append(temp);
            check.push_back(' ');
        }
        check.pop_back();
        nf.normalize(gram);
    }

    void check_str() {
        auto rules = nf.get_rules();
        std::vector<std::string> str_vec;
        for (size_t i = 0; i < check.size(); ++i) {
            std::string temp;
            temp.push_back('\'');
            temp.push_back(check[i]);
            temp.push_back('\'');
            str_vec.push_back(std::move(temp));
        }

        matrix.resize(str_vec.size(), std::vector<std::vector<cell>>(
                              str_vec.size(),
                              std::vector<cell>()
                      ));

        for (size_t i = 0; i < str_vec.size(); ++i) {
            for (auto& node: rules) {
                if (node.second.size() != 1) {
                    continue;
                }
                if (node.second[0] == str_vec[i]) {
                    matrix[i][i].push_back(cell(-1, str_vec[i], "", node.first));
                }
            }
        }

        for (size_t m = 0; m < str_vec.size() - 1; ++m) {
            for (size_t i = 0; i < str_vec.size() - m - 1; ++i) {
                size_t j = m + i + 1;
                for (size_t k = i; k < j; ++k) {
                    if (matrix[i][k].size() > 0 && matrix[k + 1][j].size() > 0) {
                        std::vector<std::string> temp(2);
                        for (auto& x: matrix[i][k]) {
                            temp[0] = x.cur_term;
                            for (auto& y: matrix[k + 1][j]) {
                                temp[1] = y.cur_term;
                                for (auto& node: rules) {
                                    if (node.second == temp) {
                                        matrix[i][j].push_back(
                                                cell((int)k, temp[0], temp[1], node.first));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        bool is_derived = false;
        auto start_non_term = nf.get_start_non_term();
        for (auto& term: matrix[0][str_vec.size() - 1]) {
            if (term.cur_term == start_non_term) {
                is_derived = true;
                break;
            }
        }
        std::cout << "grammar:\n";
        nf.print(std::cout);
        std::cout << "===============================\n";

        if (is_derived) {
            std::cout << "we can derive sentence " << check << " in our grammar\n"
                      << "see result in " << file_name << ".csv" << std::endl;
            print(file_name + ".csv");
            print_tree(file_name + ".dot");
        } else {
            std::cout << "we cannot derive sentence " << check << " in our grammar\n";
        }

    }

    void print(std::string path) {
        std::ofstream os(path.c_str());
        std::string temp;
        for (size_t i = 0; i < matrix.size(); ++i) {
            temp.clear();
            for (size_t k = 0; k < i; ++k) {
                temp.push_back(',');
            }
            if (i > 0) {
                os.write(temp.c_str(), temp.size());
            }
            for (size_t j = i; j < matrix[i].size(); ++j) {
                temp.clear();
                for (auto& t: matrix[i][j]) {
                    temp += (t.cur_term + ";");
                }
                if (temp.empty()) {
                    os.write(",", 1);
                } else {
                    temp.back() = ',';
                    os.write(temp.c_str(), temp.size());
                }
            }
            os.write("\n", 1);
        }
        os.close();
    }

    std::string print_tree_node(std::ostream& os, int i, int j,
                         std::string term, std::string left, std::string right) {
        if (i < 0 || j < 0) {
            return "";
        }
        for (auto& node: matrix[i][j]) {
            if (node.cur_term == term) {
                std::string temp;
                if (i == 0 && j == matrix.size() - 1) {
                    temp = "\"" + node.cur_term + "\"" +
                        " -> \"" + trim(node.first + " " + node.second) + "\"";

                } else {
                    temp = ";\n\"" + trim(left + " " + node.cur_term + " " + right) + "\"" +
                        " -> \"" + trim(trim(left + " "  + node.first + " " + node.second) +
                                                " " + right) + "\"";
                }
                os.write(temp.c_str(), temp.size());

                if (node.k == -1) {
                    return trim(temp.substr(temp.find("->") + 2));
                }

                std::string left_res = print_tree_node(os, i, node.k, node.first,
                                left, trim(node.second + " " + right));
                auto pos = left_res.find_last_of('\'');
                if (pos == std::string::npos) {
                    pos = 0;
                }
                std::string res = print_tree_node(os, node.k + 1, j, node.second,
                                trim(left_res.substr(1, pos)), trim(right));
                return res;
            }
        }
        return "";
    }

    void print_tree(std::string path) {
        std::ofstream os(path.c_str());
        auto start_non_term = nf.get_start_non_term();
        os.write("digraph {\n", 10);
        print_tree_node(os, 0, (int) matrix.size() - 1, start_non_term, "", "");
        os.write(";\n}", 3);
        os.close();
    }

    struct cell {
        int k;
        std::string first;
        std::string second;
        std::string cur_term;

        cell(int k, std::string first, std::string second, std::string term)
            : k(k)
            , first(first)
            , second(second)
            , cur_term(term)
        {}
    };
private:
    normal_form_chomsky nf;
    std::string file_name;
    std::string check;
    std::vector<std::vector<std::vector<cell>>> matrix;
};
#endif //FORMAL_LANGUAGE_CYK_H
