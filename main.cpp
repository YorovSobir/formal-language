#include <iostream>
#include "normal_form_chomsky.h"

int main(int argc, char** argv) {
    normal_form_chomsky nf;
    nf.get_grammar("../test");
    nf.print(std::cout);
    std::cout << "===============================\n";
    nf.elim_start_term_from_right();
//    nf.print(std::cout);
//    std::cout << "===============================\n";
    nf.replace_term();
    std::cout << "after replace term\n";
    nf.print(std::cout);
    std::cout << "===============================\n";
    nf.elim_long_rules();
    std::cout << "after elim long rules\n";
    nf.print(std::cout);
    std::cout << "===============================\n";
    nf.elim_eps_rules();
    std::cout << "after elim eps rules\n";
    nf.print(std::cout);
    std::cout << "===============================\n";
    nf.elim_unit_rules();
    std::cout << "after elim unit rules\n";
    nf.print(std::cout);
    std::cout << "===============================\n";
    nf.elim_non_generating();
    std::cout << "after elim non generating rules\n";
    nf.print(std::cout);
    std::cout << "===============================\n";
}