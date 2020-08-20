package org.academiadecodigo.bootcamp;

import java.util.PriorityQueue;

public class ToDoList {

    private PriorityQueue priorityQueue;
    private boolean isEmpty = true;

    public ToDoList() {
        priorityQueue = new PriorityQueue();
    }

    public void add(Importance importance, int priority, String item) {
        ToDoItem toDoItem = new ToDoItem(importance, priority, item);
        isEmpty = false;
        priorityQueue.add(toDoItem);
    }

    public String remove() {
        if (priorityQueue.size() > 0) {
            return priorityQueue.poll().toString();
        }
        isEmpty = true;
        return "Your list is empty.";
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
