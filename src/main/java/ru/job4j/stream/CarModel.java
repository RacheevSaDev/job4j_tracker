package ru.job4j.stream;

public class CarModel {
    private String name;
    private String color;
    private String win;
    private byte type;
    private int length;
    private int width;
    private int height;
    private int year;

    @Override
    public String toString() {
        return "CarModel{"
                + "name='" + name + '\''
                + ", color='" + color + '\''
                + ", win='" + win + '\''
                + ", type=" + type
                + ", length=" + length
                + ", width=" + width
                + ", height=" + height
                + ", year=" + year
                + '}';
    }

    static class Builder {
        private String name;
        private String color;
        private String win;
        private byte type;
        private int length;
        private int width;
        private int height;
        private int year;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildWin(String win) {
            this.win = win;
            return this;
        }

        Builder buildType(byte type) {
            this.type = type;
            return this;
        }

        Builder buildLength(int length) {
            this.length = length;
            return this;
        }

        Builder buildWidth(int width) {
            this.width = width;
            return this;
        }

        Builder buildHeight(int height) {
            this.height = height;
            return this;
        }

        Builder buildYear(int year) {
            this.year = year;
            return this;
        }

        CarModel build() {
            CarModel carModel = new CarModel();
            carModel.name = name;
            carModel.color = color;
            carModel.win = win;
            carModel.type = type;
            carModel.length = length;
            carModel.width = width;
            carModel.height = height;
            carModel.year = year;
            return carModel;
        }
    }

    public static void main(String[] args) {
        CarModel car = new Builder().buildName("name")
                .buildColor("RED")
                .buildWin("WDB2020201A077199")
                .buildType((byte) 1)
                .buildLength(4481)
                .buildWidth(1720)
                .buildHeight(1425)
                .buildYear(1999)
                .build();
        System.out.println(car);
    }
}
