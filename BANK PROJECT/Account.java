abstract class Account {
    protected long accountNumber;
    protected double balance;
    protected int transCount;
    protected User owner;

    Account(User owner, double balance, long accountNumber, int transCount) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.transCount = transCount;
    }

    long getAccountNumber() {
        return accountNumber;
    }

    double getBalance() {
        return balance;
    }

    int getTransCount() {
        return transCount;
    }

    User getOwner() {
        return owner;
    }

    void deposit(double amount) {
        balance += amount;
        transCount++;
    }

    // Both account types must keep a minimum balance of 20000
    boolean withdraw(double amount) {
        if (balance - amount < 20000) {
            System.out.println("Insufficient balance. Please maintain balance of 20000.");
            return false;
        }
        balance -= amount;
        transCount++;
        return true;
    }

    abstract String getAccountType();
}
