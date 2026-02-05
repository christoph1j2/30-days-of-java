package leschkae;

import leschkae.service.TodoService;
import leschkae.ui.CommandHandler;

public class Main {
    public static void main(String[] args) {
        TodoService service = new TodoService();
        CommandHandler ui = new CommandHandler(service);
        ui.run();
    }
}