#include <stdio.h>
#include <string.h>

void main(){
    FILE *fp;
    char filename[100];

    puts("Introduza o nome do Arquivo: ");
    fgets(filename, sizeof(filename), stdin);
    char *chr = strchr(filename,'\n');
    *chr = '\0';

    fp = fopen(filename, "r");
    if(fp != NULL){
        printf("Arquivo %s aberto com sucesso!\n", filename);
        fclose(fp);
    }else{
        printf("Erro ao abrir arquivo!\n");
    }
}