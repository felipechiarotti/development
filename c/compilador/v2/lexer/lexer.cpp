struct Token{
    int value;
    int type;
}

int line = 0;
char peek = '';
int char_pos = 0;

Token next_token(void){
    Token t;
    t.type = -1;
    peek = next_char();
    if(peek == '\n'){
        char_pos = 0;
        line++;
        peek = next_char();
    }    

    while(peek == ' '){
        peek = next_char();
        continue;
    }


    if(isdigit(peek)){
        int aux_value = 0;
        do{
            aux_value = aux_value * 10 + (peek-48);
            peek = next_char();
        }while(isdigit(peek));   
        previous_char();     
        t.type = NUM;
        t.value = aux_value;
    }else if(peek == '$'){
        Symbol s;
        string var;
        do{
            var += peek;
            peek = next_char();
        }while(isalpha(peek));
        previous_char();
        s.type = VAR;
        s.value = 0;
        s.lexem = var;
        t.type = VAR;
        t.value = add_symbol(s);
    }else if(isalpha(peek)){
        Symbol s;
        string res;
        do{
            res += peek;
            peek = next_char();
        }while(isalpha(peek));
        previous_char();
        if(res == "print"){
            s.type = PRINT;
            t.type = PRINT;
        }else{
            return t;
        }
        s.value = 0;
        s.lexem = res;
        s.keyword = true;
        t.value = add_symbol(s);
    }else if(peek == '+'){
        t.type = PLUS;
        t.value = 0;
    }else if(peek == '='){
        t.type = EQUALS;
        t.value = 0;
    }else if(peek == ';'){
        t.type = EOL;
        t.value = 0;
    }
    return t;
}