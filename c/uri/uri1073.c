#include <stdio.h>
#include <math.h>

void main(){
    int i, n;

    scanf("%d", &n);
    for(i = 1; i <= n; i++){
        if(i%2 == 0){
            printf("%d^2 = %d\n", i, i*i);
        }
    }
}