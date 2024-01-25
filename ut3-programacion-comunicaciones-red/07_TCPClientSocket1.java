// 
// Clase Socket: sirve para implementar el lado del cliente de la conexión TCP
// Se crea un conector en el puerto del servidor que escuchará las peticiones de conexión de los clientes

import java.io.IOException;
import java.net.*;
public class TCPClientSocket1 {
  public static void main(String[] args) {
         String host="localhost";
         int puerto=5555;
        try 
        {

        Socket Cliente = new Socket(host,puerto); //Se crea socket de cliente y lo asocia al puerto indicado del host
        System.out.println("Cliente escuchando en: "+ Cliente.getLocalPort());
        System.out.println("Cliente conectado a puerto remoto: "+ Cliente.getPort());

        InetAddress ip=Cliente.getInetAddress();
        System.out.println("Máquina remota: "+ ip.getHostName().toString());
        System.out.println("IP Máquina remota: "+ ip.getHostAddress().toString());
        
        Cliente.close(); //Cierre del socket

         } catch (IOException excepcion) {excepcion.getMessage()	;  }
  }
  
}