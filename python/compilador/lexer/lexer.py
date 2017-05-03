import sys
from lexer.symbol_table import SymbolTable
from lexer.token import Token
from lexer.grammar import Grammar
from lexer.symbol import Symbol
class Lexer:
    def __init__(self):
        self.analise_file = open(sys.argv[1],'r')
        self.line_number = 0
        self.char_peek = ' '
        self.char_pos = 0
        self.line_data = self.analise_file.readline()
        self.symbol_table = SymbolTable()

    def next_token(self):
        peek = ''
        token = Token()
        if(len(self.line_data) > 0):
            peek = self.next_char()
            while (peek == ' ' or peek == '\n'):
                peek = self.next_char()
                if peek == '\n':
                    self.char_pos = 0
                    self.line_number = self.line_number + 1
        if peek.isdigit():
            sum = 0;
            while str(peek).isdigit():
                sum = sum * 10 + int(peek);
                peek = self.next_char(); 
            self.char_pos = self.char_pos - 1  
            token.set_type(Grammar.NUM.value)
            token.set_value(sum)
        elif peek == '$':
            aux_string = '';
            while peek.isalpha():
                aux_string = aux_string + peek
                peek = self.next_char()
            self.char_pos = self.char_pos - 1
            token.set_type(Grammar.VAR.value)
            token.set_value(self.symbol_table.add_symbol( Symbol(Grammar.VAR.value,0,aux_string,False) ))
        elif peek.isalpha():
            reserved_keyword = '';
            while peek.isalpha():
                reserved_keyword = reserved_keyword + peek;
                peek = self.next_char();
            self.char_pos = self.char_pos - 1
            if(reserved_keyword == "print   "):
                s_type = Grammar.PRINT.value
                token.set_type(Grammar.PRINT.value)
            else:
                return token;

            symbol = Symbol(s_type,0,reserved_keyword,True)
            token.value = self.symbol_table.add_symbol(symbol)
        elif peek == '+':
            token.type = Grammar.PLUS.value;
            token.value = 0;
        elif peek == '=':
            token.type = Grammar.EQUALS.value;
            token.value = 0;
        elif peek == ';':
            token.type = Grammar.EOL.value;
            token.value = 0;
        return token;


    def next_char(self):
        if self.char_pos == len(self.line_data):
            self.line_data = self.analise_file.readline()
        else:
            self.char_pos = self.char_pos + 1
            return str(self.line_data[self.char_pos-1])