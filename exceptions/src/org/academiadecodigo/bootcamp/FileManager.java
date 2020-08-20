package org.academiadecodigo.bootcamp;

public class FileManager {

    private File[] files;
    private boolean loggedIn = false;

    public FileManager() {
        files = new File[2];
    }

    public void login() {
        loggedIn = true;
        System.out.println("You have successfully logged in.");
    }

    public void logout() {
        loggedIn = false;
        System.out.println("You have successfully logged out.");
    }

    public void createFile(String fileName) throws NotEnoughSpaceException {

        for (int i = 0; i < files.length; i++) {
            if(files[i] == null){
                File file = new File();
                files[i] = file;
                file.setName(fileName);
                System.out.println("You have created " + fileName + ".");
                return;
            }
        }
        throw new NotEnoughSpaceException();
    }

    public File getFile(String fileName) throws FileException {

        for (File file : files) {
            if (file.getName() == fileName || fileName == "Very Important Documents" && loggedIn == true) {
                System.out.println("You have accessed " + file.getName() + ".");
                return file;
            }
            if (fileName == "Very Important Documents" && loggedIn == false) {
                throw new NotEnoughPermissionsException();
            }
            break;
        }
        throw new FileNotFoundException();
    }
}
