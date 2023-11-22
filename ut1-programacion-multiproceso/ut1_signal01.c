#include<stdio.h>
#include<signal.h>
#include<unistd.h>

//Función de manejo de la señal
void sig_handler(int signo)
{
  if (signo == SIGINT)
    printf("He recibido señal SIGINT\n");
}


int main(void)
{
  signal(SIGINT, sig_handler);
 //Bucle infinito proceso queda a la espera de la señal
  while(1) 
    sleep(1);
  return 0;
}
