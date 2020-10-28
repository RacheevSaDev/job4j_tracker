package ru.job4j.tracker;

public class FindItemsByName implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] foundItems = tracker.findByName(name);
        if (foundItems.length > 0) {
            for (Item item : foundItems) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Заявки с таким именем не найдены.");
        }
        return true;
    }
}
