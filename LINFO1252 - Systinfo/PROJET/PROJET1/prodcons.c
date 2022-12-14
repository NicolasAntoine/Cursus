#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <unistd.h>
#include <semaphore.h>

// Initialisation
#define N 8 // places dans le buffer
pthread_mutex_t mutex;
sem_t empty;
sem_t full;

// Producteur
void producer(void)
{
  int item;
  while(true)
  {
    item=produce(item);
    sem_wait(&empty); // attente d'une place libre
    pthread_mutex_lock(&mutex);
     // section critique
     insert_item();
    pthread_mutex_unlock(&mutex);
    sem_post(&full); // il y a une place remplie en plus
  }
}

// Consommateur
void consumer(void)
{
 int item;
 while(true)
 {
   sem_wait(&full); // attente d'une place remplie
   pthread_mutex_lock(&mutex);
    // section critique
    item=remove(item);
   pthread_mutex_unlock(&mutex);
   sem_post(&empty); // il y a une place libre en plus
 }
}

int main(int argc, char const *argv[])
{
    /* code */
    pthread_mutex_init(&mutex, NULL); 
    sem_init(&empty, 0 , N);  // buffer vide
    sem_init(&full, 0 , 0);   // buffer vide

    

    return 0;
}