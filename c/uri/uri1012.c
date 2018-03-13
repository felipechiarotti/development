#include <stdio.h>
#include <math.h>

void main(){
    double first_value, second_value, third_value;

    scanf("%lf %lf %lf", &first_value, &second_value, &third_value);

    double triangle_area = (first_value*third_value) / 2;
    double circle_area = 3.14159 * pow(third_value,2);
    double trapezio_area = ((first_value+second_value) * third_value) / 2;
    double square_area = pow(second_value,2);
    double rectangle_area = first_value*second_value;

    printf("TRIANGULO: %0.3lf\nCIRCULO: %0.3lf\nTRAPEZIO: %0.3lf\nQUADRADO: %0.3lf\nRETANGULO: %0.3lf\n",
        triangle_area,
        circle_area,
        trapezio_area,
        square_area,
        rectangle_area
    );
}