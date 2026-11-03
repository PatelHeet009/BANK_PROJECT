class SavingAccount extends Account {

    SavingAccount(User owner, double balance) {
        super(owner, balance, (long) (Math.random() * 9999999999.0f + 10000000000.0f), 0);
    }

    String getAccountType() {
        return "Saving";
    }

    // Saving -> Current when balance crosses 10,00,000 or 15 transactions are done
    boolean shouldSwitchToCurrent() {
        return balance > 1000000 || transCount >= 15;
    }
}
