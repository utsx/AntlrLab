grammar lang;

program     : 'begin' stat+ 'end' ;
stat    : assign
        | init
	    | add
	    | sub
	    | print
	    | multi
	    | compare
	    | division
	    ;

init: 'init' type=('INT' | 'STRING') ID '=' arg=(ID | INT | STRING);
assign      : 'let' ID 'be' arg=(ID | INT | STRING) ;
add         : 'add' arg=(INT | ID | STRING) 'to' ID;
sub         : 'sub' arg=(INT | ID) 'from' ID;
division: 'dev' arg=(INT | ID) 'on' ID;
multi: 'multi' arg=(INT | ID) 'on' ID;
compare:    'compare' expr;
print       : 'print' arg=(INT | ID | STRING);




expr : ID op=('==' | '!=' | '>' | '<' | '>=' | '<=') arg=(ID | INT | STRING);


EQUAL : '==';
NOTEQUAL : '!=';
LESS : '<';
MORETHAN: '>';
LESSTHANOREQUALTO: '<=';
MORETHANOREQUALTO: '>=';

INT :   [0-9]+ ;
STRING : '"' .*? '"';
ID  :   [a-zA-Z]+ ;
WS  :   [ \r\t\n]+ -> skip;
