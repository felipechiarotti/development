#include <stdio.h>
#include <math.h>

void main(){
    int radius;
    double pi = 3.14159;

    scanf("%d",&radius);
    double volume = (4.0/3) * pi * pow((double)radius,3);
    
    printf("VOLUME = %0.3lf\n",volume);
}