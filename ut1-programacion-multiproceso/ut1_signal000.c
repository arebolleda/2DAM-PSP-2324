#include <stdio.h> 
#include <signal.h> 
#include <stdlib.h>
#include <unistd.h>
  
int main() 
{ 
    signal(SIGINT, SIG_IGN); 
    while (1) 
    { 
        printf("hello world\n"); 
        sleep(1); 
    } 
    return 0; 
} 
