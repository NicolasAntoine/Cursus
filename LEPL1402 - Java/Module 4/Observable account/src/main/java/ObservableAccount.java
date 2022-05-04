import java.util.HashMap;
import java.util.Map;

/**
 * This class implements a bank account.
 * You can deposit and withdraw money from the account.
 * Read carefully the comments of each method and fill the missing
 * parts marked with "TODO".
 * You can ADD any code you like in this class (new members, new methods, etc.).
 * but do not add a package
 */

public class ObservableAccount {
    int balance = 0;
    HashMap<AccountObserver, Integer> observers = new HashMap<>();

    public interface AccountObserver {
        void accountHasChanged();
    }

    /**
     * Get the account balance  (franc. "solde")
     * The initial balance of the account is 0.
     *
     * @return The balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Deposit an amount into the account
     *
     * @param amount The amount to deposit
     */
    public void deposit(int amount) {
        balance+= amount;
        for (Map.Entry<AccountObserver, Integer> entry : observers.entrySet()){
            if (entry.getValue() <= amount) entry.getKey().accountHasChanged();
        }
    }

    /**
     * Withdraw an amount from the account.
     * An account cannot become negative.
     * If you try to withdraw 1000 Euro from an account that has
     * only 500 Euro, the withdrawal is NOT executed.
     *
     * @param amount The sum to withdraw
     */
    public void withdraw(int amount) {
        if (balance >= amount){
            balance-=amount;
            for (Map.Entry<AccountObserver, Integer> entry : observers.entrySet()) {
                if (entry.getValue() <= amount) entry.getKey().accountHasChanged();
            }
        }

    }

    /**
     * Add an observer to the account.
     * The observer will be notified if an amount is deposited or withdrawn
     * that is greater than the specified maximum.
     * The observer must NOT be notified if the withdrawal is not executed
     * (see comment of the method 'withdraw')
     *
     * The user of this class can change the maximum for an added observer by calling
     * this method again with the same observer. Example:
     *      account.addObserver(myObserver,1000);
     *      account.addObserver(myObserver,2000); // change maximum for this observer
     *
     * @param observer The observer to add.
     * @param maximum The observer will be notified if the deposited or withdrawn
     *                amount is greater than "maximum".
     *
     */
    public void addObserver(AccountObserver observer, int maximum) {
        observers.put(observer, maximum);
    }
}
