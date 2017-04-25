#include <iostream>
#include "normal_form_chomsky.h"
#include "cyk_alg.h"

int main(int argc, char** argv) {
  if (argc <= 2) {
      std::cout << "CYK take two args!\n";
      std::exit(-1);
  }
//    cyk_alg cyk("../test/arithmetic_grammar", "../test/test_arithmetic");
  cyk_alg cyk(argv[1], argv[2]);
  cyk.check_str();
}
