#include <stdio.h>

void main(){
    int i = 0, n, in;
    int values[10000];
    
    scanf("%d", &n);

    while(i < n){
        scanf("%d", &values[i]);
        if(values[i] >= 10 && values[i] <= 20){
            in++;
        }
        i++;
    }
    printf("%d in\n%d out\n", in, n-in);
}