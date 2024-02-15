import java.io.*;
import java.net.*;

public class ServidorSocketMultithreaded {

    public static void main(String[] args) {
        final int puerto = 12345;

        try {
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto " + puerto);

            while (true) {
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clienteSocket.getInetAddress().getHostAddress());

                // Crear un nuevo hilo para manejar la conexión con el cliente
                Thread clienteThread = new ClienteThread(clienteSocket);
                clienteThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClienteThread extends Thread {
    private Socket clienteSocket;

    public ClienteThread(Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }

    @Override
    public void run() {
        try {
            InputStream entrada = clienteSocket.getInputStream();
            OutputStream salida = clienteSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = entrada.read(buffer)) != -1) {
                salida.write(buffer, 0, bytesRead);
            }

            clienteSocket.close();
            System.out.println("Cliente desconectado: " + clienteSocket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



