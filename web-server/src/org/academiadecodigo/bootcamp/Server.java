package org.academiadecodigo.bootcamp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 9876;
    private static final String DIRECTORY = "www";
    private static ServerSocket serverSocket;
    private static Socket socket;

    public static void main(String[] args) {

        start();
    }

    public static Socket getSocket() {
        return socket;
    }

    public static void start() {

        try {

            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started and bound to port " + PORT + ". Waiting for connection.");

            while (true) {

                socket = serverSocket.accept();
                System.out.println("Connection accepted: " + socket);

                Thread thread = new Thread(new RequestHandler());
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File input() {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String[] line = reader.readLine().split(" ");

            File file = new File(DIRECTORY + line[1]);

            if (!file.exists() || line[1].equals("/")) {

                return new File(DIRECTORY + "/404.html");
            }

            return file;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void output(File file, StatusCode code) {

        try {

            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            byte[] fileBytes = fileToBytes(file);

            header(output, fileBytes.length, code);

            output.write(fileBytes, 0, fileBytes.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void header(DataOutputStream stream, int length, StatusCode statusCode) throws IOException {

        String code;

        switch (statusCode) {
            case OK:
                code = "200 OK";
                break;
            case NOT_FOUND:
            default:
                code = "404 Not Found";
        }

        stream.writeBytes("HTTP/1.0 " + code + "\r\n" +
                "Content-Type: html; charset=UTF-8\r\n" +
                "Content-Length: " + length + " \r\n" +
                "\r\n");
    }

    private static byte[] fileToBytes(File file) throws IOException {

        byte[] bytes = new byte[(int) file.length()];

        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bytes);
        fileInputStream.close();

        return bytes;
    }

    private enum StatusCode {

        OK,
        NOT_FOUND;
    }

    public static StatusCode checkStatus(File file) {

        if (file.getPath().equals(DIRECTORY + "\\404.html")) {
            return StatusCode.NOT_FOUND;
        }
        return StatusCode.OK;
    }
}
