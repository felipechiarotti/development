#include "semaphore.c"
#include <pthread.h>

struct Semaphore semaphore_mutex;
pthread_t threads[5];
int count = 0;
FILE* file;

int main(){
  file = fopen("sem-file.txt","r");
  int i;
  for(i = 0; i<5; i++){
    if(i%2==0){
      pthread_create(&threads[i],NULL,sum,NULL);
    }else{
      pthread_create(&threads[i],NULL,subtract,NULL);
    }
  }
  printf("%d",count);
}

void* sum(void* param){
  lock(semaphore_mutex);
  int a = count;
  a = a + fgetc(file);
  count = a;
  free_signal(semaphore_mutex);
}

void* subtract(void* param){
  lock(semaphore_mutex);
  int a = count;
  a = a - fgetc(file);
  count = a;
  free_signal(semaphore_mutex);
}