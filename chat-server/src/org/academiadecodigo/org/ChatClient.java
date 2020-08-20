package org.academiadecodigo.org;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatClient {

    private Socket socket;

    public static void main(String[] args) {

        ChatClient client = new ChatClient();
        client.start("localhost", 9876);
    }

    private void start(String host, int port) {

        try {
            socket = new Socket(host, port);
            System.out.println("Connected to: " + socket);

            BufferedReader systemInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream());

            ExecutorService pool = Executors.newFixedThreadPool(10);

            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {

                        while (!socket.isClosed()) {
                            System.out.println(input.readLine());
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            while (!socket.isClosed()) {

                String message = systemInput.readLine();
                output.println(message);
                output.flush();
            }

            pool.shutdown();
            output.close();
            input.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
