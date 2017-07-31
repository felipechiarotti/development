from enum import Enum

class Grammar(Enum):
    ERR    = -2,

    INSERT = 300
    UPDATE = 301
    DELETE = 302
    INTO   = 303
    SET    = 304
    WHERE  = 305
    FROM   = 306

    EOL    = 500
    OPEN   = 501
    CLOSE  = 502
    COMMA  = 503
    EQUALS = 504

    ID     = 600
    STRING = 601
    NUMBER = 602