#include <stdio.h>

void main(){
    int num[3];
    int aux_num[3];
    int aux;
    scanf("%d%d%d", &num[0], &num[1], &num[2]);

    int i;
    for(i = 0; i<3; i++){
        aux_num[i] = num[i];
    }
    int x;
    int y;
    for(x = 0; x<3; x++){
        for(y = 0; y<2; y++){
            if(num[y] > num[y+1]){
                aux = num[y];
                num[y] = num[y+1];
                num[y+1] = aux;
            }
        }
    }
    printf("%d\n%d\n%d\n",num[0], num[1], num[2]);
    printf("\n%d\n%d\n%d\n", aux_num[0], aux_num[1], aux_num[2]);
}