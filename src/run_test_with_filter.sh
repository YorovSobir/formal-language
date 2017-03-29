for file in test/*
do
    printf "\n=======================================\n"
    printf "lexical analysis of $file"
    printf "\n=======================================\n"
    build/lexer -filter < "$file"
done
