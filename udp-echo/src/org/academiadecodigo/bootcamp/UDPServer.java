package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

    private static DatagramSocket socket;
    private static DatagramPacket receivePacket;
    private static DatagramPacket sendPacket;

    public static void main(String[] args) {

        byte[] sendBuffer = new byte[1024];
        byte[] receiveBuffer = new byte[1024];

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bReader = new BufferedReader(reader);

        try {

            System.out.print("Port? ");
            String port = bReader.readLine();

            socket = new DatagramSocket(Integer.parseInt(port));

            while (true) {

                receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                System.out.println("Waiting for datagram packet.");
                socket.receive(receivePacket);

                String message = new String(receivePacket.getData());

                System.out.println("From: " + receivePacket.getSocketAddress());
                System.out.println("Message: " + message);

                sendBuffer = message.toUpperCase().getBytes();

                sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(),
                        receivePacket.getPort());
                socket.send(sendPacket);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        socket.close();
    }
}
