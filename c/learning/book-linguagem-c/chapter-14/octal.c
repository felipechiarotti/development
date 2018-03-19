#include <stdio.h>

void main(){
    int n;
    
    n = 10; // Valor em inteiro
    printf("Inteiro: %d\nOctal: %o\n\n", n, n);

    n = 010; // Valor em octal
    printf("Inteiro: %d\nOctal: %o\n", n, n);
}