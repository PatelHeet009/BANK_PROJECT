import java.io.*;
import java.util.Scanner;

/*
 * BANK MANAGEMENT SYSTEM
 * Week 1 to Week 11 OOP Project
 *
 * Concepts used:
 * 1. Class and Object
 * 2. Encapsulation
 * 3. Inheritance
 * 4. Abstraction
 * 5. Polymorphism
 * 6. Interface
 * 7. Exception Handling
 * 8. File Handling
 */

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Bank bank = new Bank();

    public static void main(String[] args) {

        bank.loadData();

        while (true) {

            if (bank.currentUser == null) {
                mainMenu();
            } else {
                userMenu();
            }
        }
    }

    // ================= MAIN MENU =================

    static void mainMenu() {

        System.out.println("\n================================");
        System.out.println("       BANK MANAGEMENT SYSTEM");
        System.out.println("================================");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Bank Statistics");
        System.out.println("4. Exit");

        int choice = getInt("Enter choice: ");

        switch (choice) {

            case 1:
                bank.register();
                break;

            case 2:
                bank.login();
                break;

            case 3:
                bank.statistics();
                break;

            case 4:
                bank.saveData();
                System.out.println("Thank you for using Bank System.");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    // ================= USER MENU =================

    static void userMenu() {

        User user = bank.currentUser;

        System.out.println("\n================================");
        System.out.println("          USER MENU");
        System.out.println("================================");

        System.out.println("Welcome, " + user.getUsername());

        System.out.println("\n1. Account Details");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Account Statement");
        System.out.println("6. Apply Loan");
        System.out.println("7. Loan Details");
        System.out.println("8. Pay EMI");
        System.out.println("9. Loan Payment History");
        System.out.println("10. Loan Interest");
        System.out.println("11. Change Password");
        System.out.println("12. Save Data");
        System.out.println("13. Bank Statistics");
        System.out.println("14. Logout");
        System.out.println("15. Exit");

        int choice = getInt("Enter choice: ");

        switch (choice) {

            case 1:
                user.showDetails();
                break;

            case 2:
                deposit(user);
                break;

            case 3:
                withdraw(user);
                break;

            case 4:
                System.out.println(
                        "Balance: ₹" + user.account.getBalance()
                );
                break;

            case 5:
                user.account.showStatement();
                break;

            case 6:
                bank.applyLoan();
                break;

            case 7:
                user.loan.showDetails();
                break;

            case 8:
                bank.payEMI();
                break;

            case 9:
                user.loan.showHistory();
                break;

            case 10:
                user.loan.showInterest();
                break;

            case 11:
                bank.changePassword();
                break;

            case 12:
                bank.saveData();
                break;

            case 13:
                bank.statistics();
                break;

            case 14:
                bank.logout();
                break;

            case 15:
                bank.saveData();
                System.out.println("Thank you!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    // ================= DEPOSIT =================

    static void deposit(User user) {

        double amount = getDouble("Enter deposit amount: ");

        try {

            user.account.deposit(amount);

            System.out.println("Deposit successful.");
            System.out.println("New Balance: ₹"
                    + user.account.getBalance());

        } catch (BankException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    // ================= WITHDRAW =================

    static void withdraw(User user) {

        double amount = getDouble("Enter withdrawal amount: ");

        try {

            user.account.withdraw(amount);

            System.out.println("Withdrawal successful.");
            System.out.println("New Balance: ₹"
                    + user.account.getBalance());

        } catch (BankException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    // ================= INPUT METHODS =================

    static int getInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        sc.nextLine()
                );

            } catch (Exception e) {

                System.out.println("Please enter a valid number.");
            }
        }
    }

    static double getDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        sc.nextLine()
                );

            } catch (Exception e) {

                System.out.println("Please enter a valid amount.");
            }
        }
    }

    static String getString(String message) {

        System.out.print(message);

        return sc.nextLine().trim();
    }
}


// =====================================================
// PERSON CLASS
// =====================================================

class Person {

    protected String name;
    protected String email;

    public Person(String name, String email) {

        this.name = name;
        this.email = email;
    }
}


// =====================================================
// USER CLASS
// Inheritance: User extends Person
// =====================================================

