package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    private final Output out;

    public ReplaceItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace item";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        int id = Integer.valueOf(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        Item newItem = new Item(id, name);
        boolean isEdited = tracker.replace(id, newItem);
        if (isEdited) {
            System.out.println("Заявка успешно отредактирована.");
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
        return true;
    }

}
