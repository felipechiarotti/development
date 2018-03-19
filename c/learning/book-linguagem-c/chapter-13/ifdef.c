#include <stdio.h>

#define DEBUG

void main(){
    int i, n = 0;

    for(i = 1; i<10; i++){
        n = n+i;
        #ifdef DEBUG
            printf("Debug Ativado\n");
            printf("n=%d - i=%d\n", n, i);
        #endif
    }
}