#include <stdio.h>
#include <stdlib.h>

void main(int argc, char *argv[]){
    FILE *fpin;
    FILE *fpout;
    int buffer;

    if(argc == 3){
        if( ((fpin = fopen(argv[1], "rb")) != NULL) && ((fpout = fopen(argv[2], "wb")) != NULL) ){
           while( fscanf(fpin, "%c", &buffer) != EOF ){
               fprintf(fpout, "%c-", buffer);
           }    
           fclose(fpin);
           fclose(fpout);
        }else{
            printf("Arquivo nao encontrado\n");
            exit(2);
        }


    }else{
        printf("Argumentos invalidos: %s originfile destfile\n", argv[0]);
        exit(1);
    }
}