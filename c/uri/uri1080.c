#include <stdio.h>
#define MAX 100

void main(){
    int n[MAX];
    int i = 0,pos;
    int maior = 0;

    while( i < MAX ){
        scanf("%d", &n[i]);
        if(n[i] > maior){
            pos = i;
            maior = n[i];
        }
        i++;
    }

    printf("%d\n%d\n", maior, pos+1);
}