class CurrentAccount extends Account {

    CurrentAccount(User owner, double balance) {
        super(owner, balance, (long) (Math.random() * 9999999999.0f + 10000000000.0f), 0);
    }

    // Used when a Saving account is switched to Current (keeps same data)
    CurrentAccount(Account other) {
        super(other.getOwner(), other.getBalance(), other.getAccountNumber(), other.getTransCount());
    }

    String getAccountType() {
        return "Current";
    }
}
