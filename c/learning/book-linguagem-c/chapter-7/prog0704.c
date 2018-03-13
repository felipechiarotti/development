#include <stdio.h>
#include <string.h>

void main(){
    char nome[100];
    do{
        fgets(nome, sizeof(nome), stdin);
        if(nome[0] == '\n'){
            break;
        }
        printf("%s",nome);
    }
    while(1);
}