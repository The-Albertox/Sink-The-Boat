package net.salesianos.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import net.salesianos.server.ClientHandler;

public class ServerApp {
    public static void main(String[] args) {
        final int PORT = 8082;
        Random random = new Random();

        int x = random.nextInt(10);
        int y = random.nextInt(10);

        // comentar esto , solo los dev deben usarlo popi 
        System.out.println("Servidor iniciado. Coordenadas generadas: X=" + x + ", Y=" + y);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Esperando conexiones...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(clientSocket, x, y);
                clientHandler.start();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
