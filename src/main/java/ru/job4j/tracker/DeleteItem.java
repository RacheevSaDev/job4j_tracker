package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int id = Integer.valueOf(input.askStr("Enter id: "));
        boolean isDeleted = tracker.delete(id);
        if (isDeleted) {
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}
