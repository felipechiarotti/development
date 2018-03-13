#include <stdio.h>
#include <string.h>

void main(){


}

int strlen(char *s){
    int counter = 0;
    while(s[counter] != '\0'){
        counter++;
    }
    return counter;
}

int isnull(char *s){
    return (s[0] == '\0');
}

char *strcopy (char *dest, char *orig){
    int counter = 0;
    while(counter < strlen(orig)){
        dest[counter] = orig[counter];
        counter++;
    }
    dest[counter] = '\0';
    return dest;
}

char *strcat(char *dest, char *orig){
    int pos_orig, pos_dest;
    for(pos_orig = 0, pos_dest = strlen(dest); orig[pos_orig] != '\0'; pos_orig++){
        dest[pos_dest + pos_orig] = orig[pos_orig];
    }
    dest[pos_dest + pos_orig] = '\0';
    return dest;
}