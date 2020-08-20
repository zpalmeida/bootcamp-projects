package org.academiadecodigo.bootcamp;

import java.io.*;
import java.net.InetAddress;

public class DNSResolver {

    public static void main(String[] args) {

        try {

            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader bReader = new BufferedReader(reader);

            System.out.print("Hostname? ");
            String answer = bReader.readLine();

            System.out.println(resolver(answer));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String resolver(String hostname) throws IOException {

            InetAddress address = java.net.InetAddress.getByName(hostname);
            byte[] iP = address.getAddress();
            boolean reachable = java.net.InetAddress.getByAddress(hostname, iP).isReachable(500);

            String string = "Reachable: " + reachable + " || " + "IP: " + String.valueOf(address).split("/")[1];

            return string;
    }
}
