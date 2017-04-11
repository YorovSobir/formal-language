# Parser for our language

## Dependencies for running parser:
1. ANTLR4. Don't worry Makefile itself download and install ANTLR4.
2. if you want to run tests you must have any shell (tested in bash).
3. JDK 1.8 and JRE
4. utility make - for building project.

## How to build project
1. Change current directory to project's root directory (where Makefile is).
2. run **make**.
3. Now to run project use command **make run** and then write programm in our language at the end of input press Ctrl+D (or Ctrl+Z in Windows).

## if you want run tests
1. do first step from manual above.
2. run command **make run_test** programm show tree for all test file, but to show tree for next file you must close current tree.

## Rebuild
**make clean && make** - clean directory and build project again.
