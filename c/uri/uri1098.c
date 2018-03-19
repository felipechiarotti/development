#include <stdio.h>

void main(){
    double i, j;

    for(i = 0.0; i <= 2.0; i+=0.2){
        for(j = 1+i; j <= (i+1)+2; j++){
            if(i - (int) i == 0.0){
                printf("I=%d J=%d\n", (int)i, (int)j);
            }else{
                printf("I=%.1lf J=%.1lf\n", i, j);
            }
        }
    }
}