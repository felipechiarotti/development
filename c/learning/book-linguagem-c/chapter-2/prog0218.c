#include <stdio.h>

void main(){
    long int total_seconds;
    scanf("%ld", &total_seconds);

    printf("Hora(s): %d\n", (int)total_seconds/3600);
    printf("Minuto(s): %d\n", (int)(total_seconds%3600)/60);
    printf("Segundo(s): %d\n", (int)total_seconds % 60);
}