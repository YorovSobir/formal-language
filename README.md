# Lexer for our language

## Dependencies for running lexer:
1. Lexical analyzer generator: lex or flex, maybe some other lex* (not sure).
2. if you want to run tests you must have any shell (tested in bash).
3. Any c/c++ compiler (tested in gcc).
4. utility make - for building project.

## How to build project
1. Change current directory to project's root directory (where Makefile is).
2. run **make**.
3. Now to run project we must run laxer from build/ directory.
   * ./build/lexer - running without parameter, then you must write some code in language which specified in lexer. lexer return     list of lexem.
    * ./build/lexer < \<file\> - lexer read code from \<file\> and return list of lexem

## if you want run tests
1. do first step from manual above.
2. run **make test\_all**. lexer running and read \<test_file\> from _test/_ directory. For all file in this directory lexer write result to console. Result include the number of lines, identificator, keyword, literal, comment, operator.

## Rebuild
**make clean && make** - clean directory and build project again.
