#include <stdio.h>

struct Pessoa{
    char Nome[30];
    int Idade;
    unsigned Sexo : 1;
    unsigned Est_Civil : 2;
};