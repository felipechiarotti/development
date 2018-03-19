#include <stdio.h>

void main(){
    int i = 0, n;
    int values[10000];


    scanf("%d", &n);
    while(i < n){
        scanf("%d", &values[i]);
        i++;
    }

    i = 0;
    while( i < n ){
        if(values[i] != 0){
            if(values[i] % 2 == 0){
                printf("EVEN ");
            }else{
                printf("ODD ");
            }
            if(values[i] > 0){
                printf("POSITIVE\n");
            }else{
                printf("NEGATIVE\n");
            }
        }else{
            printf("NULL\n");
        }
        i++;
    }
}