from lexer.lexer import Lexer
from util.manage_file import ManageFile
import sys

file = ManageFile(sys.argv[1])
lexer = Lexer()

token = lexer.next_token()
while(token != Grammar.ERR):
    print (token)
    token = lexer.next_token()