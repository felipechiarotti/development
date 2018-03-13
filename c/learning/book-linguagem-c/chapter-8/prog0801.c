#include <stdio.h>


void main(){
    int x[3] = {5, 3, 8};
    int *px = x; // PX tem o valor do ENDEREÇO de X;
    
    float y = 5.0;
    float *py = &y; // PY tem o valor do ENDEREÇO de Y;

    printf("%d %ld\n", x[0], (long) px);
    px++;
    printf("%d %ld\n", *px, (long)px);
}