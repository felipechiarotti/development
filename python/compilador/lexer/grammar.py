from enum import Enum

class Grammar(Enum):
    ERR    = -2,
    EOL    = 256
    VAR    = 259
    NUM    = 260
    PLUS   = 257
    PRINT  = 261
    EQUALS = 258
