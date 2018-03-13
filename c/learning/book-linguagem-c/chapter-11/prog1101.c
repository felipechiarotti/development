#include <stdio.h>
#include <string.h>

typedef struct Data{
    unsigned short int dia, ano;
    char mes[12];
} DATA;

typedef struct Pessoa{
    short int idade;
    char sexo, est_civil;
    char Nome[60];
    float salario;
    DATA dt_nasc;
} PESSOA;

typedef struct Person{
    char Mother[100], Father[100];
    char Dog[30];
} PERSON;


void Mostrar(struct Pessoa);

void main(){
PESSOA homem = {20, 'M', 'S', "Felipe", 400.00, {15,1997,"DEZ"}};

PERSON eu = {"Cintia Cristina Romanha Chiarotti", "Giovane Giron", "Lucky"};
Mostrar(homem);
}

void Mostrar(struct Pessoa x){
    printf("Nome: %s\n", x.Nome);
    printf("Idade: %d\n", x.idade);
}