#include <stdio.h>

int strslen (char *);

void main(){
    char Nome[100];
    fgets(Nome, sizeof(Nome), stdin);

    printf("%d\n", strslen(Nome));
}

int strslen (char *str){
    char *ptr = str;
    while(*str != '\0' && *str != '\n'){
        str++;
    }
    return (int) (str - ptr);
}