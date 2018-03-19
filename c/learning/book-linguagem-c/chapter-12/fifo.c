#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct sPessoa{
    int Idade;
    char Nome[20+1];
    struct sPessoa *Prox;
} PESSOA;

void Inserir(PESSOA**, int, char*);
void Init(PESSOA*);

void main(){
    PESSOA *fila;
    Init(fila);

    Inserir(&fila, 20, "Felipe");
}

void Init(PESSOA* Fila){
    Fila = NULL;
}

void Inserir(PESSOA** Fila, int idade, char *nome){
    if(*Fila == NULL){
        *Fila = (PESSOA*) malloc(sizeof(PESSOA));
        if(*Fila == NULL){
           return; 
        }
        (**Fila).Idade = idade;
        strcpy((**Fila).Nome, nome);
        (**Fila).Prox = NULL;
    }else{
        Inserir( & ((**Fila).Prox) , idade, nome);
    }
}
 
void Remover(PESSOA** Fila){
    if(*Fila == NULL){
        return;
    }
    PESSOA *tmp = *Fila;
    *Fila = (*Fila)->Prox;
    free(tmp);
}