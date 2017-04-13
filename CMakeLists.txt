cmake_minimum_required(VERSION 3.6)
project(formal_language)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp normal_form_chomsky.h)
add_executable(formal_language ${SOURCE_FILES})