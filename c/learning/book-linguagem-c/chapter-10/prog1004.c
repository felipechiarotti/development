#include <stdio.h>
#include <stdlib.h>

void main(){
    FILE *fp;
    int i = 0, vector[10];

    while(i<10){
        scanf("%d", &vector[i]);
        i++;
    }

    if( (fp = fopen("DADOS.DAT", "wb")) != NULL){
        if( fwrite(vector, sizeof(int), 10, fp) != 10){
            fprintf(stderr, "Nao foi possivel escrever todos os elementos");
        }
    }else{
        exit(1);
    }
    fclose(fp);
}