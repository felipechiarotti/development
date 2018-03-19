#include <stdio.h>

void main(){
    int x, y;
    int maior, menor;
    int sum = 0, i;

    scanf("%d", &x);
    scanf("%d", &y);

    if(x > y){
        maior = x;
        menor = y;
    }else{
        maior = y;
        menor = x;
    }
     for(i = (menor+1); i < maior; i++ ){
        if(i%2 != 0){
            sum+= i;
        }
    }
    printf("%d\n", sum);
}