package org.academiadecodigo.bootcamp;

public class NotEnoughSpaceException extends FileException {

    public NotEnoughSpaceException() {
        super("Your disk is full.");
    }
}
