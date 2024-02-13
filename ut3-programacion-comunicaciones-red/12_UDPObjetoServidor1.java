import java.io.*;
import java.net.*;

public class UDPObjetoServidor1 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                
                ByteArrayInputStream byteStream = new ByteArrayInputStream(receivePacket.getData());
                ObjectInputStream objectStream = new ObjectInputStream(byteStream);
                Object receivedObject = objectStream.readObject();
                
                // Procesar el objeto recibido
                System.out.println("Mensaje recibido del cliente: " + receivedObject.toString());
                
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                
                String response = "Mensaje recibido correctamente";
                sendData = response.getBytes();
                
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

