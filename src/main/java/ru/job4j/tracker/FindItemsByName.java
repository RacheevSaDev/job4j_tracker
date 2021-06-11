package ru.job4j.tracker;

import java.util.List;

public class FindItemsByName implements UserAction {
    private final Output out;

    public FindItemsByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> foundItems = tracker.findByName(name);
        if (foundItems.size() > 0) {
            for (Item item : foundItems) {
                out.println(item);
            }
        } else {
            out.println("Заявки с таким именем не найдены.");
        }
        return true;
    }
}
