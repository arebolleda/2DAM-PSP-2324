//Proceso que escribe en PIPE FIFO
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 


int main()
{
  int fp;
  char saludo[] = "Un saludo!!!\n";
  fp = open("FIFO2", 1);
 
  
  printf("Mandando información al pipe FIFO...\n");
  write(fp,saludo, strlen(saludo));
  close(fp);   
  return 0; 
}
