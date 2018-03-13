#include <stdio.h>

void main(){
    double salary;

    scanf("%lf",&salary);
    double foo_salary = salary;

    if(salary > 2000.00 && salary <= 3000.00){
        foo_salary -= 2000.00;
        foo_salary = foo_salary * 0.08;
    }else if(salary > 3000.00 && salary <= 4500.00){
        foo_salary -= 3000;
        foo_salary = foo_salary * 0.18 + (1000*0.08);
    }else if(salary > 4500.00){
        foo_salary -= 4500;
        foo_salary = foo_salary * 0.28 + (1000*0.08) + (1500 * 0.18);
    }else{
        puts("Isento");
        return;
    }
    printf("R$ %.2lf\n", foo_salary);
}