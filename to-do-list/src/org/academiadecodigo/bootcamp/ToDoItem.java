package org.academiadecodigo.bootcamp;

public class ToDoItem implements Comparable<ToDoItem> {

    private Importance importance;
    private Integer priority;
    private String task;

    public ToDoItem(Importance importance, int priority, String task) {
        this.importance = importance;
        this.priority = priority;
        this.task = task;
    }

    @Override
    public String toString() {
        return task;
    }

    @Override
    public int compareTo(ToDoItem item) {
        if (importance.compareTo(item.importance) == 0) {
            return priority.compareTo(item.priority);
        }
        return importance.compareTo(item.importance);
    }
}