class User extends Person {

    private String username;
    private String password;

    Account account;
    Loan loan;

    public User(
            String username,
            String password,
            String email,
            String accountType) {

        super(username, email);

        this.username = username;
        this.password = password;

        if (accountType.equalsIgnoreCase("Current")) {

            account = new CurrentAccount();

        } else {

            account = new SavingAccount();
        }

        loan = new Loan();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ================= ACCOUNT DETAILS =================

    public void showDetails() {

        System.out.println("\n================================");
        System.out.println("        ACCOUNT DETAILS");
        System.out.println("================================");

        System.out.println("Username     : " + username);
        System.out.println("Name         : " + name);
        System.out.println("Email        : " + email);
        System.out.println("Account Type : "
                + account.getAccountType());
        System.out.println("Account No.  : "
                + account.accountNumber);
        System.out.println("Balance      : ₹"
                + account.getBalance());
    }
}


// =====================================================
// ABSTRACT ACCOUNT CLASS
// =====================================================

abstract class Account {

    static int nextAccountNumber = 1001;

    String accountNumber;
    double balance;

    String accountType;

    String[] transactions = new String[100];
    int transactionCount = 0;

    public Account(String accountType) {

        this.accountType = accountType;

        accountNumber =
                "ACC" + nextAccountNumber++;
    }

    // ================= GET METHODS =================

    public double getBalance() {

        return balance;
    }

    public String getAccountType() {

        return accountType;
    }

    // ================= DEPOSIT =================

    public void deposit(double amount)
            throws BankException {

        if (amount <= 0) {

            throw new BankException(
                    "Amount must be greater than zero."
            );
        }

        balance = balance + amount;

        addTransaction(
                "Deposit : ₹" + amount
        );
    }

    // ================= WITHDRAW =================

    public void withdraw(double amount)
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

        addTransaction(
                "Withdraw : ₹" + amount
        );
    }

    // ================= TRANSACTION =================

    void addTransaction(String text) {

        if (transactionCount < transactions.length) {

            transactions[transactionCount] = text;

            transactionCount++;
        }
    }

    // ================= STATEMENT =================

    public void showStatement() {

        System.out.println("\n================================");
        System.out.println("       ACCOUNT STATEMENT");
        System.out.println("================================");

        if (transactionCount == 0) {

            System.out.println("No transactions.");

        } else {

            for (int i = 0; i < transactionCount; i++) {

                System.out.println(
                        (i + 1) + ". "
                                + transactions[i]
                );
            }
        }

        System.out.println("-------------------------------");
        System.out.println("Balance: ₹" + balance);
    }

    // Abstract method
    abstract double calculateInterest();
}


// =====================================================
// SAVING ACCOUNT
// Inheritance + Polymorphism
// =====================================================

class SavingAccount extends Account {

    public SavingAccount() {

        super("Saving");
    }

    @Override
    double calculateInterest() {

        return balance * 4 / 100;
    }
}


// =====================================================
// CURRENT ACCOUNT
// Inheritance + Polymorphism
// =====================================================

class CurrentAccount extends Account {

    public CurrentAccount() {

        super("Current");
    }

    @Override
    double calculateInterest() {

        return balance * 2 / 100;
    }
}


// =====================================================
// LOAN SERVICE INTERFACE
// =====================================================

interface LoanService {

    boolean approveLoan(
            double amount,
            double income,
            double balance
    );

    double calculateEMI(
            double amount,
            double rate,
            int years
    );
}


// =====================================================
// LOAN CLASS
// Implements Interface
// =====================================================

class Loan implements LoanService {

    double amount;
    double rate;
    int years;
    double emi;

    boolean approved = false;

    double totalPaid = 0;

    String[] history = new String[100];
    int historyCount = 0;


    // ================= LOAN APPROVAL =================

    @Override
    public boolean approveLoan(
            double amount,
            double income,
            double balance) {

        if (amount <= 0) {
            return false;
        }

        if (income < 15000) {
            return false;
        }

        if (balance < 1000) {
            return false;
        }

        if (amount > income * 20) {
            return false;
        }

        return true;
    }


    // ================= EMI CALCULATION =================

