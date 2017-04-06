grammar L;

INTEGER: '-'? ('0' | DIGIT DIGIT0* ('e' ('+' | '-')? DIGIT0*)? );
DOUBLE_WITH_INT: '-'? ('0' | (DIGIT DIGIT0*)) '.' DIGIT0* ('e' ('+' | '-')? DIGIT0*)?;
DOUBLE_WITHOUT_INT: '-'? '.' DIGIT0+ ('e' ('+' | '-')? DIGIT0*)?;
DIGIT : [1-9];
DIGIT0 : [0-9];
NUM: INTEGER|DOUBLE_WITH_INT|DOUBLE_WITHOUT_INT;
COMMENT: '//'[^\n\r]* -> skip;
ML_COMMENT: '(*' ('('*? ML_COMMENT | ('('* | '*'*) ~[/*])*? '*'*? '*)' -> skip;
IDENT: [a-zA-Z_]+[a-zA-Z0-9_]*;

BOOL : 'true' | 'false';
IF : 'if';
THEN : 'then';
ELSE : 'else';
WHILE : 'while';
DO : 'do';
READ : 'read';
WRITE : 'write';
BEGIN : 'begin';
END : 'end';
COLON : ';';
SKIP_ : 'skip';

ASSIGN : ':=';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIVIDE : '/';
MOD : '%';
POW : '**';
GT : '>';
LT : '<';
GE : '>=';
LE : '<=';
EQ : '==';
NEQ : '!=';
AND : '&&';
OR : '||';
LBR : '(';
RBR : ')';
NEWLINE: [ \t\r\n] -> skip;
NOMATCHED: .;

program: stmt EOF;

stmt : SKIP_ | IDENT ASSIGN exp | stmt COLON stmt | WRITE LBR exp RBR | READ LBR IDENT RBR |
    while_statement | if_statement;

while_statement : WHILE LBR exp RBR DO stmt |
                            WHILE LBR exp RBR DO BEGIN stmt END;

if_statement : IF LBR exp RBR THEN stmt ELSE stmt |
                            IF LBR exp RBR THEN BEGIN stmt END ELSE BEGIN stmt END |
                            IF LBR exp RBR THEN stmt ELSE BEGIN stmt END |
                            IF LBR exp RBR THEN BEGIN stmt END ELSE stmt;

exp : LBR exp RBR
               | <assoc=right> exp POW exp
               | exp op=(MULT | DIVIDE | MOD) exp
               | exp op=(PLUS | MINUS) exp
               | exp op=(GT | GE | LT | LE) exp
               | exp op=(EQ | NEQ) exp
               | exp op=AND exp
               | exp op=OR exp
               | BOOL
               | IDENT
               | NUM;