# Lex-analyze

## Dependencies
1. Maven

## How to run project
1. mvn package
2. mvn exec:java -Dexec.mainClass="Main" -Dexec.args="path to file"
3. **bash tree.sh <path>.dot**, <path> - it is path to file (which you input above).
4. open file <path>.dot.ps to see result

## How to run tests
1. mvn package
2. mvn test
3. do step 3 and 4 from **How to run project** (all dot files are in **target** folder)
