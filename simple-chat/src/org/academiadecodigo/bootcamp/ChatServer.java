package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    private static int port = 9876;
    private static ServerSocket serverSocket;
    private static Socket socket;

    public static void main(String[] args) {
        start();
    }

    private static void start() {

        try {

            serverSocket = new ServerSocket(port);
            System.out.println("Binding to port " + port + ".");
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client connection.");

            socket = serverSocket.accept();
            System.out.println("Client accepted: " + socket);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            boolean inputClosed = false;

            while (inputClosed == false) {

                String message;
                message = in.readLine();

                if (message.equals("/quit")) {
                    in.close();
                    inputClosed = true;
                    System.out.println("Client closed. Exiting.");
                    System.out.println("Closing client connection.");
                    break;
                }

                System.out.println(message);
            }

            socket.close();
            System.out.println("Closing server socket.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
