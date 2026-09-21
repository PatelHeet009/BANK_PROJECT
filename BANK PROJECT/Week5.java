abstract class Account {

    double balance;

    void deposit(double amount) {

        balance = balance + amount;
    }

    void showBalance() {

        System.out.println("Balance: ₹" + balance);
    }

    abstract void calculateInterest();
}


class SavingAccount extends Account {

    void calculateInterest() {

        double interest = balance * 4 / 100;

        System.out.println(
                "Saving Interest: ₹" + interest
        );
    }
}


public class Week5 {

    public static void main(String[] args) {

        SavingAccount account =
                new SavingAccount();

        account.deposit(10000);

        account.showBalance();

        account.calculateInterest();
    }
}
