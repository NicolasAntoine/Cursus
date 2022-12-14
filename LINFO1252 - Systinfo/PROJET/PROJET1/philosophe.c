#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <unistd.h>

pthread_t* phil;
pthread_mutex_t* baguette;

typedef struct my_type{ //création d'une structure pour pouvoir mettre plusieurs éléments dans la création de chaque thread philosophe
  int nbPhil; //nombre de philosophes 
  int* a; //tableau d'éléments de taille nPhil 
  int index; //sert à garder le i du for pour pouvoir utiliser id[i] (de l'ancien code) avec x->a[x->index]
} my_type;

void mange(int id) {
  printf("Philosophe [%d] mange\n",id);
}

void* philosophe ( void* arg )
{
  int count = 0;
  my_type *x = (my_type*) arg;
  int id = x->a[x->index];
  int left = id;
  int right = (left + 1) % x->nbPhil;
  while(count <100000) {
    // philosophe pense
    if(left<right) {
      pthread_mutex_lock(&baguette[left]);
      pthread_mutex_lock(&baguette[right]);
    }
    else {
      pthread_mutex_lock(&baguette[right]);
      pthread_mutex_lock(&baguette[left]);
    }
    mange(id);
    pthread_mutex_unlock(&baguette[left]);
    pthread_mutex_unlock(&baguette[right]);
    count++;
  }
  printf("%d\n", count);
  return (NULL);
}

int main ( int argc, char *argv[])
{
    int d = atoi(argv[1]);
    long i;
    int id[d];
    srand(getpid());

    baguette = malloc(sizeof(pthread_mutex_t)*d);
    phil = malloc(sizeof(pthread_t)*d);
    my_type helper[d];
    
    // for (i = 0; i < d; i++)
    //     id[i]=i;

    for (i = 0; i < d; i++)
        pthread_mutex_init( &baguette[i], NULL);

    for (i = 0; i < d; i++) { 
        helper[i].a = malloc(sizeof(int)*d);
        for (long j = 0; j < d ; j++){
          helper[i].a[j] = j;
        }
        helper[i].nbPhil = d;
        helper[i].index = i;
        pthread_create(&phil[i], NULL, philosophe, &helper[i]);
    } 
    for (i = 0; i < d; i++)
        pthread_join(phil[i], NULL);

    return (EXIT_SUCCESS);
}