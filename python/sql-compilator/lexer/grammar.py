from enum import Enum

class Grammar(Enum):
    ERR    = -2, #Erro

    #PALAVRAS CHAVE
    INSERT = 300
    UPDATE = 301
    DELETE = 302
    INTO   = 303
    SET    = 304
    WHERE  = 305
    FROM   = 306

    #OUTROS
    EOL    = 500 #Fim de Linha
    OPEN   = 501 #Parenteses Aberto
    CLOSE  = 502 #Parenteses Fechado
    COMMA  = 503 #Virgula
    EQUALS = 504 #Sinal de Igualdade

    #TIPOS
    ID     = 600
    STRING = 601
    NUMBER = 602