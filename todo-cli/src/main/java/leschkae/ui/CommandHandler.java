package leschkae.ui;

import leschkae.service.TodoService;
import leschkae.model.TodoItem;

import java.util.Scanner;

public class CommandHandler {
    private final TodoService service;
    private final Scanner sc = new Scanner(System.in);

    public CommandHandler(TodoService service) {
        this.service = service;
    }

    public void run() {
        System.out.print("TODO app - type help");

        while (true) {
            System.out.println("> ");
            String input = sc.nextLine();

            if (input.equals("exit")) {
                break;
            }

            handleCommand(input);
        }
    }

    private void handleCommand(String input) {
        if (input.startsWith("add ")) {
            String text = input.substring(4).replace("\"", "");
            service.add(text);
        }
        else if (input.equals("list")) {
            listTodos();
        }
        else if (input.startsWith("done ")) {
            int index = parseIndex(input.substring(5));
            service.markDone(index);
        }
        else if (input.startsWith("delete ")) {
            int index = parseIndex(input.substring(7));
            service.delete(index);
        }
        else if (input.equals("help")) {
            printHelp();
        }
        else {
            System.out.println("Invalid command");
        }
    }

    private int parseIndex(String input) {
        try {
            return Integer.parseInt(input.trim()) - 1;
        } catch (Exception e) {
            System.out.println("Type index of todo.");
            return -1;
        }
    }

    private void listTodos() {
        int i = 1;
        for (TodoItem item : service.getAll()) {
            String mark = item.isDone() ? "[x]" : "[ ]";
            System.out.println(i + " " + mark + " " + item.getText());
            i++;
        }
    }

    private void printHelp() {
        System.out.println("Commands:");
        System.out.println("add \"text\"");
        System.out.println("list");
        System.out.println("done 1");
        System.out.println("delete 1");
        System.out.println("exit");
        System.out.println("help");
    }
}