package org.academiadecodigo.bootcamp;

public class Main {

    public static void main(String[] args) throws FileException {

        FileManager fileManager = new FileManager();

        try {
            fileManager.createFile("Important Documents");
        } catch (NotEnoughSpaceException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            fileManager.createFile("Very Important Documents");
        } catch (NotEnoughSpaceException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            fileManager.createFile("Random Documents");
        } catch (NotEnoughSpaceException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            fileManager.getFile("Not So Important Documents");
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            fileManager.getFile("Very Important Documents");
        } catch (NotEnoughPermissionsException exception) {
            System.out.println(exception.getMessage());
        }

        fileManager.login();

        try {
            fileManager.getFile("Very Important Documents");
        } catch (NotEnoughPermissionsException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
