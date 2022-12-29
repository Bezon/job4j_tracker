package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user.getPassport())) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public boolean deleteUser(String passport) {
        if (users.remove(findByPassport(passport)) != null) {
            return true;
        }
        return false;
    }

    public void addAccount(String passport, Account inAccount) {
        User user = findByPassport(passport);
        List<Account> accounts = getAccounts(user);
        boolean rls = true;
        for (Account account : accounts) {
            if (account.equals(inAccount)) {
                rls = false;
                break;
            }
        }
        if (rls) {
            accounts.add(inAccount);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : getAccounts(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (getAccounts(findByPassport(srcPassport)).contains(findByRequisite(srcPassport, srcRequisite))) {
            if (getAccounts(findByPassport(destPassport)).contains(findByRequisite(srcPassport, destRequisite))) {
                if (srcAccount.getBalance() >= amount) {
                    srcAccount.setBalance(srcAccount.getBalance() - amount);
                    destAccount.setBalance(destAccount.getBalance() + amount);
                    return true;
                }
            }
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
