# formal language tasks

## Dependencies:
1. utility cmake (version >= 3.5) - for building project.
2. Any c/c++ compiler (tested in gcc).
3. if you want to run tests you must have any shell (tested in bash).

## How to build project
1. Change current directory to project's root directory (where CMakeList.txt is).
2. run **bash utils/run.sh**.

## Run with reading graph from file
1. if you want to put file with graph instead of generating random file then do next
2. Run binary file as follow: **\<binary file\> -file \<input-file\> \<output-file\>**, \<input-file\> - file with graph (see format of this file above), \<output-file\> - file to write result of algorithm

## Run with random graph
1. Run binary file and then input the count of vertex and edge. Result of algorithm write to file **result.txt**

## Format of file with graph
* first line two integers: **n m**, where n - number of vertex, m - number of edge
* next **m** lines like: v u s, where v, u - vertexes, s - symbol from ['a', 'c', 'g', 't'].
