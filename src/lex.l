%{
    #include <stdio.h>
    #include <string>
    #include <stack>
    #include <utility>

    int line_number = 0;
    int pos = 0;
    int keyword_count = 0;
    int literal_count = 0;
    int ident_count = 0;
    int comment_count = 0;
    int operator_count = 0;
    bool filter = false;

%}

CR                  \n
LF                  \r
CRLF                \n\r
SP                  [ ]
HT                  \t
FF                  \f
Ident               [a-zA-Z\_]+[a-zA-Z0-9\_]*
Op                  [\+\-\*\/\%><]|==|!=|>=|<=|&&|\|\||:=|\*\*
Bool_lit            ("true"|"false")
integer             \-?(0|[1-9][0-9]*(e[\+\-]?[0-9]*)?)
double_with_int     \-?(0|([1-9][0-9]*))\.[0-9]*(e[\+\-]?[0-9]*)?
double_without_int  \-?\.[0-9]+(e[\+\-]?[0-9]*)?
Num                 ({integer}|{double_with_int}|{double_without_int})
Comment             \/\/.*$
MLComment           \(\*

%%
{Comment}   {
                if (!filter) {
                    yytext[yyleng] = (char) 0;
                    ++comment_count;
                    printf("Comment(%s, %d, %d, %ld); ", &yytext[2], line_number, pos, pos + yyleng - 1);
                }
                pos += yyleng;
            }

{MLComment} {
                int len = 2;
                std::string mlcomment = "(*";
                char c;
                char pred = -1;
                int count = 1;
                int start_line = line_number;
                std::stack<std::pair<int, int>> comment;
                comment.push(std::make_pair(line_number, pos));
                while(count != 0) {
                    c = yyinput();
                    ++len;
                    if (c == -1) {
                        pos += len;
                        if (!filter) {
                            printf("\n%s\n", mlcomment.c_str());
                            printf("Error unclosed comments:\n");
                            while (!comment.empty()) {
                                auto p = comment.top();
                                comment.pop();
                                printf("started: (%d, %d)\n", p.first, p.second);
                            }
                            return -1;
                        } else {
                            break;
                        }
                    }
                    mlcomment.push_back(c);
                    if (c == '*') {
                        if (pred == '(') {
                            comment.push(std::make_pair(line_number, pos + len - 1));
                            ++count;
                            pred = -1;
                            continue;
                        }
                    }
                    if (c == ')') {
                        if (pred == '*'){
                            comment.pop();
                            --count;
                        }
                    }
                    if (c == '\n') {
                        ++line_number;
                    }
                    pred = c;
                }
                if (!filter) {
                    printf("MLComment(%s, (%d, %d), (%d, %d)); ", mlcomment.c_str(), start_line, line_number, pos, pos + len - 1);
                }
                pos += len;
            }

if      {++keyword_count; printf("KW_If(%d, %d, %d); ", line_number, pos, pos + 1); pos += 2;}
then    {++keyword_count; printf("KW_Then(%d, %d, %d); ", line_number, pos, pos + 3); pos += 4;}
else    {++keyword_count; printf("KW_Else(%d, %d, %d); ", line_number, pos, pos + 3); pos += 4;}
while   {++keyword_count; printf("KW_While(%d, %d, %d); ", line_number, pos, pos + 4); pos += 5;}
do      {++keyword_count; printf("KW_Do(%d, %d, %d); ", line_number, pos, pos + 1); pos += 2;}
read    {++keyword_count; printf("KW_Read(%d, %d, %d); ", line_number, pos, pos + 3); pos += 4;}
write   {++keyword_count; printf("KW_Write(%d, %d, %d); ", line_number, pos, pos + 4); pos += 5;}
begin   {++keyword_count; printf("KW_Begin(%d, %d, %d); ", line_number, pos, pos + 4); pos += 5;}
end     {++keyword_count; printf("KW_End(%d, %d, %d); ", line_number, pos, pos + 2); pos += 3;}

{Bool_lit}   {
                ++literal_count;
                yytext[yyleng] = (char) 0;
                printf("Boolean(%s, %d, %d, %ld); ", yytext, line_number, pos, pos + yyleng - 1);
                pos += yyleng;
            }
{Ident}     {
                ++ident_count;
                yytext[yyleng] = (char) 0;
                printf("Ident(%s, %d, %d, %ld); ", yytext, line_number, pos, pos + yyleng - 1);
                pos += yyleng;
            }

";"     {
            printf("Colon(%d, %d, %d); ", line_number, pos, pos);
            pos += 1;
        }

{Op}      {
            ++operator_count;
            yytext[yyleng] = (char) 0;
            if (yyleng > 1) {
                if (strcmp(yytext, "==") == 0) {
                    printf("Op(Eq, %d, %d, %d); ", line_number, pos, pos + 1);
                    pos += 2;
                }
                if (strcmp(yytext, "!=") == 0) {
                    printf("Op(Neq, %d, %d, %d); ", line_number, pos, pos + 1);
                    pos += 2;
                }
                if (strcmp(yytext, ">=") == 0) {
                    printf("Op(GE, %d, %d, %d); ", line_number, pos, pos + 1);
                    pos += 2;
                }
                if (strcmp(yytext, "<=") == 0) {
                    printf("Op(LE, %d, %d, %d); ", line_number, pos, pos + 1);
                    pos += 2;
                }
                if (strcmp(yytext, "&&") == 0) {
                    printf("Op(And, %d, %d, %d); ", line_number, pos, pos + 1);
                    pos += 2;
                }
                if (strcmp(yytext, "||") == 0) {
                    printf("Op(Or, %d, %d, %d); ", line_number, pos, pos + 1);
                    pos += 2;
                }
                if (strcmp(yytext, ":=") == 0) {
                    printf("Op(Assignment, %d, %d, %d); ", line_number, pos, pos + 1);
                    pos += 2;
                }
                if (strcmp(yytext, "**") == 0) {
                    printf("Op(Pow, %d, %d, %d); ", line_number, pos, pos + 1);
                    pos += 2;
                }
            } else {
                if (yytext[0] == '+') {
                    printf("Op(Plus, %d, %d, %d); ", line_number, pos, pos);
                    pos += 1;
                }
                if (yytext[0] == '-') {
                    printf("Op(Minus, %d, %d, %d); ", line_number, pos, pos);
                    pos += 1;
                }
                if (yytext[0] == '/') {
                    printf("Op(Div, %d, %d, %d); ", line_number, pos, pos);
                    pos += 1;
                }
                if (yytext[0] == '*') {
                    printf("Op(Mul, %d, %d, %d); ", line_number, pos, pos);
                    pos += 1;
                }
                if (yytext[0] == '%') {
                    printf("Op(Mod, %d, %d, %d); ", line_number, pos, pos);
                    pos += 1;
                }
                if (yytext[0] == '>') {
                    printf("Op(GT, %d, %d, %d); ", line_number, pos, pos);
                    pos += 1;
                }
                if (yytext[0] == '<') {
                    printf("Op(LT, %d, %d, %d); ", line_number, pos, pos);
                    pos += 1;
                }

            }
        }

{Num}     {
            yytext[yyleng] = (char) 0;
            ++literal_count;
            printf("Num(%s, %d, %d, %ld); ", yytext, line_number, pos, pos + yyleng - 1);
            pos += yyleng;
        }

"("       {
            printf("LBracket(%d, %d, %d); ", line_number, pos, pos);
            pos += 1;
          }
")"       {
            printf("RBracket(%d, %d, %d); ", line_number, pos, pos);
            pos += 1;
          }

({SP}|{HT}|{FF})        {++pos;}

({CR}|{LF}|{CRLF})      {++line_number; ++pos; ;}
.           {
                printf("unknown character: %c\nline = %d pos = %d", yytext[0], line_number, pos);
                return -1;
            }
%%

int main(int args, char** argv) {
    for (int i = 1; i < args; ++i) {
        if (strncmp(argv[i], "-filter", 7) == 0) {
            filter = true;
        }
    }

    int res = yylex();

    if (res == -1) {
        printf("\n=======================================\n"
                "please fix above error and try again!\n"
                "=========================================\n");
        return 0;
    }

    printf("\n=====================================\nresult:\n"
           "newline = %d\nkeyword-count = %d\nliteral-count = %d"
           "\nidentificator-count = %d\noperator-count = %d"
           "\ncomment-count = %d\n"
           "=======================================\n",
           line_number, keyword_count, literal_count,
            ident_count, operator_count, comment_count);
    return 0;
}
