class BankException extends Exception {

BankException(String message) {

    super(message);
}

}

class Account {
double balance = 5000;


void deposit(double amount)
        throws BankException {

    if (amount <= 0) {

        throw new BankException(
                "Amount must be greater than zero."
        );
    }

    balance = balance + amount;
}


void withdraw(double amount)
        throws BankException {

    if (amount <= 0) {

        throw new BankException(
                "Amount must be greater than zero."
        );
    }

    if (amount > balance) {

        throw new BankException(
                "Insufficient balance."
        );
    }

    balance = balance - amount;
}

}

public class Week9 {

public static void main(String[] args) {

    Account account = new Account();

    try {

        account.deposit(1000);

        account.withdraw(7000);

    } catch (BankException e) {

        System.out.println(
                "Error: " + e.getMessage()
        );
    }

    System.out.println(
            "Balance: ₹" + account.balance
    );
}

}
