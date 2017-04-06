%{

#include "src/parser.h"
#include <stdio.h>
#include <list>

using namespace std;

programm *root = new programm(new list<statement*>());

int yylex();
void yyerror(const std::string&);

%}

%start program

%union {
    exp_node *expnode;
    list<statement*> *stmts;
    statement *st;
    programm *prog;
    char *id;
    double num;
}

%type <expnode> exp
%type <stmts> stmtlist
%type <st> stmt
%type <prog> program

%left PLUS MINUS
%left MULT DIVIDE
%left LBR RBR
%token POW
%token MOD
%token EQ
%token NEQ
%token GT
%token LT
%token GE
%token LE
%token AND
%token OR
%token BEGIN_
%token END
%token  NEWLINE
%token  IF
%token  ELSE
%token  THEN
%token  WHILE
%token  DO
%token  WRITE
%token  READ
%token  SKIP
%token  COLON
%token  ASSIGN
%token <id> IDENT
%token <num> NUM

%%

program :   stmt {}

stmtlist :    stmtlist NEWLINE
                {
                    $$ = $1;
                }
            | stmtlist stmt NEWLINE
                {
                    $$ = $1;
                    $1->push_back($2);
                }
            | stmtlist error NEWLINE
                {
                    $$ = $1;
                    yyclearin;
                }
            |
                {
                    $$ = new list<statement*>();
                }
stmt :    SKIP
            {
                $$ = new skip_statement();
                root->stmts->push_back($$);
            }
        | IDENT ASSIGN exp
            {
                $$ = new assign_statement($1, $3);
                root->stmts->push_back($$);
            }
        | stmt COLON stmt
            {
                $$ = new colon_statement($1, $3);
                root->stmts->push_back($$);
            }
        | READ LBR IDENT RBR
            {
                $$ = new read_statement($3);
                root->stmts->push_back($$);
            }
        | WRITE LBR exp RBR
            {
                $$ = new write_statement($3);
                root->stmts->push_back($$);
            }
        | WHILE LBR exp RBR DO stmt
            {
                $$ = new while_statement($3, $6);
                root->stmts->push_back($$);
            }
        | IF LBR exp RBR THEN stmt ELSE stmt
            {
                $$ = new if_statement($3, $6, $8);
                root->stmts->push_back($$);
            }
exp :   LBR exp RBR
            {
                $$ = $2;
            }
        |  IDENT
            {
                $$ = new id_node($1);
            }
        |  NUM
            {
                $$ = new number_node($1);
            }
        |  exp PLUS exp
            {
                $$ = new plus_node($1, $3);
            }
        |  exp MINUS exp
            {
                $$ = new minus_node($1, $3);
            }
        |  exp MULT exp
            {
                $$ = new mult_node($1, $3);
            }
        |  exp DIVIDE exp
            {
                $$ = new divide_node($1, $3);
            }
        |  exp MOD exp
            {
                $$ = new mod_node($1, $3);
            }
        |  exp EQ exp
            {
                $$ = new equal_node($1, $3);
            }
        |  exp GT exp
            {
                $$ = new gt_node($1, $3);
            }
        |  exp GE exp
            {
                $$ = new ge_node($1, $3);
            }
        |  exp LT exp
            {
                $$ = new lt_node($1, $3);
            }
        |  exp LE exp
            {
                $$ = new le_node($1, $3);
            }
        |  exp AND exp
            {
                $$ = new and_node($1, $3);
            }
        |  exp OR exp
            {
                $$ = new or_node($1, $3);
            }

%%

main() {
    yyparse();
    root->print();
}

void yyerror(const std::string& other)
{}

