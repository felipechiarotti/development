#include <stdio.h>

void main(){
    int total_time;
    int hours = 0, minutes = 0, seconds = 0;
    scanf("%d", &total_time);

    int current_total_time = total_time;

    while(current_total_time > 0){
        if(current_total_time >= 3600){
            current_total_time -= 3600;
            hours++;
        }else if(current_total_time >= 60){
            current_total_time -= 60;
            minutes++;            
        }else{
            current_total_time -= 1;
            seconds++;
        }
    }
    printf("%d:%d:%d\n", hours, minutes, seconds);
}