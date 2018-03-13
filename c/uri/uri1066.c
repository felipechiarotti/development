#include <stdio.h>
#define VEC_SIZE 5

void main(){
    int values[VEC_SIZE];
    int i;
    int count_par = 0, count_impar = 0, count_pos = 0, count_neg = 0;

    for( i = 0; i < VEC_SIZE; i++ ){
        scanf("%d", &values[i]);
        if(values[i] % 2 == 0){
            count_par++;
        }else{
            count_impar++;
        }
        if(values[i] > 0){
            count_pos++;
        }else{
            if(values[i] != 0){
                count_neg++;
            }
        }
    }

    printf("%d valor(es) par(es)\n", count_par);
    printf("%d valor(es) impar(es)\n", count_impar);
    printf("%d valor(es) positivo(s)\n", count_pos);
    printf("%d valor(es) negativo(s)\n", count_neg);
}