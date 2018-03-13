#include <stdio.h>

void main(){
    int start_day, finish_day;
    int start_time[3], finish_time[3];
    int days, hours, minutes, seconds;

    scanf("Dia %d", &start_day);
    scanf("%d : %d : %d\n", &start_time[0], &start_time[1], &start_time[2]);

    scanf("Dia %d", &finish_day);
    scanf("%d : %d : %d", &finish_time[0], &finish_time[1], &finish_time[2]);



    days = finish_day - start_day;

    if(finish_time[0] - start_time[0] >= 0){
        hours = finish_time[0] - start_time[0];
    }else{
        hours = 24 + *finish_time - *start_time;
        days--;
    }

    if(finish_time[1] - start_time[1] >= 0){
        minutes = finish_time[1] - start_time[1];
    }else{
        minutes = 60 + finish_time[1] - start_time[1];
        hours--;
    }

    if(finish_time[2] - start_time[2] >= 0){
        seconds = finish_time[2] - start_time[2];
    }else{
        seconds = 60 + finish_time[2] - start_time[2];
        minutes--;
    }

    printf("%d dia(s)\n", days);
    printf("%d hora(s)\n", hours);
    printf("%d minuto(s)\n", minutes);
    printf("%d segundo(s)\n", seconds);
}