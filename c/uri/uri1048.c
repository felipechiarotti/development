#include <stdio.h>


void main(){
    double salary;
    double percent = 0.04;

    scanf("%lf", &salary);

    if(salary <= 400.00){
        percent = 0.15;
    }else if(salary <= 800.00){
        percent = 0.12;
    }else if(salary <= 1200.00){
        percent = 0.1;
    }else if(salary <= 2000.00){
        percent = 0.07;
    }

    double new_salary = salary * (percent + 1.0);

    printf("Novo salario: %.2lf\n", new_salary);
    printf("Reajuste ganho: %.2lf\n", new_salary - salary);
    printf("Em percentual: %d %%\n", (int)(percent*100));
}