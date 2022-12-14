#include <stdlib.h>
#include <stdio.h>
#include <threads.h>
#include <string.h>
#include <semaphore.h>

pthread_mutex_t mutex;
sem_t db;  // accès à la db
int readcount=0; // nombre de readers
sem_init(&db, 0, 1);

pthread_mutex_t mutex_readcount; //protège readcount
pthread_mutex_t mutex_writecount; //protège writecount 

sem_t wsem; //accès exckusif à la db
sem_t rsem; //pour bloquer les readers 

int readCount = 0;
int writeCount = 0;
sem_init(&wsem, 0, 1);
sem_init(&rsem, 0, 1);

void writer(void){
    while(1){
        pthread_mutex_lock(&mutex_writecount);
        writeCount++;
        if (writeCount == 1){
            sem_wait(&rsem);
        }
        pthread_mutex_unlock(&mutex_writecount);
        prepare_data();
        sem_wait(&wsem);
        write_database();
        sem_post(&wsem);
        pthread_mutex_lock(&mutex_writecount);
        writeCount--;
        if (writeCount == 0){
            sem_post(&rsem);
        }
        pthread_mutex_unlock(&mutex_writecount);
        sem_post(&rsem);
    }
}

void reader(void){
    while(1){
        pthread_mutex_lock(&mutex_readcount);
        // section critique
        readCount++;
        if (readCount==1){ // arrivée du premier reader
            sem_wait(&wsem);
        }
        pthread_mutex_unlock(&mutex_readcount);
        sem_wait(&rsem);
        read_database();
        sem_post(&rsem);
        pthread_mutex_lock(&mutex_readcount);
        // section critique
        readCount--;
        if(readCount==0){ // départ du dernier reader
            sem_post(&wsem);
        }
        pthread_mutex_unlock(&mutex_readcount);
        process_data();
    }  
}

int main(int argc, char const *argv[])
{
    /* code */
    int d = atoi(argv[1]);
    return 0;
}
