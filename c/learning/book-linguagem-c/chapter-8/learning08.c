#include <stdio.h>
#include <ctype.h>
char *strcp(char *orig, char *dest){
    char *init_dest = dest;
    printf("Before: %d\n", dest);
    while(*dest = *orig){
        dest++;
        orig++;
    }
    printf("After: %d\n", dest);
}

char *strch(char *str, char ch){
    while(*str != '\0'){
        if(*str != ch){
            str++;
        }else{
            return str;
        }
    }
    return NULL;
}

char *strlchr(char *s, char ch){
    char *tmp = NULL;
    while(*s != '\0'){
        printf("%c", *s);
        if(*s == ch){
            tmp = s;
        }
        s++;
    }
    return tmp;
}

char *strstr(char* str1, char *str2){
    char *init_str1 = str1;
    char *result = NULL;

    while(*str2 != '\0'){
        while(*str1 != '\0'){
            if(*str1 == *str2){
                while(*str1 == *str2){
                    str1++;
                    str2++;
                }
                if(*str1 == '\0'){
                    result = str2;
                    return result;
                }
            }
            str1++;
        }
        str1 = init_str1;
        str2++;
    }
    return NULL;
}

char *First_Vogal(char *s){
    while(*s != '\0'){
        if(strch("aeiou", *s)){
            return s; 
        }
        s++;
    }
    return NULL;
}

char *StrDelUpper( char *s ){
    char *init, *ptr;
    init = ptr = s;

    while(*s){
        if(!isupper(*s)){
            *ptr = *s;
            ptr++;
        }
        s++;
    }
    *ptr = '\0';
    return init;u
}



void main(){
    char nome[10] = "FeLiPe";
    printf("%s", nome);
}