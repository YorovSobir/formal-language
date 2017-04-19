#include <iostream>
#include "normal_form_chomsky.h"

int main(int argc, char** argv) {
//    if (argc <= 1) {
//        std::cout << "Normal form take path to grammar!\n";
//        std::exit(-1);
//    }
    normal_form_chomsky nf;
    nf.normalize("../test/parentheses_unambiguous");
}