package org.academiadecodigo.bootcamp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {

    public static void cp(String fileSourcePath, String fileDestinationPath) throws IOException {

        FileInputStream inputStream = new FileInputStream(fileSourcePath);
        FileOutputStream outputStream = new FileOutputStream(fileDestinationPath);
        int bufferLength = 2000;

        byte[] buffer;
        int bytesRead = 0;

        while (bytesRead != -1) {

            buffer = new byte[bufferLength];

            bytesRead = inputStream.read(buffer);

            if (bytesRead < bufferLength) {

                for (int i = 0; i < bytesRead; i++) {
                    outputStream.write(buffer[i]);
                }
                break;
            }

            outputStream.write(buffer);
        }

        inputStream.close();
        outputStream.close();
    }
}
