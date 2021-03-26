package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает банковский счёт
 * @author Semyon Racheev
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счёта. Уникальная строка для каждого счёта
     */
    private String requisite;
    /**
     * Доступный остаток средств на счете
     */
    private double balance;

    /**
     * Конструктор. Создаёт объект банковского счёта
     * @param requisite реквизиты счёта
     * @param balance Доступный остаток средств на счете
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты счёта
     * @return возвращает реквизиты счёта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет установить реквизиты счёта
     * @param requisite новые реквизиты счёта
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить доступный остаток средств на счёте
     * @return возвращает доступный остаток средств на счёте
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет установить доступный остаток средств на счёте
     * @param balance новый остаток средств на счёте
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод позволяет проверить на равенство данного счёта с переданным в параметре
     * @param o счёт с которым сравниваем данный счёт
     * @return возвращает true при равенстве реквизитов счетов
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод считает hashCode от реквизитов
     * @return возвращает hashCode от реквизитов
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}