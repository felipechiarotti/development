#include <stdio.h>


typedef struct{
    char Nome[60];
    int Idade;
} PESSOA;







void MostrarP(PESSOA p){
    printf("Nome: %s", p.Nome);
    printf("Idade: %d", p.Idade);
}

void MostrarP(PESSOA p[], int size){
    int i = 0;
    while(i < size){
        
        i++;
    }
}