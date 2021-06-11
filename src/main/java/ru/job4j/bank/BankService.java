package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод позволяет найти банковский счёт по серии и номеру паспорта пользователя и реквизитам
     * @param passport серия и номер паспорта пользователя
     * @param requisite реквизиты счёта
     * @return возвращает объект банковского счёта
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}