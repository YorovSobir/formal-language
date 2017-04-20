./bin/formal_language test/arithmetic_grammar test/test_arithmetic
printf "\n====================================\n"
./bin/formal_language test/parentheses_unamb_grammar test/test_unamb_parentheses
printf "\n====================================\n"

dot -Tps test/test_arithmetic.dot -o test/test_arithmetic.ps
dot -Tps test/test_unamb_parentheses.dot -o test/test_unamb_parentheses.ps
