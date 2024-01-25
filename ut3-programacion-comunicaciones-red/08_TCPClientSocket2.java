import java.io.*;
import java.net.*;

public class TCPClientSocket2  {
  public static void main(String[] args) throws Exception {
	String Host = "localhost";
	int Puerto = 6666;//puerto remoto	
	
	System.out.println("PROGRAMA CLIENTE INICIADO....");
	Socket Cliente = new Socket(Host, Puerto);

	// Creación flujo de salida hacia el servidor
	DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

	
	flujoSalida.writeUTF("Saludos al SERVIDOR DESDE EL CLIENTE");

	// Creación flujo de entrada desde el servidor
	DataInputStream flujoEntrada = new  DataInputStream(Cliente.getInputStream());

	// 
	System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF());

	// CERRAR STREAMS Y SOCKETS	
	flujoEntrada.close();	
	flujoSalida.close();	
	Cliente.close();	
  }// main
}// 