    @Override
    public double calculateEMI(
            double amount,
            double rate,
            int years) {

        double monthlyRate =
                rate / 12 / 100;

        int months = years * 12;

        if (monthlyRate == 0) {

            return amount / months;
        }

        double emi =
                amount
                        * monthlyRate
                        * Math.pow(
                                1 + monthlyRate,
                                months
                        )
                        /
                        (
                                Math.pow(
                                        1 + monthlyRate,
                                        months
                                ) - 1
                        );

        return emi;
    }


    // ================= APPLY LOAN =================

    public void apply(
            double amount,
            double income,
            double balance,
            int years) {

        if (approved) {

            System.out.println(
                    "You already have a loan."
            );

            return;
        }

        if (!approveLoan(
                amount,
                income,
                balance)) {

            System.out.println(
                    "Loan application rejected."
            );

            System.out.println(
                    "Minimum income: ₹15000"
            );

            System.out.println(
                    "Minimum balance: ₹1000"
            );

            return;
        }

        this.amount = amount;
        this.rate = 8.5;
        this.years = years;

        emi = calculateEMI(
                amount,
                rate,
                years
        );

        approved = true;

        totalPaid = 0;

        System.out.println(
                "\nLoan approved successfully!"
        );

        System.out.println(
                "Loan Amount : ₹" + amount
        );

        System.out.println(
                "Interest    : " + rate + "%"
        );

        System.out.println(
                "Years       : " + years
        );

        System.out.println(
                "Monthly EMI : ₹"
                        + String.format(
                                "%.2f",
                                emi
                        )
        );
    }


    // ================= PAY EMI =================

    public void payEMI(Account account) {

        if (!approved) {

            System.out.println(
                    "No approved loan."
            );

            return;
        }

        double remaining =
                getRemaining();

        if (remaining <= 0) {

            System.out.println(
                    "Loan is already paid."
            );

            return;
        }

        double payment = emi;

        if (payment > remaining) {

            payment = remaining;
        }

        try {

            account.withdraw(payment);

            totalPaid =
                    totalPaid + payment;

            history[historyCount] =
                    "EMI Paid : ₹"
                            + String.format(
                                    "%.2f",
                                    payment
                            );

            historyCount++;

            System.out.println(
                    "EMI paid successfully."
            );

            System.out.println(
                    "Remaining Loan: ₹"
                            + String.format(
                                    "%.2f",
                                    getRemaining()
                            )
            );

        } catch (BankException e) {

            System.out.println(
                    "EMI failed: "
                            + e.getMessage()
            );
        }
    }


    // ================= TOTAL PAYABLE =================

    public double getTotalPayable() {

        return emi * years * 12;
    }


    // ================= REMAINING LOAN =================

    public double getRemaining() {

        double remaining =
                getTotalPayable()
                        - totalPaid;

        if (remaining < 0) {

            return 0;
        }

        return remaining;
    }


    // ================= INTEREST =================

    public double getInterest() {

        return getTotalPayable()
                - amount;
    }


    // ================= LOAN DETAILS =================

    public void showDetails() {

        System.out.println("\n================================");
        System.out.println("          LOAN DETAILS");
        System.out.println("================================");

        if (!approved) {

            System.out.println(
                    "No approved loan."
            );

            return;
        }

        System.out.println(
                "Loan Amount : ₹" + amount
        );

        System.out.println(
                "Interest    : " + rate + "%"
        );

        System.out.println(
                "Duration    : " + years + " years"
        );

        System.out.println(
                "Monthly EMI : ₹"
                        + String.format(
                                "%.2f",
                                emi
                        )
        );

        System.out.println(
                "Total Payable : ₹"
                        + String.format(
                                "%.2f",
                                getTotalPayable()
                        )
        );

        System.out.println(
                "Total Paid : ₹"
                        + String.format(
                                "%.2f",
                                totalPaid
                        )
        );

        System.out.println(
                "Remaining : ₹"
                        + String.format(
                                "%.2f",
                                getRemaining()
                        )
        );

        if (getRemaining() == 0) {

            System.out.println(
                    "Status : PAID"
            );

        } else {

            System.out.println(
                    "Status : ACTIVE"
            );
        }
    }


    // ================= INTEREST DETAILS =================

