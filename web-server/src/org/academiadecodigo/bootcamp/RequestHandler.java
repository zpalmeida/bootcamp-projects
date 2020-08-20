package org.academiadecodigo.bootcamp;

import java.io.File;
import java.io.IOException;

public class RequestHandler implements Runnable {

    @Override
    public void run() {

        File input = Server.input();
        Server.output(input, Server.checkStatus(input));

        try {
            Server.getSocket().close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
