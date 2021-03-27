package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковскую систему. Есть метод по переводу средств с одного счёта на другой
 * @author Semyon Racheev
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение объектов аккаунтов с соответствующими аккаунту счетами
     * осуществляется в коллекции типа HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление нового пользователя в банковскую систему.
     * Если пользователь уже существует, то ничего не происходит
     * @param user новый пользователь системы
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет добавить новый банковский счёт для пользователя.
     * Если пользователя с такими серией и номером не существует, но ничего не проиходит.
     * @param passport серия и номер паспорта пользователя
     * @param account номер банковского счёта
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет найти пользователя системы по серии и номеру паспорта
     * @param passport серия и номер паспорта пользователя
     * @return возвращает объект пользователя
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return  null;
    }

    /**
     * Метод позволяет найти банковский счёт по серии и номеру паспорта пользователя и реквизитам
     * @param passport серия и номер паспорта пользователя
     * @param requisite реквизиты счёта
     * @return возвращает объект банковского счёта
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод позволяет перевести средства с банковского счёта одного пользователя
     * на банковский счёт другого пользователя
     * @param srcPassport серия и номер паспорта пользователя СО счёта которого переводятся средства
     * @param srcRequisite реквизиты счёта С которого переводятся средства
     * @param destPassport серия и номер паспорта пользователя НА счёт которого переводятся средства
     * @param destRequisite реквизиты счёта НА который переводятся средства
     * @param amount сумма средств для перевода
     * @return возвращает true при успешном переводе
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}