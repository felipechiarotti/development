#include <stdio.h>
#include <stdlib.h>

void main(){
    int i = 0, n;
    double tmp[3];
    double *result;

    scanf("%d", &n);
    result = (double *) malloc (n*sizeof(double));

    while ( i < n ) { 
        scanf("%lf %lf %lf", &tmp[0], &tmp[1], &tmp[2]);
       *result = (tmp[0]*2+tmp[1]*3+tmp[2]*5)/10.0;
        i++;
        result++;    
    }

    
    i=0;
    while(i < n){
        printf("%.1lf\n", *(result-n+i));
        i++;
    }
}