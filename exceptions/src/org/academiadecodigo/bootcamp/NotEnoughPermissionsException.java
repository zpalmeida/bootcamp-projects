package org.academiadecodigo.bootcamp;

public class NotEnoughPermissionsException extends FileException {

    public NotEnoughPermissionsException() {
        super("You do not have permission to access that file. Please login.");
    }
}
