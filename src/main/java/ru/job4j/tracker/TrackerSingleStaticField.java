package ru.job4j.tracker;

public class TrackerSingleStaticField {
    private static Tracker instance;

    private TrackerSingleStaticField() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}