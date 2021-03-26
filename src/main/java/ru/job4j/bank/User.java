package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает пользователя банковской системы
 * @author Semyon Racheev
 * @version 1.0
 */
public class User {
    /**
     * Серия и номер паспорта пользователя банковской системы
     */
    private String passport;
    /**
     * ФИО пользователя банковской системы
     */
    private String username;

    /**
     * Конструктор. Создаёт объект пользователя банковской системы
     * @param passport серия и номер паспорта пользователя
     * @param username ФИО пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить серия и номер паспорта пользователя банковской системы
     * @return возвращает реквизиты серия и номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет установить серию и номер паспорта пользователя банковской системы
     * @param passport новые серия и номер паспорта пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить ФИО пользователя банковской системы
     * @return возвращает ФИО пользователя банковской системы
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет установить новые ФИО пользователя банковской системы
     * @param username новые ФИО пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод позволяет проверить на равенство данного пользователя с переданным в параметре
     * @param o пользователь с которым сравниваем данного пользователя
     * @return возвращает true при равенстве серии и номера паспорта
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод считает hashCode от серии и номера паспорта
     * @return возвращает hashCode от серии и номера паспорта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}