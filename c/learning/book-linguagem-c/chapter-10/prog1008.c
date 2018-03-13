#include <stdio.h>
#include <stdlib.h>

void main(){
    FILE *fp;
    //int nBytes = 0;

    if( (fp = fopen("DADOS.DAT", "rb")) == NULL ){
        exit(1);
    }

    /*
    while( fgetc(fp) != EOF ){
        nBytes++;
    }
     printf("%d",nBytes);
    */

    while( fgetc(fp) != EOF );
    printf("%ld", ftell(fp));
   
}