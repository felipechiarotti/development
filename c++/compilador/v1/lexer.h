#include "mfile.h"
#include <ctype.h>

#define NUM 256
#define SYM 257
#define VAR 258

struct Token{
    int valor;
    int tag;
    char* lexeme;
};

struct Token getToken(){
    int peek = 0;
    struct Token token;
    peek = getNextByte();
    if(peek == '\n'){
        break;
    }
    
    if(isdigit(peek)){
        int value = 0;
        do{
            value = value*10 + (peek-48);
            peek = getNextByte();
        }while(isdigit(peek));
        token.tag = SYM;
        token.valor = value;
        returnFilePointer();
    }else if(peek == '-' || peek == '+'){
        token.valor = peek;
        token.id = SYM;
    }
    return token;
}