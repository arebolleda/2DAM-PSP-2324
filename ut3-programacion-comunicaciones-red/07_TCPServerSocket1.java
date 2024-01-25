//  En aplicación cliente/Servidor, el programa servidor se ejecuta en una máquina específica y tiene un socket asociado a un puerto específico
// Clase ServerSocket: sirve para implementar el lado del Servidor
// Se crea un conector en el puerto del servidor que escuchará las peticiones de conexión de los clientes

import java.io.IOException;
import java.net.*;
public class TCPServerSocket1 {
  public static void main(String[] args) {
        int puerto=5555;
        try 
        {
        ServerSocket Servidor = new ServerSocket(puerto); //Se crea socket de servidor asociado al puerto
        System.out.println("Servidor escuchando en "+ Servidor.getLocalPort());
        Socket cliente1= Servidor.accept(); //Esperando conexión cliente
        /* Aquí irían todas las acciones a realizar con el cliente1
         
         */
        System.out.println("Cliente 1 conectado");
       // Socket cliente2= Servidor.accept(); //Esperando conexión cliente
        /* Aquí irían todas las acciones a realizar con el cliente2
         
         */

         Servidor.close(); //Cierre del socket

         } catch (IOException excepcion) {excepcion.getMessage()	;  }
  }
  
}

