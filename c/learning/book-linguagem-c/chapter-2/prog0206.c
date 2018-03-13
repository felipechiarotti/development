#include <stdio.h>

void main(){
    unsigned short int age;
    unsigned int amount;
    unsigned long int num_conta;

    printf("Digite sua idade: ");
    scanf("%hd",&age);

    printf("Quantia desejada: ");
    scanf("%d",&amount);

    printf("Numero da conta: ");
    scanf("%ld",&num_conta);

    printf("Uma pessoa de %hu anos depositou R$%u na conta %lu\n",age,amount,num_conta);
}