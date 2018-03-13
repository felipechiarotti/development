#include <stdio.h>

void main(){
    int a, b;
    scanf("%d%d", &a, &b);

    int bigger = a > b ? a : b;
    int smaller = a < b ? a : b;

    bigger % smaller ? printf("Nao sao Multiplos\n") : printf("Sao Multiplos\n");
}