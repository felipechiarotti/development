#include <stdio.h>

enum dias {segunda, terca, quarta, quinta ,sexta, sabado, domingo};
enum mes {janeiro=1, fevereiro=2, marco=3};

void main(){
    int a,b;

    a = segunda;
    b = terca;
    a++;
    if( a == terca ){
        puts("Estamos na terca feira");
    }

    a = fevereiro;
    if(a == 2){
        puts("E em fevereiro");
    }
}