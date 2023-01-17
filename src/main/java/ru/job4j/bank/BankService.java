package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс является сервисом для выполнения банковских переводов
 * @author NICK GORBUNOV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей и банковских счетов осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему
     * @param user пользователь который добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет пользователя из системы
     * @param passport система ищет пользователя по номеру паспорта
     * @return возвращает true если пользователь удален
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет счет для пользователя. Если пользователь найден и такого счета не в системе,
     * счет будет добавлен
     * @param passport сисетема ищет пользователя по номеру паспорта
     * @param account счет который необходимо добавить
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
     * Метод позваляет найти пользователя по номеру пасспорта
     * @param passport номер паспорта
     * @return возвращает пользователя типа user
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод позваляет найти счет пользователя по реквизитам
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счета
     * @return возвращает счет пользователя, если он найден или null если не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод переводит деньги с одного счета на другой
     * @param srcPassport исходный номер паспорта
     * @param srcRequisite исходные реквизиты счета
     * @param destPassport конечный номер паспорта
     * @param destRequisite конечные реквизиты счета
     * @param amount сумма денег
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

    /**
     * Метод позволяет получить все счета пользователя
     * @param user пользователь, счета которого необходимо получить
     * @return возвращает список счетов пользователя типа List
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
