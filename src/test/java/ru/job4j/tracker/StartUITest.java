package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1","0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n")
        ));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new CreateAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenFindAllItems() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0","1"}
        );
        Tracker tracker = new Tracker();
        Item addedItem1 = new Item("addedItem1");
        tracker.add(addedItem1);
        Item addedItem2 = new Item("addedItem2");
        tracker.add(addedItem2);
        Item addedItem3 = new Item("addedItem3");
        tracker.add(addedItem3);
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ShowAllItems(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        addedItem1.toString() + System.lineSeparator()  +
                        addedItem2.toString() + System.lineSeparator()  +
                        addedItem3.toString() + System.lineSeparator()  +
                        "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0","addedItem","1"}
        );
        Tracker tracker = new Tracker();
        Item addedItem = new Item("addedItem");
        tracker.add(addedItem);
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindItemsByName(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find items by name ====" + System.lineSeparator() +
                        addedItem.toString() + System.lineSeparator()  +
                        "Menu." + System.lineSeparator() +
                        "0. Find by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemInEmptyByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0","addedItem","1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindItemsByName(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find items by name ====" + System.lineSeparator() +
                        "Заявки с таким именем не найдены." + System.lineSeparator()  +
                        "Menu." + System.lineSeparator() +
                        "0. Find by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0","1","1"}
        );
        Tracker tracker = new Tracker();
        Item addedItem = new Item("addedItem");
        tracker.add(addedItem);
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindItemById(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find by id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find items by Id ====" + System.lineSeparator() +
                        addedItem.toString() + System.lineSeparator()  +
                        "Menu." + System.lineSeparator() +
                        "0. Find by id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindInEmptyById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0","1","1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindItemById(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find by id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find items by Id ====" + System.lineSeparator() +
                        "Заявка с таким id не найдена." + System.lineSeparator()  +
                        "Menu." + System.lineSeparator() +
                        "0. Find by id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }
}
