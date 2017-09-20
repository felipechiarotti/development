start = progr

//Production Rules
progr = _ cmd eol _nl progr
      / _ command:cmd endline:eol { return "Compilação feita com Sucesso!"; }

cmd = if __ expr __ then __nl cmd
    /  while __ expr __nl cmd
    /  begin __nl progr __nl end
    / scmd
    
expr = _ num _ plus expr
     / _ num _ minus expr 
     / num
     
scmd = _ write __ var
     / _ read __ var 
     / _ var _ eq _ expr
     
//Aux Rules
_ = [ \t]*
__ = [ \t]+
_nl = [ \n]*
__nl = [ \n]+
word = letter+
number = [0-9]
letter = [a-z]i
letter_number = [letter0-9]

//TOKENS
num "num" = digits:$([-]? number +([.] number+)?) { return { type: "NUM", value: parseFloat(digits) }; }
var "var" = chars:$(word letter_number*)   { return { type: "VAR", value: chars } }
eol       = ";" 	{ return { type: "EOL", value: null } }
eq	  = "=" 	{ return { type: "EQ", value: null } } 
plus	  = "+" 	{ return { type: "PLUS", value: null } }
minus	  = "-" 	{ return { type: "MINUS", value: null } }
if 	  = "if"i	{ return { type: "IF", value: null } }
then 	  = "then"i 	{ return { type: "THEN", value: null } }
while 	  = "while"i 	{ return { type: "WHILE", value: null } }
begin 	  = "begin"i 	{ return { type: "BEGIN", value: null } }
end	  = "end"i 	{ return { type: "END", value: null } }
write	  = "write"i 	{ return { type: "WRITE", value: null } }
read	  = "read"i	{ return { type: "READ", value: null } }
