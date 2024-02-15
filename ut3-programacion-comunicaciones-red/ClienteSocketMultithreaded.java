import java.io.*;
import java.net.*;

public class ClienteSocketMultithreaded {

    public static void main(String[] args) {
        final String servidorHost = "localhost";
        final int servidorPuerto = 12345;

        try {
            // Conectar al servidor
            Socket socket = new Socket(servidorHost, servidorPuerto);
            System.out.println("Conectado al servidor en " + servidorHost + ":" + servidorPuerto);

            // Obtener flujos de entrada y salida del socket
            OutputStream salida = socket.getOutputStream();
            InputStream entrada = socket.getInputStream();

            // Enviar datos al servidor
            String mensaje = "Hola, servidor!";
            salida.write(mensaje.getBytes());
            System.out.println("Mensaje enviado al servidor: " + mensaje);

            // Recibir datos del servidor
            byte[] buffer = new byte[1024];
            int bytesRead = entrada.read(buffer);
            String respuesta = new String(buffer, 0, bytesRead);
            System.out.println("Respuesta del servidor: " + respuesta);

            // Cerrar el socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

