grammar Antlr;
@header{
    package antlr.parser;
}
calc returns [int value]
    : expr { $value = $expr.value; }
    ;  
expr returns [int value]
    : NUM '+' e1=expr   {$value = Integer.parseInt($NUM.text) + $e1.value; }
    | NUM '*' e1=expr   {$value = Integer.parseInt($NUM.text) * $e1.value; }
    | NUM               {$value = Integer.parseInt($NUM.text);}
    ;
PLUS: '+';
SUM: '*';
WS: [ \t\n]* -> skip;
NUM: [0-9]+;