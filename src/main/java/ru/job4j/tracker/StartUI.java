package ru.job4j.tracker;

public class StartUI {
    private int nextId = 0;

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(input.askStr("Enter id: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = input.askStr("Enter id: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] allItems = tracker.findAll();
                for (Item item : allItems) {
                    System.out.println(item.toString());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter Id: ");
                int id = Integer.valueOf(input.askStr("Enter id: "));
                System.out.print("Enter name: ");
                String name = input.askStr("Enter id: ");
                Item newItem = new Item(id, name);
                boolean isEdited = tracker.replace(id, newItem);
                if (isEdited) {
                    System.out.println("Заявка успешно отредактирована.");
                } else {
                    System.out.println("Заявка с таким id не найдена.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter Id: ");
                int id = Integer.valueOf(input.askStr("Enter id: "));
                boolean isDeleted = tracker.delete(id);
                if (isDeleted) {
                    System.out.println("Заявка успешно удалена.");
                } else {
                    System.out.println("Заявка с таким id не найдена.");
                }
            } else if (select == 4) {
                System.out.println("=== Find items by Id ====");
                System.out.print("Enter Id: ");
                int id = Integer.valueOf(input.askStr("Enter id: "));
                Item foundItem = tracker.findById(id);
                if (foundItem != null) {
                    System.out.println(foundItem.toString());
                } else {
                    System.out.println("Заявка с таким id не найдена.");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter name: ");
                String name = input.askStr("Enter id: ");
                Item[] foundItems = tracker.findByName(name);
                if (foundItems.length > 0) {
                    for (Item item : foundItems) {
                        System.out.println(item.toString());
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены.");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}