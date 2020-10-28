package ru.job4j.tracker;

public class FindItemById implements UserAction {
    @Override
    public String name() {
        return "=== Find items by Id ====";
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
