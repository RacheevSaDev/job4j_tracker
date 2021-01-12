package ru.job4j.tracker;

public class TrackerSingleStaticFinalField {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingleStaticFinalField() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleStaticFinalField.getInstance();
    }
}