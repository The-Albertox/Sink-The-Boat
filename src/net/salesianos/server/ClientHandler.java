package net.salesianos.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket clientSocket;
    private int x, y;
    private static final int MAX_INTENTOS = 3;

    public ClientHandler(Socket socket, int x, int y) {
        this.clientSocket = socket;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        try (DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream())) {

            System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

            for (int i = 0; i < MAX_INTENTOS; i++) {
                int userX = inputStream.readInt();
                int userY = inputStream.readInt();

                System.out.println("Cliente intentó: X=" + userX + ", Y=" + userY);

                if (userX == x && userY == y) {
                    outputStream.writeBoolean(true);
                    outputStream.flush();
                    System.out.println("¡Cliente acertó las coordenadas! Cerrando conexión...");
                    break;
                } else {
                    outputStream.writeBoolean(false);
                    outputStream.flush();
                }
            }

            System.out.println("Cliente agotó intentos o acertó. Cerrando conexión...");
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el socket del cliente.");
            }
        }
    }
}
