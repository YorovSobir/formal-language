grammar L;

NEWLINE: [ \t\r\n] -> skip;
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

fragment INTEGER: '-'? ('0' | DIGIT DIGIT0* ('e' ('+' | '-')? DIGIT0*)? );
fragment DOUBLE_WITH_INT: '-'? ('0' | (DIGIT DIGIT0*)) '.' DIGIT0* ('e' ('+' | '-')? DIGIT0*)?;
fragment DOUBLE_WITHOUT_INT: '-'? '.' DIGIT0+ ('e' ('+' | '-')? DIGIT0*)?;
fragment DIGIT : [1-9];
fragment DIGIT0 : [0-9];
NUM: INTEGER|DOUBLE_WITH_INT|DOUBLE_WITHOUT_INT;
COMMENT: '//' ~[\r\n]* -> skip;
ML_COMMENT: '(*' ('('*? ML_COMMENT | ('('* | '*'*) ~[/*])*? '*'*? '*)' -> skip;
IDENT: [a-zA-Z_]+[a-zA-Z0-9_]*;

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
ASSIGN : ':=';
LBR : '(';
RBR : ')';
NOMATCHED: .;


program: stmt EOF;

stmt : SKIP_                       #SkipStmt
      | stmt COLON stmt            #ColonStmt
      | while_stmt                 #WhileStmt
      | if_stmt                    #IfStmt
      | WRITE LBR exp RBR          #WriteStmt
      | READ LBR IDENT RBR         #ReadStmt
      | IDENT ASSIGN exp           #AssignStmt
      ;

while_stmt :   WHILE LBR exp RBR DO stmt
              | WHILE LBR exp RBR DO BEGIN stmt END;

if_stmt :     IF LBR exp RBR THEN stmt ELSE stmt
                          | IF LBR exp RBR THEN BEGIN stmt END ELSE BEGIN stmt END
                          | IF LBR exp RBR THEN stmt ELSE BEGIN stmt END
                          | IF LBR exp RBR THEN BEGIN stmt END ELSE stmt;

exp :              LBR exp RBR                                              #InnerExp
                 | exp op=(MULT | DIVIDE | MOD) exp                         #MultExp
                 | exp op=(MINUS | PLUS) exp                                #AlgSumExp
                 | exp op=(GT | GE | LT | LE | NEQ | EQ | AND | OR) exp     #CompareExp
                 | BOOL                                                     #BoolExp
                 | IDENT                                                    #IdentExp
                 | NUM                                                      #NumExp
                 ;

