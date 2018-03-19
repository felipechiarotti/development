#include <stdio.h>

void main(){
    int i = 0, n;
    int tmp_cobaia;
    int cobaias = 0, coelhos = 0, sapos = 0, ratos = 0;
    char tipo;

    scanf("%d", &n);

    while(i < n){
        scanf("%d %c", &tmp_cobaia, &tipo);
 
        cobaias += tmp_cobaia;    
        if(tipo == 'C') coelhos += tmp_cobaia;
        else if(tipo == 'R') ratos += tmp_cobaia;
        else sapos += tmp_cobaia;



        i++;
    }

    printf("Total: %d cobaias\n", cobaias);
    printf("Total de coelhos: %d\n", coelhos);
    printf("Total de ratos: %d\n",ratos);
    printf("Total de sapos: %d\n", sapos);
    printf("Percentual de coelhos: %.2lf %%\n", (double) ( (double)coelhos / (double)cobaias ) * 100 );
    printf("Percentual de ratos: %.2lf %%\n", (double) ( (double)ratos/ (double)cobaias)*100 );
    printf("Percentual de sapos: %.2lf %%\n", (double) ( (double)sapos/ (double)cobaias)*100 );
}