    public void showInterest() {

        if (!approved) {

            System.out.println(
                    "No approved loan."
            );

            return;
        }

        System.out.println(
                "Total Loan Interest: ₹"
                        + String.format(
                                "%.2f",
                                getInterest()
                        )
        );
    }


    // ================= PAYMENT HISTORY =================

    public void showHistory() {

        System.out.println("\n================================");
        System.out.println("       LOAN PAYMENT HISTORY");
        System.out.println("================================");

        if (historyCount == 0) {

            System.out.println(
                    "No EMI payments."
            );

            return;
        }

        for (int i = 0;
             i < historyCount;
             i++) {

            System.out.println(
                    (i + 1)
                            + ". "
                            + history[i]
            );
        }
    }


    // ================= LOAD LOAN DATA =================

    public void setData(
            double amount,
            double rate,
            int years,
            double totalPaid,
            boolean approved) {

        this.amount = amount;
        this.rate = rate;
        this.years = years;
        this.totalPaid = totalPaid;
        this.approved = approved;

        if (approved) {

            emi = calculateEMI(
                    amount,
                    rate,
                    years
            );
        }
    }
}


// =====================================================
// CUSTOM EXCEPTION
// =====================================================

class BankException extends Exception {

    public BankException(String message) {

        super(message);
    }
}


// =====================================================
// BANK CLASS
// =====================================================

class Bank {

    User[] users = new User[100];

    int userCount = 0;

    User currentUser = null;


    // ================= REGISTER =================

    public void register() {

        System.out.println("\n================================");
        System.out.println("          REGISTER");
        System.out.println("================================");

        String username =
                Main.getString(
                        "Enter username: "
                );

        if (username.isEmpty()) {

            System.out.println(
                    "Username cannot be empty."
            );

            return;
        }

        // Check duplicate username

        for (int i = 0;
             i < userCount;
             i++) {

            if (users[i]
                    .getUsername()
                    .equalsIgnoreCase(username)) {

                System.out.println(
                        "Username already exists."
                );

                return;
            }
        }


        String password =
                Main.getString(
                        "Enter password: "
                );

        if (password.length() < 4) {

            System.out.println(
                    "Password must contain at least 4 characters."
            );

            return;
        }


        String email =
                Main.getString(
                        "Enter email: "
                );

        if (!email.contains("@")) {

            System.out.println(
                    "Invalid email."
            );

            return;
        }


        System.out.println("\nAccount Type");

        System.out.println(
                "1. Saving Account"
        );

        System.out.println(
                "2. Current Account"
        );

        int type =
                Main.getInt(
                        "Enter choice: "
                );

        String accountType;

        if (type == 2) {

            accountType = "Current";

        } else {

            accountType = "Saving";
        }


        User user =
                new User(
                        username,
                        password,
                        email,
                        accountType
                );

        users[userCount] = user;

        userCount++;


        System.out.println(
                "\nRegistration successful!"
        );

        System.out.println(
                "Your Account Number: "
                        + user.account.accountNumber
        );
    }


    // ================= LOGIN =================

    public void login() {

        System.out.println("\n================================");
        System.out.println("             LOGIN");
        System.out.println("================================");

        String username =
                Main.getString(
                        "Enter username: "
                );

        String password =
                Main.getString(
                        "Enter password: "
                );


        for (int i = 0;
             i < userCount;
             i++) {

            if (users[i]
                    .getUsername()
                    .equals(username)
                    &&
                    users[i]
                            .getPassword()
                            .equals(password)) {

                currentUser = users[i];

                System.out.println(
                        "Login successful!"
                );

                return;
            }
        }

        System.out.println(
                "Invalid username or password."
        );
    }


    // ================= LOGOUT =================

    public void logout() {

        currentUser = null;

        System.out.println(
                "Logout successful."
        );
    }


    // ================= CHANGE PASSWORD =================

    public void changePassword() {

        String oldPassword =
                Main.getString(
                        "Enter old password: "
                );

        if (!currentUser
                .getPassword()
                .equals(oldPassword)) {

            System.out.println(
                    "Wrong password."
            );

            return;
        }

        String newPassword =
                Main.getString(
                        "Enter new password: "
                );

        if (newPassword.length() < 4) {

            System.out.println(
                    "Password is too short."
            );

            return;
        }

        currentUser.setPassword(
                newPassword
        );

        System.out.println(
                "Password changed successfully."
        );
    }


