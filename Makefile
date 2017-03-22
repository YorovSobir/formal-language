CC=gcc

all: main

main: c_file
	${CC} build/lexer.c -o build/lexer -ll

c_file: build
	lex -o build/lexer.c src/lex.l

build:
	mkdir build

test_all: main
	bash src/run_test.sh

clean:
	rm -rf build/*
