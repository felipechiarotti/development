#include <stdio.h>

void main(){
    int start_time;
    int end_time;
    int start_minute;
    int end_minute;
    scanf("%d%d%d%d", &start_time, &start_minute, &end_time, &end_minute);

    int real_time = end_time - start_time < 0 ? end_time + 24 - start_time : end_time - start_time;
    int real_minutes;
    if(end_minute - start_minute < 0){
        real_time--;
        real_minutes = end_minute - start_minute + 60;
    }else{
        real_minutes = end_minute - start_minute;
    }
    if(real_time == 0 && real_minutes == 0){
        real_time = 24;
    
    printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", real_time, real_minutes);
}