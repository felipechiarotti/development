#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main(){
    char str[200];
    char *ptr;

    puts("Digite uma string:");
    fgets(str, sizeof(str) ,stdin);
    char *nl = strchr(str, '\n');
    *nl = '\0';
        
    ptr = (char *) malloc(strlen(str)+1);
    strcpy(ptr, str);
    printf("%s", ptr);
    free(ptr);
}