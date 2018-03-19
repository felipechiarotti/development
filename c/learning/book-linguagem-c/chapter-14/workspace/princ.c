#include <stdio.h>
#include "lib/arq1.h"
#include "lib/arq2.h"

int global_var;

void main(){
    int i = 2, j = 5;
    global_var = 3;
    
    printf("%d\n", f1(i));
    printf("%d\n", f2(j));

}