#include <stdio.h>

void main(){
    double x,y;
    scanf("%lf%lf", &x, &y);

    int counter = 0;
    if(x>0 && y>0){
        counter = 1;
    }else if(x>0 && y<0){
        counter = 4;
    }else if(x<0 && y<0){
        counter = 3;
    }else if(x<0 && y>0){
        counter = 2;
    }else if(x==0){
        counter = -1;
    }else if(y==0){
        counter = -2;
    }
    
    if(counter){
        if(counter > 0){
            printf("Q%d\n",counter);
        }else{
            if(counter == -1){
                printf("Eixo X\n");
            }else{
                printf("Eixo Y\n");
            }
        }
    }else{
        printf("Origem\n");
    }
}