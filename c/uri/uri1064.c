#include <stdio.h>

void main(){
    double values[6];
    double positives[6];
    double average = 0;

    int i;
    int j = 0;
    for(i = 0; i<6; i++){
        scanf("%lf", &values[i]);
        if(values[i] > 0){
            positives[j] = values[i];
            j++;
        } 
    }

    printf("%d valores positivos\n", j);

    for(i = 0; i<j; i++){
        average += positives[i];
    }
    average /= j;
    
    printf("%.1lf\n", average);
}