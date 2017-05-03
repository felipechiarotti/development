from lexer.lexer import Lexer

lexer = Lexer()
token = lexer.next_token()
while(token.type != -1):
    print(token.value)
    token = lexer.next_token()