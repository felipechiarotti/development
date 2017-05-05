from lexer.lexer import Lexer

lexer = Lexer()
while(True):
    token = lexer.next_token()
    if(token.type != -1):
        print(token.value)
    else:
        break