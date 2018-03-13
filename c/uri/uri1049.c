#include <stdio.h>
#include <string.h>

#define AMOUNT_CAT 3

void main(){
    char categories[AMOUNT_CAT][20];

    int i;
    for(i = 0; i < AMOUNT_CAT; i++){
        fgets(categories[i], 20, stdin);
        char *pos = strchr(categories[i], '\n');
        if(pos != NULL){
            *pos = '\0';
        }
    }
    
    if(!strcmp("vertebrado",categories[0])){
        if(!strcmp("ave",categories[1])){
            if(!strcmp("carnivoro",categories[2])){
                puts("aguia");
            }else if(!strcmp("onivoro",categories[2])){
                puts("pomba");
            }
        }else if(!strcmp("mamifero",categories[1])){
            if(!strcmp("onivoro",categories[2])){
                puts("homem");
            }else if(!strcmp("herbivoro",categories[2])){
                puts("vaca");
            }
        }
    }else if(!strcmp("invertebrado",categories[0])){
        if(!strcmp("inseto",categories[1])){
            if(!strcmp("hematofago",categories[2])){
                puts("pulga");
            }else if(!strcmp("herbivoro",categories[2])){
                puts("lagarta");
            }
        }else if(!strcmp("anelideo",categories[1])){
            if(!strcmp("hematofago",categories[2])){
                puts("sanguessuga");
            }else if(!strcmp("onivoro",categories[2])){
                puts("minhoca");
            }
        }
    }
}