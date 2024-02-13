import java.io.*;
import java.net.*;

public class TCPObjetoCliente1 {
  public static void main(String[] arg) throws IOException,
			ClassNotFoundException {
    String Host = "localhost";
    int Puerto = 6000;//puerto remoto	
		
    System.out.println("PROGRAMA CLIENTE INICIADO....");
    Socket cliente = new Socket(Host, Puerto);	
	
    //Flujo de entrada para objetos
    ObjectInputStream perEnt = new ObjectInputStream(
			             cliente.getInputStream());
    //Se recibe un objeto
    Persona dato = (Persona) perEnt.readObject();//recibo objeto
    System.out.println("Recibo: "+dato.getNombre()+"*"+dato.getEdad());
	
    //Modifico el objeto
    dato.setNombre("Juan Ramos");
    dato.setEdad(22);
	
    //FLUJO DE salida para objetos 		
    ObjectOutputStream perSal = new ObjectOutputStream(
			              cliente.getOutputStream());
    // Se envia el objeto
    perSal.writeObject(dato);
    System.out.println("Envio: "+dato.getNombre()+"*"+dato.getEdad());                       
		
    // CERRAR STREAMS Y SOCKETS
    perEnt.close();
    perSal.close();
    cliente.close();		
  }
}//..
