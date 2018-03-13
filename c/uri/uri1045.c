#include <stdio.h>
#include <math.h>

void main(){
    double value[3];
    scanf("%lf%lf%lf", &value[0], &value[1], &value[2]);

    int i;
    int j;
    double aux;
    for(i = 0; i<3; i++){
        for(j = 0; j<2; j++){
            if(value[j] < value[j+1]){
                aux = value[j];
                value[j] = value[j+1];
                value[j+1] = aux;
            } 
        }
    }
    
    if(value[0] >= value[1]+value[2]){
        printf("NAO FORMA TRIANGULO\n");
    }else{
        if( pow(value[0],2) == ( pow(value[1],2) + pow(value[2],2) ) ){
            printf("TRIANGULO RETANGULO\n");
        }
        if( pow(value[0],2) > ( pow(value[1],2) + pow(value[2],2) ) ){
            printf("TRIANGULO OBTUSANGULO\n");
        }
        if( pow(value[0],2) < ( pow(value[1],2) + pow(value[2],2) ) ){
            printf("TRIANGULO ACUTANGULO\n");
        }
        if( value[0] == value[1] && value[0] == value[2]){
            printf("TRIANGULO EQUILATERO\n");
        }else if( value[0] == value[1] || value[0] == value[2] || value[1] == value[2]){
            printf("TRIANGULO ISOSCELES\n");
        }
    }
}