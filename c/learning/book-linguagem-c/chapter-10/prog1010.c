#include <stdio.h>
#include <stdlib.h>

void main(){
    FILE *fp;
    double vector[10], result;
    int i = 0, pos;

    while(i<10){
        scanf("%lf", &vector[i]);
        i++;
    }

    if( (fp = fopen("DADOS.DAT", "w+b")) == NULL ){
        exit(1);
    }

    if( fwrite(vector, sizeof(double), 10, fp) != 10){
        exit(1);
    }

    printf("Qual valor deseja ver?: ");
    scanf("%d", &pos);

    fseek(fp, (long) (pos-1)*sizeof(double), SEEK_SET);
    fread(&result, sizeof(double), 1, fp);
    printf("O valor introduzido foi: %lf", result);

    rewind(fp);

    fread(&result, sizeof(double), 1, fp);
    printf("Posição 1: %lf", result);

    fseek(fp, -sizeof(double), SEEK_END);
    fread(&result, sizeof(double), 1, fp);
    printf("Posição %d: %lf", ftell(fp)/sizeof(double), result);

    fclose(fp);

}