#include <stdio.h>
#define VEC_SIZE 5

void main(){
    int values[VEC_SIZE];
    int i;
    int count = 0;

    for( i = 0; i < VEC_SIZE; i++ ){
        scanf("%d", &values[i]);
        if(values[i] % 2 == 0)
            count++;
    }
    printf("%d valores pares\n", count);
}