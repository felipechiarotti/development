#include <stdio.h>

struct Semaphore{
    pthread_t fila[50];
    int estado = 0;
    int fila_size = -1;
};

void semaphore_init(struct Semaphore s){
    s.estado = 0;
    s.fila_size = -1;
}

void lock(struct Semaphore s, pthread_t thread){
    s.fila_size++;
    s.fila[s.fila_size] = thread;
    pthread_t locked = thread;
    while(locked != s.fila[0]);
    s.estado = 1;
}

void free_signal(struct Semaphore s){
    int i;
    if(s.fila_size > 0){
        for(i = 0; i < s.fila_size; i++){
            s.fila[i] = s.fila[i+1];
        }
    }else{
        s.fila[0] = NULL;
    }
    s.fila_size--;
    s.estado = 0;
}