import java.util.Scanner;

class TransactionService {

    // Runs the account menu. Returns the account (a new CurrentAccount object
    // if a Saving account got switched to Current).
    static Account runAccountMenu(Scanner ob, Account acc) {
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("===================================");
            System.out.println("            Account Menu");
            System.out.println("===================================");
            System.out.print("1. Make Transaction\n2. View Balance\n3. View Account Details\n4. Exit\nEnter choice: ");
            int choice = ob.nextInt();

            switch (choice) {

                case 1:
                    if (acc.getAccountType().equals("Saving") && (acc.getTransCount() + 1) == 15) {
                        System.out.println("Alert: If you proceed with this transaction, "
                                + "your account will be switched to a Current account.");
                    }
                    System.out.print("Press 1 for Deposit, 2 for Withdraw: ");
                    int trChoice = ob.nextInt();

                    if (trChoice == 1) {
                        System.out.print("Enter amount to deposit: ");
                        double amt = ob.nextDouble();
                        acc.deposit(amt);
                        System.out.println("Amount deposited successfully. New Balance is : " + acc.getBalance());
                    } else if (trChoice == 2) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = ob.nextDouble();
                        if (acc.withdraw(amt)) {
                            System.out.println("Amount withdrawn successfully. New Balance is: " + acc.getBalance());
                        }
                    } else {
                        System.out.println("Invalid transaction choice.");
                    }

                    // Saving -> Current check
                    if (acc instanceof SavingAccount) {
                        SavingAccount sa = (SavingAccount) acc;
                        if (sa.getBalance() > 1000000) {
                            acc = new CurrentAccount(acc);
                            System.out.println("Your balance has crossed 10,00,000. "
                                    + "Your account has been switched to Current account.");
                        } else if (sa.getTransCount() >= 15) {
                            acc = new CurrentAccount(acc);
                            System.out.println("Your transaction count has reached 15. "
                                    + "Your account has been switched to Current account.");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter PIN : ");
                    int pin1 = ob.nextInt();
                    if (acc.getOwner().pin == pin1) {
                        System.out.println("Your Balance is: " + acc.getBalance());
                    } else {
                        System.out.println("Please Enter Valid PIN.");
                    }
                    break;

                case 3:
                    System.out.print("Enter PIN : ");
                    int pin2 = ob.nextInt();
                    if (acc.getOwner().pin == pin2) {
                        User u = acc.getOwner();
                        System.out.println("Username: " + u.username + " | Balance: " + acc.getBalance());
                        System.out.println("Mobile No: " + u.mobile + " | Email: " + u.email);
                        System.out.println("Account Type: " + acc.getAccountType());
                    } else {
                        System.out.println("Please Enter Valid PIN.");
                    }
                    break;

                case 4:
                    loggedIn = false;
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        return acc;
    }
}
