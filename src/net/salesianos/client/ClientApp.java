package net.salesianos.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        final String SERVER_IP = "localhost";
        final int SERVER_PORT = 8082;
        final int MAX_INTENTOS = 3;

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado al servidor. Intenta adivinar las coordenadas.");

            for (int i = 0; i < MAX_INTENTOS; i++) {
                System.out.println("Intento " + (i + 1) + ": Ingrese su coordenada X entre 0-9: ");
                int userX = scanner.nextInt();

                System.out.println("Ingrese su coordenada Y entre 0-9: ");
                int userY = scanner.nextInt();

                outputStream.writeInt(userX);
                outputStream.writeInt(userY);
                outputStream.flush();

                boolean acierto = inputStream.readBoolean();
                if (acierto) {
                    System.out
                            .println("se ha tocado(sonido del meme de la roca con la ceja) y hundidio el unico barco");
                    break;
                } else {
                    System.out.println("Coordenadas incorrectas");
                }
            }

            System.out.println("Fin del juego. Shutting down(con voz de torreta de portal)...");

        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
