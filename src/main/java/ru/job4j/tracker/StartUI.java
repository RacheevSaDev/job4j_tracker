package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = -1;
            select = input.askInt("Select: ");
            try {
            UserAction action = actions[select];
            run = action.execute(input, tracker);
            } catch(ArrayIndexOutOfBoundsException obe) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAllItems(output),
                new ReplaceItem(output),
                new DeleteItem(output),
                new FindItemById(output),
                new FindItemsByName(output),
                new Exit()
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
