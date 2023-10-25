//Proceso que lee del PIPE FIFO
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 



int main(void)
{
  int fp;  
  int p, bytesleidos;
  char saludo[] = "Un saludo!!!\n", buffer[10];
 
  p=mkfifo("FIFO2", S_IFIFO|0666);//permiso de lectura y escritura

  
  while(1) {  
   fp = open("FIFO2", 0);  
   bytesleidos= read(fp, buffer, 1); 
   printf("Leyendo informacion del pipe FIFO2...");
   while (bytesleidos!=0){      
       printf("%1c", buffer[0]);    //leo un caracter 
       bytesleidos= read(fp, buffer, 1);//leo otro byte
   }
   close(fp);  
  }
  return(0);
}

