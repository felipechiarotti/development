#include <stdio.h>

void main(){
    double a, b, c;
    scanf("%lf%lf%lf", &a, &b, &c);

    double first_rule = b-c;

    if((b-c) < a && b+c > a && a-c < b && a+c > b && a-b < c && a+b>c){
        double perimetro = a+b+c;
        printf("Perimetro = %.1lf\n", perimetro);
    }else{
        double area = ((a+b) *c)/2;
        printf("Area = %.1lf\n", area);
    }
}