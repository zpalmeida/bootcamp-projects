package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLSourceViewer {

    private static URL uRL;

    public static void main(String[] args) {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bReader = new BufferedReader(reader);

        System.out.print("URL? ");

        try {

            String location = bReader.readLine();
            bReader.close();

            uRL = new URL(location);

            BufferedReader input = new BufferedReader(new InputStreamReader(uRL.openStream()));;

            while (input.read() != -1) {

                String source = input.readLine();
                System.out.println(source);
            }

            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
