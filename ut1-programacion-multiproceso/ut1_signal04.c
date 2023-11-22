//Comumicación procesos padre/hijo con señales
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include<signal.h>

//Función manejador señal padre
void sig_handler_parent(int signum){
  printf("Padre : recibida señal del proceso hijo %d \n",getpid());
}

//Función manejador señal hijo
void sig_handler_child(int signum){
  printf("Hijo : recibida señal del proceso padre %d \n",getppid());
  sleep(5);
  printf("Hijo : enviando señal al proceso padre %d \n",getppid());
  kill(getppid(),SIGUSR1);
}

int main(){
  pid_t pid;
  pid=fork();
  
  if(pid<0){
    printf("Fork Error\n");
    exit(1);
  }
  /* Proceso hijo*/
  else if(pid==0){
    signal(SIGUSR1,sig_handler_child); 
    printf("Hijo: esperando señal ...\n");
    pause();
  }
  /* Proceso padre */
  else{
    signal(SIGUSR1,sig_handler_parent); 
    sleep(5);
    printf("Padre: enviando señal al proceso hijo\n");
    kill(pid,SIGUSR1);
    printf("Padre: esperando respuesta del proceso hijo\n");
    pause();
  }
  return 0;
}
