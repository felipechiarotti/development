#include <stdio.h>

void main(){
    int i, j = 7;
    int tmp;

    for(i = 1; i <= 9; i+=2){
        tmp = j;
        for( ; j >= tmp-2; j-- ){
            printf("I=%d J=%d\n", i, j);
        }
        j = tmp + 2;
    }
}