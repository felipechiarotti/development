#include <stdio.h>
int calculate(int *, int);

void main(){
    int hundred = 0, fifty = 0, twenty = 0, ten = 0, five = 0, two = 0, one = 0;
    int money;
    scanf("%d", &money);

    int resting_money = money;

    hundred = calculate(&resting_money, 100);
    fifty = calculate(&resting_money, 50);
    twenty = calculate(&resting_money, 20);
    ten = calculate(&resting_money, 10);
    five = calculate(&resting_money, 5);
    two = calculate(&resting_money, 2);
    one = calculate(&resting_money, 1);
    printf("%d\n",money);
    printf("%d nota(s) de R$ 100,00\n", hundred);
    printf("%d nota(s) de R$ 50,00\n", fifty);
    printf("%d nota(s) de R$ 20,00\n", twenty);
    printf("%d nota(s) de R$ 10,00\n", ten);
    printf("%d nota(s) de R$ 5,00\n",five);
    printf("%d nota(s) de R$ 2,00\n", two);
    printf("%d nota(s) de R$ 1,00\n", one);
}

int calculate(int *resting_money, int value){
        int counter = 0;
        while((*resting_money % value >= 0) && (*resting_money >= value)){
            *resting_money-= value;
            counter++;

        }
        return counter;
}