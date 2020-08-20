package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

    public static Socket socket;

    public static void main(String[] args) {
        start("localhost", 9876);
    }

    public static void start(String hostName, int port) {

        try {

            System.out.println("Establishing connection.");
            socket = new Socket(hostName, port);
            System.out.println("Connected to: " + socket);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            boolean outputClosed = false;

            while (outputClosed == false) {

                String message = reader.readLine();
                out.println(message);

                if (message.equals("/quit")) {
                    break;
                }
            }

            socket.close();
            System.out.println("Closing the socket.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
