#include <stdio.h>

void main(){
    int total_days;
    int years = 0, months = 0, days = 0;
    scanf("%d", &total_days);

    int current_total_days = total_days;

    while(current_total_days > 0){
        if(current_total_days >= 365){
            current_total_days -= 365;
            years++;
        }else if(current_total_days >= 30){
            current_total_days -= 30;
            months++;            
        }else{
            current_total_days -= 1;
            days++;
        }
    }
    printf("%d ano(s)\n%d mes(es)\n%d dia(s)\n", years, months, days);
}