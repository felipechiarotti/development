#include <stdio.h>
#include <math.h>

void main(){
    int start_time;
    int finish_time;
    scanf("%d%d", &start_time, &finish_time);

    int total_time = finish_time - start_time < 0 ? finish_time + 24 - start_time : finish_time - start_time;
    printf("O JOGO DUROU %d HORA(S)\n", total_time == 0 ? 24 : total_time);
}