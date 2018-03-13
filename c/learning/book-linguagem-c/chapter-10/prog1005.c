#include <stdio.h>
#include <stdlib.h>

void main(){
    FILE *fp;
    int i, vector[10];

    if( (fp = fopen("DADOS.DAT", "rb")) == NULL ){
        exit(1);
    }

    if ((fread(vector, sizeof(int), 10, fp) != 10)){
        fprintf(stderr, "Impossivel ler 10 blocos");
        exit(1);
    }

    while(i<10){
        printf("%d\n",vector[i]);
        i++;
    }
}