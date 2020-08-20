package org.academiadecodigo.bootcamp;

public class Main {

    public static void main(String[] args) {

        ToDoList toDoList = new ToDoList();

        toDoList.add(Importance.MEDIUM, 1, "Take a nap.");
        toDoList.add(Importance.LOW, 1, "Master how to sing in the shower.");
        toDoList.add(Importance.HIGH, 1, "Pet the cat.");
        toDoList.add(Importance.LOW, 2, "Help Code Cadets.");
        toDoList.add(Importance.MEDIUM, 2, "Buy chocolate donuts.");
        toDoList.add(Importance.HIGH, 2, "Watch Black Clover's last episode.");

        while (!toDoList.isEmpty()) {
            System.out.println(toDoList.remove());
        }
    }
}
