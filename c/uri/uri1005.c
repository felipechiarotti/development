#include <stdio.h>

void main(){
    double first_value, second_value;

    scanf("%lf",&first_value);
    scanf("%lf",&second_value);

    double result = ((first_value*3.5) + (second_value*7.5)) / 11;
    printf("MEDIA = %0.5lf\n", result);
}