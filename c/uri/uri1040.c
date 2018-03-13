#include <stdio.h>


void main(){
    double n1, n2, n3, n4;
    scanf("%lf%lf%lf%lf", &n1, &n2, &n3, &n4);

    double final_result = (n1*2+n2*3+n3*4+n4*1)/10;
    printf("Media: %.1lf\n", final_result);

    if(final_result < 5.0){
        printf("Aluno reprovado.\n");
    }else if(final_result >= 7.0){
        printf("Aluno aprovado.\n");
    }else{
        printf("Aluno em exame.\n");
        double final_exam;
        scanf("%lf",&final_exam);
        printf("Nota do exame: %.1lf\n",final_exam);

        final_result = (final_result + final_exam) / 2;
        if(final_result >= 5.0){
            printf("Aluno aprovado.\n");
        }else{
            printf("Aluno reprovado.\n");
        }
        printf("Media final: %.1lf\n",final_result);
    }

}