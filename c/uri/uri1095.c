#include <stdio.h>


void main(){
    int i = 1, j = 60;

    for( ; j >= 0; i+=3, j-=5){
        printf("I=%d J=%d\n", i, j);
    }
}