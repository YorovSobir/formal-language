CC=g++
STANDART=c++11

all: main

main: c_file
	${CC} -std="${STANDART}" build/lexer.c -o build/lexer -ll

c_file: build
	lex -o build/lexer.c src/lex.l

build:
	mkdir build

test: main
	bash src/run_test.sh

test_with_filter: main
	bash src/run_test_with_filter.sh

clean:
	rm -rf build/*
