#include <stdio.h>
#include <math.h>


void main(){
    double a,b,c;
    double delta;
    double first_result;
    double second_result;

    scanf("%lf%lf%lf",&a,&b,&c);
    delta = pow(pow(b,2) - (4*a*c),0.5);
    if(delta >= 0 && a){
        first_result = (-b + delta)/(2*a);
        second_result = (-b - delta)/(2*a);
        printf("R1 = %.5lf\n",first_result);
        printf("R2 = %.5lf\n",second_result);
    }else{
        printf("Impossivel calcular\n");
    }

}