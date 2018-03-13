#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void removenl(char*);

void main(){
    char *str;

    str = (char *) malloc(10);
    fgets(str , 10, stdin);
    removenl(str);

    printf("%s - %p\n", str, str);

    str = (char *) realloc(str,16000);

    printf("%s - %p\n", str, str);

    free(str);
    printf("%s - %p\n", str, str);

}


void removenl(char *str){
    char *ptr = strchr(str, '\n');
    *ptr = '\0';
}