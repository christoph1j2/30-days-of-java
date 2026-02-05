package leschkae.model;

public class TodoItem {
    private String text;
    private boolean done;

    public TodoItem(String text) {
        this.text = text;
        this.done = false;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

    public void markDone() {
        this.done = true;
    }
}