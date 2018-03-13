#include <stdio.h>

void main(){
    double first_value, second_value, third_value;
    int first_value_weight = 2, second_value_weight = 3, third_value_weight = 5;

    scanf("%lf", &first_value);
    scanf("%lf", &second_value);
    scanf("%lf", &third_value);

    double result = ((first_value * first_value_weight) + (second_value * second_value_weight) + (third_value * third_value_weight)) / (first_value_weight+second_value_weight+third_value_weight);
    printf("MEDIA = %0.1lf\n", result);
}