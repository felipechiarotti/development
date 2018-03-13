#include <stdio.h>
#define CONSUMPTION 12

void main(){
    int trip_time, average_speed;

    scanf("%d", &trip_time);
    scanf("%d", &average_speed);

    int kms_drove = trip_time * average_speed;
    double fuel_spent = (double)kms_drove / CONSUMPTION;
    printf("%0.3lf\n",fuel_spent);
}