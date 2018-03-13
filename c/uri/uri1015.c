#include <stdio.h>
#include <math.h>

void main(){
    double x1, x2, y1, y2;

    scanf("%lf %lf", &x1, &y1);
    scanf("%lf %lf", &x2, &y2);
    
    double first_part = pow(x2-x1,2);
    double second_part = pow(y2-y1,2);
    double result = pow(first_part + second_part,0.5);
    printf("%0.4lf\n", result);

}