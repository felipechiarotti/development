#include <stdio.h>

void main(){
    char employer_name;
    double employer_salary, employer_sales;
    int employer_sale_comission = 15;

    scanf("%s", &employer_name);
    scanf("%lf", &employer_salary);
    scanf("%lf", &employer_sales);

    double employer_salary_comissioned = employer_salary + (employer_sales* ((double)employer_sale_comission/100));
    printf("TOTAL = R$ %0.2lf\n",employer_salary_comissioned);
}