class BankAccount {

    String name;
    double balance;

    void deposit(double amount) {

        balance = balance + amount;

        System.out.println("Deposit successful.");
    }

    void withdraw(double amount) {

        if (amount <= balance) {

            balance = balance - amount;

            System.out.println("Withdrawal successful.");

        } else {

            System.out.println("Insufficient balance.");
        }
    }

    void showBalance() {

        System.out.println("Balance: ₹" + balance);
    }
}


public class Week3 {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.name = "Heet";
        account.balance = 5000;

        account.deposit(2000);
        account.showBalance();

        account.withdraw(1000);
        account.showBalance();
    }
}
