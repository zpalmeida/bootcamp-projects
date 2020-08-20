package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    private static DatagramSocket socket;
    private static DatagramPacket receivePacket;
    private static DatagramPacket sendPacket;

    public static void main(String[] args) {

        byte[] sendBuffer = new byte[1024];
        byte[] receiveBuffer = new byte[1024];

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bReader = new BufferedReader(reader);

        try {

            System.out.print("Hostname? ");
            String hostName = bReader.readLine();
            System.out.print("Port? ");
            String port = bReader.readLine();
            System.out.print("Enter message: ");
            String message = bReader.readLine();

            socket = new DatagramSocket();

            sendBuffer = message.getBytes();

            sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(hostName),
                    Integer.parseInt(port));
            socket.send(sendPacket);

            receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            System.out.println("Waiting for return packet.");
            socket.receive(receivePacket);

        } catch (IOException e) {
            e.printStackTrace();
        }

        socket.close();

        String newMessage = new String(receivePacket.getData());
        System.out.println("Received message: " + newMessage);
    }
}
