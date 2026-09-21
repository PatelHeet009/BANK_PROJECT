import java.util.Scanner;

public class Week11 {
static Scanner sc = new Scanner(System.in);

static String username = "";
static String password = "";

static double balance = 0;

static boolean loggedIn = false;


public static void main(String[] args) {

    while (true) {

        if (!loggedIn) {

            System.out.println("\n===== BANK SYSTEM =====");

            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = getInt(
                    "Enter choice: "
            );


            if (choice == 1) {

                register();

            } else if (choice == 2) {

                login();

            } else if (choice == 3) {

                System.out.println(
                        "Thank you!"
                );

                break;

            } else {

                System.out.println(
                        "Invalid choice."
                );
            }


        } else {

            userMenu();
        }
    }
}


// ================= REGISTER =================

static void register() {

    System.out.println(
            "\n===== REGISTER ====="
    );

    System.out.print(
            "Enter username: "
    );

    username = sc.nextLine();

    System.out.print(
            "Enter password: "
    );

    password = sc.nextLine();

    System.out.println(
            "Registration successful!"
    );
}


// ================= LOGIN =================

static void login() {

    System.out.println(
            "\n===== LOGIN ====="
    );

    System.out.print(
            "Enter username: "
    );

    String user =
            sc.nextLine();

    System.out.print(
            "Enter password: "
    );

    String pass =
            sc.nextLine();


    if (user.equals(username)
            && pass.equals(password)) {

        loggedIn = true;

        System.out.println(
                "Login successful!"
        );

    } else {

        System.out.println(
                "Wrong username or password."
        );
    }
}


// ================= USER MENU =================

static void userMenu() {

    System.out.println(
            "\n===== USER MENU ====="
    );

    System.out.println(
            "1. Deposit"
    );

    System.out.println(
            "2. Withdraw"
    );

    System.out.println(
            "3. Check Balance"
    );

    System.out.println(
            "4. Account Details"
    );

    System.out.println(
            "5. Logout"
    );


    int choice =
            getInt("Enter choice: ");


    switch (choice) {

        case 1:

            deposit();

            break;


        case 2:

            withdraw();

            break;


        case 3:

            System.out.println(
                    "Balance: ₹"
                            + balance
            );

            break;


        case 4:

            showDetails();

            break;


        case 5:

            loggedIn = false;

            System.out.println(
                    "Logout successful."
            );

            break;


        default:

            System.out.println(
                    "Invalid choice."
            );
    }
}


// ================= DEPOSIT =================

static void deposit() {

    double amount =
            getDouble(
                    "Enter amount: "
            );


    if (amount <= 0) {

        System.out.println(
                "Invalid amount."
        );

        return;
    }


    balance =
            balance + amount;


    System.out.println(
            "Deposit successful."
    );
}


// ================= WITHDRAW =================

static void withdraw() {

    double amount =
            getDouble(
                    "Enter amount: "
            );


    if (amount <= 0) {

        System.out.println(
                "Invalid amount."
        );

        return;
    }


    if (amount > balance) {

        System.out.println(
                "Insufficient balance."
        );

        return;
    }


    balance =
            balance - amount;


    System.out.println(
            "Withdrawal successful."
    );
}


// ================= DETAILS =================

static void showDetails() {

    System.out.println(
            "\n===== ACCOUNT DETAILS ====="
    );

    System.out.println(
            "Username: " + username
    );

    System.out.println(
            "Balance: ₹" + balance
    );
}


// ================= INPUT =================

static int getInt(String message) {

    while (true) {

        try {

            System.out.print(message);

            return Integer.parseInt(
                    sc.nextLine()
            );

        } catch (Exception e) {

            System.out.println(
                    "Enter a valid number."
            );
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

            System.out.println(
                    "Enter a valid amount."
            );
        }
    }
}
}