package leschkae.service;

import leschkae.model.TodoItem;
import java.util.ArrayList;
import java.util.List;

public class TodoService {
    private final List<TodoItem> todos = new ArrayList<>();

    public void add(String text) {
        todos.add(new TodoItem(text));
    }

    public List<TodoItem> getAll() {
        return todos;
    }

    public void markDone(int index) {
        if (index >= 0 && index < todos.size()) {
            todos.get(index).markDone();
        } else {
            System.out.println("Index out of range");
        }
    }

    public void delete(int index) {
        if (index > 0 && index < todos.size()) {
            todos.remove(index);
        } else {
            System.out.println("Index out of range");
        }
    }
}