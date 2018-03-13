#include <stdio.h>

void main(){
    int first_value, second_value, third_value;

    scanf("%d %d %d", &first_value, &second_value, &third_value);

    int bigger_value = 0;
    if(first_value > bigger_value){
        bigger_value = first_value;
    }
    if(second_value > bigger_value){
        bigger_value = second_value;
    }
    if(third_value > bigger_value){
        bigger_value = third_value;
    }

    printf("%d eh o maior\n", bigger_value);
}