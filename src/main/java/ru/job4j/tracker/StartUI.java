package ru.job4j.tracker;

public class StartUI {
    private int nextId = 0;

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAllItems(output),
                new ReplaceItem(output),
                new DeleteItem(output),
                new FindItemById(output),
                new FindItemsByName(output),
                new Exit(output)
        };
        new StartUI().init(input, tracker, actions);
    }
}
