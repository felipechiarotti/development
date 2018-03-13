#include <stdio.h>

void calculateCedula(double*, double, int);

void main(){
    double total_amount;

    scanf("%lf",&total_amount);

    double aux_amount = total_amount;

    printf("NOTAS:\n");
    calculateCedula(&aux_amount,100,0);
    calculateCedula(&aux_amount,50,0);
    calculateCedula(&aux_amount,20,0);
    calculateCedula(&aux_amount,10,0);
    calculateCedula(&aux_amount,5,0);
    calculateCedula(&aux_amount,2,0);

    aux_amount = aux_amount*100;

    printf("MOEDAS:\n");
    calculateCedula(&aux_amount,100,1);
    calculateCedula(&aux_amount,50,1);
    calculateCedula(&aux_amount,25,1);
    calculateCedula(&aux_amount,10,1);
    calculateCedula(&aux_amount,5,1);
    calculateCedula(&aux_amount,1,1);
}

void calculateCedula(double *aux_amount, double value, int op){
    int counter = 0;
    while(((int)*aux_amount % (int)value >= 0) && *aux_amount >= value){
        *aux_amount -= value;
        counter++;
    }
    printf("%d ", counter);
    if(op == 0){
        printf("nota(s) de R$ %0.2lf\n",value);
    }else{
        printf("moeda(s) de R$ %0.2lf\n",value/100);
    }
}