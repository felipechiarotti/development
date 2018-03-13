#include <stdio.h>

void main(){
    double nums[6];
    int positive_counter = 0;
    
    int i = 0;
    while(i < 6){
        scanf("%lf",&nums[i]);
        if((int)nums[i] > 0){

            positive_counter++;
        }
        i++;
    }

    printf("%d valores positivos\n",positive_counter);

}