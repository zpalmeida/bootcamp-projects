package org.academiadecodigo.org;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    private ServerSocket serverSocket;
    private ArrayList<ClientHandler> handlers;

    public static void main(String[] args) {

        ChatServer server = new ChatServer();
        server.start(9876);
    }

    private void start(int port) {

        try {

            serverSocket = new ServerSocket(port);
            handlers = new ArrayList();
            System.out.println("Server started and bound to port " + port + ". Waiting for connection.");

            while (true) {

                Socket socket = serverSocket.accept();
                System.out.println("Connection accepted: " + socket);

                ClientHandler handler = new ClientHandler(socket);
                handlers.add(handler);

                ExecutorService pool = Executors.newFixedThreadPool(50);
                pool.submit(handler);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToAll(String message) {

        System.out.println(message);

        for(ClientHandler handler : handlers) {

            handler.send(message);
        }
    }

    public class ClientHandler implements Runnable {

        private Socket socket;
        private BufferedReader input;
        private PrintWriter output;
        private String nickname;

        public ClientHandler (Socket socket) {

            this.socket = socket;

            try {

                output = new PrintWriter(socket.getOutputStream());
                output.println("Choose your nickname: ");

                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void send(String message) {

            output.println(message);
            output.flush();
        }

        private void input() throws IOException {

            while (!socket.isClosed()) {

                String message = input.readLine();

                if (message.equals("/quit")) {
                    socket.close();
                    handlers.remove(this);
                }

                sendToAll(nickname + ": " + message);
            }
        }

        @Override
        public void run() {

            try {

                nickname = input.readLine();

                if (nickname != null) {
                    input();
                }

                sendToAll("Client disconnected.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
