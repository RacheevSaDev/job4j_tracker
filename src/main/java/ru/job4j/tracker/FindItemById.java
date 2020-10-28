package ru.job4j.tracker;

public class FindItemById implements UserAction {
    private final Output out;

    public FindItemById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by Id ====");
        int id = Integer.valueOf(input.askStr("Enter id: "));
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            System.out.println(foundItem.toString());
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}
