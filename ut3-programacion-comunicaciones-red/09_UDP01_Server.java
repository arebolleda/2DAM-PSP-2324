
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP01_Server {
  public static void main(String[] argv) throws Exception {
    byte[] bufer = new byte[1024];//bufer para recibir el datagrama 
    
    //Asociacion del Socket al puerto
    DatagramSocket socket = new DatagramSocket(12345);   

    //Socket a la escucha ...
    System.out.println("Esperando Datagrama .......... ");  
    DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
    //Recepcion datagrama
    socket.receive(recibo);
    int bytesRec = recibo.getLength();
    String paquete= new String(recibo.getData());

    //Informacion relevante
    System.out.println("Numero de Bytes recibidos: "+ bytesRec);    
    System.out.println("Contenido del Paquete    : "+ paquete.trim());
    System.out.println("Puerto origen del mensaje: "+ recibo.getPort());
    System.out.println("IP de origen             : "+ recibo.getAddress().getHostAddress());   
    System.out.println("Puerto destino del mensaje:" + socket.getLocalPort());	
    
    socket.close(); 
  }
}
