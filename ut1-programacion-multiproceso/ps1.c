/* Mostrar el pid y el ppid de un proceso */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void main()
{
   /*Zona declaración variables*/
   pid_t pid_proceso, pid_proceso_padre;
    


   /*Función getpid -> devuelve el pid del proceso en ejecución */
   pid_proceso=getpid();
   pid_proceso_padre=getppid();
   
   
   printf("PID del proceso actual es: %d \n",pid_proceso);
   printf("PID del proceso padre es: %d \n",pid_proceso_padre);
   
   

}
