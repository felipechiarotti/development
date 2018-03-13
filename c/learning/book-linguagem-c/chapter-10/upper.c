#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

void main(int argc, char *argv[]){
    FILE *fp;
    int buffer;

    switch(argc){
        case 1:
            fp = stdin;
        break;

        case 2:
            if( (fp = fopen(argv[1], "r")) == NULL){
                fprintf(stderr, "Erro");
                exit(2);
            }
        break;

    }

        while( (buffer = fgetc(fp)) != EOF ){
           putchar(toupper(buffer));
        }
}