    // ================= APPLY LOAN =================

    public void applyLoan() {

        System.out.println("\n================================");
        System.out.println("          LOAN APPLICATION");
        System.out.println("================================");

        double amount =
                Main.getDouble(
                        "Enter loan amount: "
                );

        double income =
                Main.getDouble(
                        "Enter monthly income: "
                );

        int years =
                Main.getInt(
                        "Enter loan years: "
                );


        currentUser.loan.apply(
                amount,
                income,
                currentUser.account.getBalance(),
                years
        );
    }


    // ================= PAY EMI =================

    public void payEMI() {

        currentUser.loan.payEMI(
                currentUser.account
        );
    }


    // ================= STATISTICS =================

    public void statistics() {

        int saving = 0;
        int current = 0;
        int loans = 0;

        double totalBalance = 0;
        double totalLoan = 0;


        for (int i = 0;
             i < userCount;
             i++) {

            User user = users[i];

            totalBalance +=
                    user.account.getBalance();


            if (user.account
                    .getAccountType()
                    .equals("Saving")) {

                saving++;

            } else {

                current++;
            }


            if (user.loan.approved) {

                loans++;

                totalLoan +=
                        user.loan.amount;
            }
        }


        System.out.println("\n================================");
        System.out.println("        BANK STATISTICS");
        System.out.println("================================");

        System.out.println(
                "Total Users      : " + userCount
        );

        System.out.println(
                "Saving Accounts  : " + saving
        );

        System.out.println(
                "Current Accounts : " + current
        );

        System.out.println(
                "Total Balance    : ₹"
                        + String.format(
                                "%.2f",
                                totalBalance
                        )
        );

        System.out.println(
                "Approved Loans   : " + loans
        );

        System.out.println(
                "Total Loan Amount: ₹"
                        + String.format(
                                "%.2f",
                                totalLoan
                        )
        );
    }


    // ================= SAVE DATA =================

    public void saveData() {

        try {

            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter(
                                    "users.txt"
                            )
                    );


            for (int i = 0;
                 i < userCount;
                 i++) {

                User u = users[i];

                writer.println(
                        u.getUsername()
                                + ","
                                + u.getPassword()
                                + ","
                                + u.email
                                + ","
                                + u.account.getAccountType()
                                + ","
                                + u.account.getBalance()
                                + ","
                                + u.loan.amount
                                + ","
                                + u.loan.rate
                                + ","
                                + u.loan.years
                                + ","
                                + u.loan.totalPaid
                                + ","
                                + u.loan.approved
                );
            }


            writer.close();

            System.out.println(
                    "Data saved successfully."
            );

        } catch (Exception e) {

            System.out.println(
                    "Error saving data."
            );
        }
    }


    // ================= LOAD DATA =================

    public void loadData() {

        File file =
                new File("users.txt");

        if (!file.exists()) {

            return;
        }


        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;


            while ((line =
                    reader.readLine())
                    != null) {

                String[] data =
                        line.split(",");


                if (data.length < 10) {
                    continue;
                }


                String username = data[0];
                String password = data[1];
                String email = data[2];
                String accountType = data[3];

                double balance =
                        Double.parseDouble(data[4]);

                double loanAmount =
                        Double.parseDouble(data[5]);

                double rate =
                        Double.parseDouble(data[6]);

                int years =
                        Integer.parseInt(data[7]);

                double totalPaid =
                        Double.parseDouble(data[8]);

                boolean approved =
                        Boolean.parseBoolean(data[9]);


                User user =
                        new User(
                                username,
                                password,
                                email,
                                accountType
                        );


                user.account.balance =
                        balance;


                user.loan.setData(
                        loanAmount,
                        rate,
                        years,
                        totalPaid,
                        approved
                );


                users[userCount] = user;

                userCount++;
            }


            reader.close();

            System.out.println(
                    "Previous data loaded."
            );

        } catch (Exception e) {

            System.out.println(
                    "Error loading data."
            );
        }
    }
}