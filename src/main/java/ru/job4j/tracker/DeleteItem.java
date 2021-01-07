package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        //System.out.println("=== Delete item ====");
        out.println("=== Delete item ====");
        int id = input.askInt("Enter id: ");
        boolean isDeleted = tracker.delete(id);
        if (isDeleted) {
            //System.out.println("Заявка успешно удалена.");
            out.println("Заявка успешно удалена.");
        } else {
            out.println("Заявка с таким id не найдена.");
        }
        return true;
    }
}
