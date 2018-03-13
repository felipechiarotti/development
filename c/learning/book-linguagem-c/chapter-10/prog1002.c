#include <stdio.h>

void main(int argc, char **argv){
    FILE *fp;
    int buffer;

    if(argc > 1){
        fp = fopen(*(++argv), "r");
        if(fp != NULL){
            while((buffer = fgetc(fp)) != EOF){
                putchar(buffer);
            }
            fclose(fp);
        }else{
            puts("Arquivo nao encontrado");
            exit(2);
        }
    }else{
        puts("Argumento invalido");
        exit(1);
    }
}