grammar L;

program: seqStmt EOF;

seqStmt: seqStmt COLON seqStmt     #ColonStmt
          | stmt                   #Statement
          ;

stmt : BEGIN stmt END                                           #BeginEndStmt
      | SKIP_                                                   #Skip
      | IDENT ASSIGN exp                                        #Assign
      | WRITE LBR exp RBR                                       #Write
      | READ LBR IDENT RBR                                      #Read
      | WHILE LBR exp RBR DO sequenceStmt                       #While
      | IF LBR exp RBR THEN sequenceStmt ELSE sequenceStmt      #If
      ;

sequenceStmt: stmt                      #StmtFromSeq
              | BEGIN seqStmt END       #BeginEndSeqStmt
              ;

exp :      LBR exp RBR                                              #InnerExp
         | exp op=(MULT | DIVIDE | MOD) exp                         #MultExp
         | exp op=(PLUS | MINUS) exp                                #AlgSumExp
         | exp op=(GT | GE | LT | LE | NEQ | EQ | AND | OR) exp     #CompareExp
         | NUM                                                      #NumExp
         | BOOL                                                     #BoolExp
         | IDENT                                                    #IdentExp
         ;

SKIP_ : 'skip';
IF : 'if';
THEN : 'then';
ELSE : 'else';
WHILE : 'while';
DO : 'do';
READ : 'read';
WRITE : 'write';
BEGIN : 'begin';
END : 'end';

NUM: INTEGER|DOUBLE_WITH_INT|DOUBLE_WITHOUT_INT;
fragment INTEGER: '-'? ('0' | DIGIT DIGIT0* ('e' ('+' | '-')? DIGIT0*)? );
fragment DOUBLE_WITH_INT: '-'? ('0' | (DIGIT DIGIT0*)) '.' DIGIT0* ('e' ('+' | '-')? DIGIT0*)?;
fragment DOUBLE_WITHOUT_INT: '-'? '.' DIGIT0+ ('e' ('+' | '-')? DIGIT0*)?;
fragment DIGIT : [1-9];
fragment DIGIT0 : [0-9];

BOOL : 'true' | 'false';

IDENT: [a-zA-Z_]+[a-zA-Z0-9_]*;

ASSIGN : ':=';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIVIDE : '/';
MOD : '%';
POW : '**';
EQ : '==';
NEQ : '!=';
GT : '>';
GE : '>=';
LT : '<';
LE : '<=';
AND : '&&';
OR : '||';

LBR : '(';
RBR : ')';

COLON : ';';


COMMENT: '//' ~[\r\n]* -> skip;
ML_COMMENT: '(*' ('('*? ML_COMMENT | ('('* | '*'*) ~[/*])*? '*'*? '*)' -> skip;

NEWLINE: [ \t\r\n] -> skip;