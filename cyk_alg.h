#ifndef FORMAL_LANGUAGE_CYK_H
#define FORMAL_LANGUAGE_CYK_H

#include "normal_form_chomsky.h"

struct cyk_alg {
    cyk_alg(const char* gram, const char* str_file)
        : nf()
        , check()
        , matrix()
    {
        std::ifstream ifs(str_file);
        std::string temp;
        while (std::getline(ifs, temp)) {
            check.append(temp);
            check.append(" ");
        }
        nf.normal_form(gram);
    }

    void check_str() {
        auto rules = nf.get_rules();
        std::vector<std::string> str_vec;
        size_t start = 0, end = 0;
        for (size_t i = 0; i < check.size();) {
            if (std::isspace(check[i])) {
                std::string temp;
                temp.push_back('\'');
                temp.append(check.substr(start, end - start));
                temp.push_back('\'');
                str_vec.push_back(std::move(temp));
                start = end + 1;
                ++i;
                while(i < check.size() && std::isspace(check[i])) {
                    ++i;
                    ++start;
                }
                end = start;
                continue;
            }
            ++end;
            ++i;
        }

        matrix.resize(str_vec.size(),
                      std::vector<std::pair<bool, std::vector<std::string>>>(str_vec.size()));

        for (size_t i = 0; i < str_vec.size(); ++i) {
            for (auto& node: rules) {
                if (node.second.size() != 1) {
                    continue;
                }
                if (node.second[0] == str_vec[i]) {
                    matrix[0][i].second.push_back(node.first);
                    matrix[0][i].first = true;
                }
            }
        }

        for (size_t i = 1; i < str_vec.size(); ++i) {
            for (size_t j = 0; j <= str_vec.size() - i; ++j) {
                for(size_t k = 0; k < i - 1; ++k) {
                    if (matrix[k][j].first && matrix[i - k][j + k].first) {
                        for (auto& b: matrix[k][j].second) {
                            for (auto& c: matrix[i - k][j + k].second) {
                                std::vector<std::string> temp{b, c};
                                for (auto& node: rules) {
                                    if (node.second == temp) {
                                        matrix[i][j].first = true;
                                        matrix[i][j].second.push_back(node.first);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

//        for (size_t i = 0; i < str_vec.size(); ++i) {
//            for (auto& node: rules) {
//                if (node.second.size() != 1) {
//                    continue;
//                }
//                if (node.second[0] == str_vec[i]) {
//                    matrix[i][i].second.push_back(node.first);
//                    matrix[i][i].first = true;
//                }
//            }
//        }


//        for (size_t i = 0; i < str_vec.size(); ++i) {
//            for (size_t j = i + 1; j < str_vec.size(); ++j) {
//                for(size_t k = i; k <= j - 1; ++k) {
//                    if (matrix[i][k].first && matrix[k + 1][j].first) {
//                        for (auto& b: matrix[i][k].second) {
//                            for (auto& c: matrix[k + 1][j].second) {
//                                std::vector<std::string> temp{b, c};
//                                for (auto& node: rules) {
//                                    if (node.second == temp) {
//                                        matrix[i][j].first = true;
//                                        matrix[i][j].second.push_back(node.first);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
        if (matrix[0][str_vec.size() - 1].first) {
            std::cout << "we can derive sentence " << check << " in our grammar\n"
                                                            << "see result in res/matrix.csv\n";
            print("../res/matrix.csv");
        } else {
            std::cout << "we cannot derive sentence " << check << " in our grammar\n";
        }

    }

    void print(const char* path) {
        std::ofstream os(path);
        std::string temp;
        os.write("Matrix:\n", 8);
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
                for (auto& t: matrix[i][j].second) {
                    temp += (t + ";");
                }
                temp.back() = ',';
                os.write(temp.c_str(), temp.size());
            }
            os.write("\n", 1);
        }
    }

private:
    normal_form_chomsky nf;
    std::string check;
    std::vector<std::vector<std::pair<bool, std::vector<std::string>>>> matrix;
};
#endif //FORMAL_LANGUAGE_CYK_H
