#include <stdio.h>
#include <string.h>

void rmnl(char*);

void main(){
    char nome[50], sobrenome[50];
    printf("Introduza seu nome: ");  fgets(nome, sizeof(nome), stdin);
    printf("Introduza o seu sobrenome: "); fgets(sobrenome, sizeof(sobrenome), stdin);

    rmnl(nome);
    rmnl(sobrenome);

    printf("Nome: %s, %s\n", sobrenome, nome);
}

void rmnl (char* str){
    char *pos = strchr(str, '\n');
    if(pos != NULL){
        *pos = '\0';
    }
}