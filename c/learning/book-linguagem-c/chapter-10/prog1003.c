#include <stdio.h>
#include <stdlib.h>

void main(int argc, char *argv[]){
    FILE *fp;
    char *buffer_name;
    int buffer_nota;

    if(argc == 2){
        if( (fp = fopen(argv[1], "r")) != NULL ){
            while( fscanf(fp, "%s\t%d", buffer_name, &buffer_nota) != EOF){
                printf("%s: %s\n", buffer_name, (buffer_nota>=5) ? "Aprovado" : "Reprovado");
            }
        }else{
            exit(2);
        }
    }else{
        exit(1);
    }
}