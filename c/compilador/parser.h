#include "lexer.h"
#include <string.h>
static struct Token token;
int line = 0;

void match(int terminal){ // Verifica se o token atual é o mesmo analisado e vai pro proximo token
    if(token.valor == terminal){
        token = getToken();
    }else{
        printf("Syntax Error");
    }
}

void terminal(){ // Verifica se é um terminal (Numero), se for, vai pro proximo Token
    if(token.id == "num"){
        char digit[100];
        sprintf(digit, "%d", token.valor);
        for(int i = 0; i < strlen(digit); i++){
            if(!isdigit(digit[i])){
                printf("     [Syntax Error]: Um Dígito era esperado.");
                return;
            }
        }
        printf("%d",token.valor);
        match(token.valor);
    }else{
         printf("     [Syntax Error]: Um Dígito era esperado.");
         while(1){
             if(token.valor == -1){
                 break;
             }
             token = getToken();
         }   
    }

}

void expression(){ // Analisa uma Expressão e o resultado são as simplificações
    line++;
    printf("[%d] ", line);
    terminal();
    while(1){
        if(token.id == "sign"){ // Se forem sinais
            printf("%c",token.valor);
            match(token.valor); //Pega o proximo token
            terminal();
        }else if(token.valor != -1){
            printf("       [Syntax Error]: Um sinal de operação era esperado\n",line);
            return;
        }else{
            printf("\n");
            return;
        }
    }
}

void runParser(){
    token = getToken();
    do{
        expression();
        token = getToken();
    }while(endFile() == 0);
}
