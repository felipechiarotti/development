#include <stdio.h>

void main(){
    int end;
    scanf("%d", &end);
    int i;

    for(i = 1; i<=end; i+=2){
        printf("%d\n", i);
    }
}