#include <stdio.h>
#include <stdlib.h>

void main(){
    FILE *fp;
    
    if( (fp = fopen("DADOS.DAT", "rb")) == NULL ){
        exit(1);
    }
    fseek(fp, 0, SEEK_END);
    printf("%ld", ftell(fp));
    fclose(fp);
}