#include <stdio.h>

struct Semaphore{
    pthread_t fila[50];
    int estado = 0;
    int fila_size = -1;
};

void lock(struct Semaphore s){
    fila_size++;
    pthread_t locked = s.fila[fila_size];
    while(locked != s.fila[0]);
    estado = 1;
}

void free_signal(struct Semaphore s){
    int i;
    if(fila_size > 0){
        for(i = 0; i < fila_size; i++){
            fila[i] = fila[i+1];
        }
    }else{
        fila[0] = NULL;
    }
    fila_size--;
    estado = 0;
}