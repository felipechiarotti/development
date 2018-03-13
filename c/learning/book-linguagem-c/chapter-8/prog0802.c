#include <stdio.h>

void main(){
    char s[100];
    char *ptr = s; // Aponta para o primeiro endereco de memoria do vetor s;

    printf("Introduza uma String: ");
    fgets(s, sizeof(s), stdin);

    if(*ptr == '\0') return;

    while(*ptr != '\0'){
        putchar(*ptr++);
    }
}