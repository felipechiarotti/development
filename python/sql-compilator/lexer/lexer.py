import sys
from lexer.symbol_table import SymbolTable
from lexer.token import Token
from lexer.grammar import Grammar
from lexer.symbol import Symbol

class Lexer:
    def __init__(self):
        self.char_peek = ' '
        self.symbol_table = SymbolTable()
        self.buffer = [Buffer(), Buffer()]
        variavel = INSQ
          [E][R][T]
    def next_token(self):
        token = Token()
        if(len(self.line_data) > 0):
            peek = self.next_char()
            while (peek == ' ' and len(self.line_data) > 0):
                peek = self.next_char()
            while(peek == '\n' and len(self.line_data) > 0):
                peek = self.next_char()
            if str(peek).isdigit():
                sum = peek
                peek = self.next_char()
                while peek.isdigit():
                    sum = (int(sum) * 10) + int(peek)
                    peek = self.next_char()
                self.char_pos = self.char_pos - 1
                token.set_type(Grammar.NUM.value)
                token.set_value(sum)
            elif peek == '$':
                peek = self.next_char()
                aux_string = ''
                while peek.isalpha():
                    aux_string = aux_string + peek
                    peek = self.next_char()
                self.char_pos = self.char_pos - 1
                token.set_type(Grammar.VAR.value)
                token.set_value(self.symbol_table.add_symbol( Symbol(Grammar.VAR.value,0,aux_string,False) ))
            elif str(peek).isalpha():
                reserved_keyword = ''
                while str(peek).isalpha():
                    reserved_keyword = reserved_keyword + str(peek)
                    peek = self.next_char()
                self.char_pos = self.char_pos - 1
                if(reserved_keyword == "print"):
                    s_type = Grammar.PRINT.value
                    token.set_type(Grammar.PRINT.value)
                else:
                    return token

                symbol = Symbol(s_type,0,reserved_keyword,True)
                token.value = self.symbol_table.add_symbol(symbol)
            elif peek == '+':
                token.type = Grammar.PLUS.value
                token.value = 0
            elif peek == '=':
                token.type = Grammar.EQUALS.value
                token.value = 0
            elif peek == ';':
                token.type = Grammar.EOL.value
                token.value = 0
        return token

