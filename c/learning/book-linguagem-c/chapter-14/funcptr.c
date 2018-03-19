#include <stdio.h>

int Quadrado(int x){
    return x*x;
}

void imprime_especial( int (*f)(int), int value){
    printf("%d", (*f)(value));
}

void main(){
    int (*funcao)(int);
    funcao = Quadrado;

    imprime_especial(funcao,3);
}