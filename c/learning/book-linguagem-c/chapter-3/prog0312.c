#include <stdio.h>

void main(){
    char estado_civil;
    scanf("%c",&estado_civil);

    switch(estado_civil){
        case 'c':
        case 'C':
            printf("Casado");
        break;

        case 's':
        case 'S':
            printf("Solteiro");
        break;

        case 'd':
        case 'D':
            printf("Divorciado");
        break;

        case 'v':
        case 'V':
            printf("Viuvo");
        break;

        default:
            printf("Estado Civil informado incorreto!");
    }
}