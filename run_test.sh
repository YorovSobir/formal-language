
for file in test/*
do
    printf "\n=======================================\n"
    printf "lexical analysis of $file"
    printf "\n=======================================\n"
    java org.antlr.v4.gui.TestRig L program -gui < "$file"
done
