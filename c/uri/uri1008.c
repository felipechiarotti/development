#include <stdio.h>

void main(){
    int employer_id, employer_worked_hours;
    double employer_hour_amount;

    scanf("%d", &employer_id);
    scanf("%d", &employer_worked_hours);
    scanf("%lf", &employer_hour_amount);

    double employer_salary = employer_hour_amount * employer_worked_hours;

    printf("NUMBER = %d\n", employer_id);
    printf("SALARY = U$ %0.2lf\n", employer_salary);
}