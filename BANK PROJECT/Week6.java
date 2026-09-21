
abstract class Account {

    double balance;

    void deposit(double amount) {

        balance = balance + amount;
    }

    abstract void calculateInterest();
}


class SavingAccount extends Account {

    @Override
    void calculateInterest() {

        double interest =
                balance * 4 / 100;

        System.out.println(
                "Saving Account Interest: ₹"
                        + interest
        );
    }
}


class CurrentAccount extends Account {

    @Override
    void calculateInterest() {

        double interest =
                balance * 2 / 100;

        System.out.println(
                "Current Account Interest: ₹"
                        + interest
        );
    }
}


public class Week6 {

    public static void main(String[] args) {

        Account account;

        account = new SavingAccount();

        account.deposit(10000);
        account.calculateInterest();


        account = new CurrentAccount();

        account.deposit(10000);
        account.calculateInterest();
    }
}
