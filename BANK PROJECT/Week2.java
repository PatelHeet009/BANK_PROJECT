class BankAccount {

    String name;
    int accountNumber;
    double balance;

    void showDetails() {

        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}


public class Week2 {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.name = "Heet";
        account.accountNumber = 1001;
        account.balance = 5000;

        account.showDetails();
    }
}