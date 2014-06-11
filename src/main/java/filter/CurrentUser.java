package filter;


import models.Account;

/**
 * Created by blakebishop on 6/10/14.
 */
public class CurrentUser {
    private static final ThreadLocal<Account> userStorage = new ThreadLocal<Account>();

    public static Account getUser() {
        return userStorage.get();
    }

    public static void setUser(Account p) {
        userStorage.set(p);
    }
}
