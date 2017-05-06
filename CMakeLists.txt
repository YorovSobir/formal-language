cmake_minimum_required(VERSION 3.5)
project(formal_language)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES src/main.cpp src/normal_form_chomsky.h src/graph_analyze.h)
add_executable(formal_language ${SOURCE_FILES})
