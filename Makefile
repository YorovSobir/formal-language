
CCC = g++
CCFLAGS= -O2
LEX = flex
LFLAGS= -8
YACC= bison
YFLAGS= -d -t -y

RM = /bin/rm -f

exp: y.tab.o lex.yy.o
	${CCC} ${CCFLAGS} lex.yy.o y.tab.o -o parser -lfl


y.tab.o: src/parser.y src/parser.h
	${YACC} ${YFLAGS} src/parser.y
	${CCC} ${CCFLAGS} y.tab.c -c

lex.yy.o: src/lex.l src/parser.h
	${LEX} $(LFLAGS) src/lex.l
	${CCC} -std=c++11 ${CCFLAGS} lex.yy.c -c

clean:
	/bin/rm -f lex.yy.* y.tab.* *.o parser



# CC=g++
# STANDART=c++11

# all: main

# main: c_file
# 	${CC} -std="${STANDART}" build/lexer.c -o build/lexer -ll

# c_file: build
# 	lex -o build/lexer.c src/lex.l

# build:
# 	mkdir build

# test: main
# 	bash src/run_test.sh

# test_with_filter: main
# 	bash src/run_test_with_filter.sh

# clean:
# 	rm -rf build/*
