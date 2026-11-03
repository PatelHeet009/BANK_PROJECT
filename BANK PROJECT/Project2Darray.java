// Admin --- us=admin2598 || psw=admin696548

import java.util.*;

class project {
    public static void main(String[] args) {

        Scanner ob = new Scanner(System.in);
        String repeat;
        int count = 0;
        int pinn;
        Object users[][] = new Object[500][13];
        /*
         * Column:
         * 0 = Name
         * 1 = Address
         * 2 = Gender
         * 3 = DOB
         * 4 = Email
         * 5 = Mobile
         * 6 = Username
         * 7 = Password
         * 8 = PIN
         * 9 = Account Type
         * 10 = Balance
         * 11 = Account Number
         * 12 = Transaction Count
         */

        System.out.println("===================================");
        System.out.println("         Welcome to the App");
        System.out.println("===================================");

        do {
            System.out.print("Enter the choice of Operation [1=Register , 2=Login , 3=Exit.]: ");
            int log = ob.nextInt();
            ob.nextLine();

            switch (log) {

                // =====================================================
                // REGISTRATION
                // =====================================================

                case 1:

                    if (count >= 500) {
                        System.out.println("Maximum user limit reached.");
                        break;
                    }

                    System.out.println("===================================");
                    System.out.println("         Registration Form");
                    System.out.println("===================================");

                    // Name
                    System.out.print("Enter Name: ");
                    users[count][0] = ob.nextLine();

                    // Address
                    System.out.print("Enter Address: ");
                    users[count][1] = ob.nextLine();

                    // Gender
                    System.out.print("Enter Gender: ");
                    users[count][2] = ob.next().charAt(0);

                    // =================================================
                    // DOB VALIDATION
                    // =================================================

                    do {

                        System.out.print("Enter Date of Birth (DD/MM/YYYY): ");

                        users[count][3] = ob.next();
                        if (!users[count][3].toString().matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}")) {

                            System.out.println("Invalid DOB. Please use DD/MM/YYYY format.");
                        }
                    } while (!users[count][3].toString().matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}"));

                    // =================================================
                    // EMAIL VALIDATION
                    // =================================================

                    do {
                        System.out.print("Enter Email: ");

                        users[count][4] = ob.next();
                        String currentEmail = users[count][4].toString();
                        int digitCount = 0;

                        for (int j = 0; j < currentEmail.length(); j++) {
                            if (Character.isDigit(currentEmail.charAt(j))) {
                                digitCount++;
                            }
                        }

                        boolean hasAt = currentEmail.contains("@");
                        boolean hasCom = currentEmail.endsWith(".com");
                        boolean hasIn = currentEmail.endsWith(".in");

                        if (!hasAt || digitCount < 3 || (!hasCom && !hasIn)) {
                            System.out.println("Invalid Email. Email must contain @, "
                                    + "minimum 3 digits and end with .com or .in.");
                        } else {
                            break;
                        }
                    } while (true);
                    // =================================================
                    // MOBILE VALIDATION
                    // =================================================

                    String mobileInput;
                    do {

                        System.out.print("Enter Mobile No: ");
                        mobileInput = ob.next();
                        if (!mobileInput.matches("\\d{10}")) {
                            System.out.println("Invalid mobile number. " + "Please enter exactly 10 digits.");
                        }

                    } while (!mobileInput.matches("\\d{10}"));
                    users[count][5] = Long.parseLong(mobileInput);

                    // =================================================
                    // USERNAME VALIDATION
                    // =================================================

                    do {

                        System.out.print("Enter new username: ");

                        users[count][6] = ob.next();
                        String currentUsername = users[count][6].toString();
                        int digitCount = 0;

                        for (int j = 0; j < currentUsername.length(); j++) {
                            if (Character.isDigit(currentUsername.charAt(j))) {
                                digitCount++;
                            }
                        }

                        boolean firstCapital = currentUsername.length() > 0
                                && Character.isUpperCase(currentUsername.charAt(0));

                        boolean hasAt = currentUsername.contains("@");

                        if (!firstCapital || digitCount < 3 || !hasAt) {
                            System.out.println(
                                    "Username must start with a capital " + "letter, contain minimum 3 digits and @.");
                        } else {
                            break;
                        }
                    } while (true);

                    // =================================================
                    // PASSWORD VALIDATION
                    // =================================================

                    do {

                        System.out.print("Enter new password: ");

                        users[count][7] = ob.next();

                        String currentPassword = users[count][7].toString();

                        boolean upper = false;
                        boolean lower = false;
                        boolean special = false;

                        int digitCount = 0;

                        for (int j = 0; j < currentPassword.length(); j++) {

                            char c = currentPassword.charAt(j);

                            if (Character.isUpperCase(c)) {
                                upper = true;
                            }

                            if (Character.isLowerCase(c)) {
                                lower = true;
                            }

                            if (Character.isDigit(c)) {
                                digitCount++;
                            }

                            if (!Character.isLetterOrDigit(c)) {
                                special = true;
                            }
                        }

                        if (currentPassword.length() < 6 || !upper || !lower || !special || digitCount < 3) {

                            System.out.println("Password must be minimum 6 characters, " + "contain minimum 3 digits, "
                                    + "1 uppercase, 1 lowercase " + "and 1 special character.");

                        } else {
                            break;
                        }

                    } while (true);

                    // =================================================
                    // PIN
                    // =================================================

                    do {
                        System.out.print("Set PIN of 4 digits(0-9): ");

                        users[count][8] = ob.nextInt();
                        int currentPin = (Integer) users[count][8];

                        if (currentPin < 0 || currentPin > 9999) {
                            System.out.println("PIN must contain exactly 4 digits.");
                        } else {
                            break;
                        }

                    } while (true);

                    // =================================================
                    // ACCOUNT TYPE
                    // =================================================

                    int accChoice;
                    do {
                        System.out.print("Choose Account Type " + "[1=Saving , 2=Current]: ");
                        accChoice = ob.nextInt();
                        if (accChoice != 1 && accChoice != 2) {
                            System.out.println("Invalid choice, " + "please enter 1 or 2.");
                        }
                    } while (accChoice != 1 && accChoice != 2);
                    users[count][9] = (accChoice == 1) ? "Saving" : "Current";

                    // Transaction count
                    users[count][12] = 0;

                    // =================================================
                    // SAVING ACCOUNT EMAIL VALIDATION
                    // =================================================

                    if (users[count][9].equals("Saving")) {

                        boolean savingEmailValid = users[count][4].toString()
                                .matches("[A-Za-z0-9._%+-]+@(gmail|yahoo)\\.com");

                        while (!savingEmailValid) {

                            System.out.println("Your email does not meet the " + "Saving Account requirement.");
                            System.out.println("For Saving Account, use a valid " + "Gmail.com or Yahoo.com email "
                                    + "ending in .com.");
                            System.out.print("Enter a new Email: ");

                            users[count][4] = ob.next();

                            String newEmail = users[count][4].toString();

                            int digitCount = 0;

                            for (int j = 0; j < newEmail.length(); j++) {
                                if (Character.isDigit(newEmail.charAt(j))) {
                                    digitCount++;
                                }
                            }

                            boolean hasAt = newEmail.contains("@");
                            boolean hasCom = newEmail.endsWith(".com");
                            boolean hasIn = newEmail.endsWith(".in");

                            if (!hasAt || digitCount < 3 || (!hasCom && !hasIn)) {
                                System.out.println("Invalid Email. Email must contain @, "
                                        + "minimum 3 digits and end with .com or .in.");

                                continue;
                            }

                            savingEmailValid = newEmail.matches("[A-Za-z0-9._%+-]+@(gmail|yahoo)\\.com");
                        }
                    }

                    // =================================================
                    // CURRENT ACCOUNT EMAIL VALIDATION (business email,
                    // not gmail/yahoo)
                    // =================================================

                    if (users[count][9].equals("Current")) {

                        boolean currentEmailValid = isBusinessEmail(users[count][4].toString());

                        while (!currentEmailValid) {

                            System.out.println("Your email does not meet the " + "Current Account requirement.");
                            System.out.println("For Current Account, use a business " + "email (not Gmail/Yahoo), "
                                    + "ending in .com, .in, .org, or .co.in.");
                            System.out.print("Enter a new Email: ");

                            users[count][4] = ob.next();

                            String newEmail = users[count][4].toString();

                            int digitCount = 0;

                            for (int j = 0; j < newEmail.length(); j++) {
                                if (Character.isDigit(newEmail.charAt(j))) {
                                    digitCount++;
                                }
                            }

                            boolean hasAt = newEmail.contains("@");
                            boolean hasCom = newEmail.endsWith(".com");
                            boolean hasIn = newEmail.endsWith(".in");

                            if (!hasAt || digitCount < 3 || (!hasCom && !hasIn)) {
                                System.out.println("Invalid Email. Email must contain @, "
                                        + "minimum 3 digits and end with .com or .in.");

                                continue;
                            }

                            currentEmailValid = isBusinessEmail(newEmail);
                        }
                    }

                    // =================================================
                    // OPENING BALANCE
                    // =================================================

                    double opbalance;
                    do {
                        System.out.print("Enter opening balance " + "[minimum 20000]: ");
                        opbalance = ob.nextDouble();
                        if (opbalance < 20000) {
                            System.out.println("Opening balance should be " + "minimum 20000, please enter again.");
                        }

                    } while (opbalance < 20000);

                    users[count][10] = opbalance;

                    // =================================================
                    // SAVING -> CURRENT
                    // =================================================

                    if (users[count][9].equals("Saving") && (Double) users[count][10] > 1000000) {

                        users[count][9] = "Current";

                        System.out.println("Opening balance exceeds 10,00,000. " + "Your account has been switched "
                                + "to Current account.");
                    }

                    // =================================================
                    // ACCOUNT NUMBER
                    // =================================================

                    users[count][11] = (long) (Math.random() * 9999999999.0f + 10000000000.0f);

                    count++;
                    System.out.println("Registered Successfully.");
                    break;

                // =====================================================
                // LOGIN
                // =====================================================

                case 2:

                    System.out.println("===================================");
                    System.out.println("               Login");
                    System.out.println("===================================");

                    System.out.print("Enter username: ");
                    String loginUser = ob.next();

                    System.out.print("Enter password: ");
                    String loginPwd = ob.next();

                    boolean found = false;
                    int loginIndex = -1;

                    for (int i = 0; i < count; i++) {
                        if (users[i][6].equals(loginUser) && users[i][7].equals(loginPwd)) {
                            found = true;
                            loginIndex = i;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("===================================");
                        System.out.println("       Logged In Successfully");
                        System.out.println("===================================");

                        System.out.println("Your Account No is : " + users[loginIndex][11]);
                        System.out.println("Your Account Type is : " + users[loginIndex][9]);

                        boolean loggedIn = true;
                        while (loggedIn) {
                            System.out.println("===================================");
                            System.out.println("            Account Menu");
                            System.out.println("===================================");

                            System.out.print("1. Make Transaction\n" + "2. View Balance\n" + "3. View Account Details\n"
                                    + "4. Exit\n" + "Enter choice: ");
                            int choice = ob.nextInt();
                            switch (choice) {

                                // =====================================
                                // TRANSACTION
                                // =====================================

                                case 1:
                                    int transCount = (Integer) users[loginIndex][12];
                                    if (users[loginIndex][9].equals("Saving") && (transCount + 1) == 15) {

                                        System.out.println("Alert: If you proceed with " + "this transaction, your "
                                                + "account will be switched " + "to a Current account.");
                                    }
                                    System.out.print("Press 1 for Deposit, " + "2 for Withdraw: ");

                                    int trchoice = ob.nextInt();

                                    // ===============================
                                    // DEPOSIT
                                    // ===============================

                                    if (trchoice == 1) {

                                        System.out.print("Enter amount to deposit: ");

                                        double depositAmount = ob.nextDouble();
                                        double currentBalance = (Double) users[loginIndex][10];
                                        currentBalance += depositAmount;
                                        users[loginIndex][10] = currentBalance;
                                        users[loginIndex][12] = (Integer) users[loginIndex][12] + 1;

                                        System.out.println("Amount deposited successfully. " + "New Balance is : "
                                                + users[loginIndex][10]);
                                    }
                                    // ===============================
                                    // WITHDRAW
                                    // ===============================

                                    else if (trchoice == 2) {

                                        System.out.print("Enter amount to withdraw: ");
                                        double withdraw = ob.nextDouble();
                                        double currentBalance = (Double) users[loginIndex][10];

                                        if (currentBalance - withdraw < 20000) {
                                            System.out.println("Insufficient balance. " + "Please maintain balance "
                                                    + "of 20000.");

                                        } else {
                                            currentBalance -= withdraw;
                                            users[loginIndex][10] = currentBalance;
                                            users[loginIndex][12] = (Integer) users[loginIndex][12] + 1;
                                            System.out.println("Amount withdrawn successfully. " + "New Balance is: "
                                                    + users[loginIndex][10]);
                                        }
                                    } else {
                                        System.out.println("Invalid transaction choice.");
                                    }

                                    // ===============================
                                    // SAVING -> CURRENT CHECK
                                    // ===============================

                                    if (users[loginIndex][9].equals("Saving")) {
                                        double currentBalance = (Double) users[loginIndex][10];
                                        int currentTransCount = (Integer) users[loginIndex][12];

                                        if (currentBalance > 1000000) {

                                            users[loginIndex][9] = "Current";
                                            System.out.println("Your balance has crossed " + "10,00,000. Your account "
                                                    + "has been switched to " + "Current account.");

                                        } else if (currentTransCount >= 15) {

                                            users[loginIndex][9] = "Current";
                                            System.out.println("Your transaction count " + "has reached 15. Your "
                                                    + "account has been switched " + "to Current account.");
                                        }
                                    }
                                    break;
                                // =====================================
                                // VIEW BALANCE
                                // =====================================

                                case 2:
                                    System.out.print("Enter PIN : ");
                                    pinn = ob.nextInt();
                                    if ((Integer) users[loginIndex][8] == pinn) {
                                        System.out.println("Your Balance is: " + users[loginIndex][10]);

                                    } else {
                                        System.out.println("Please Enter Valid PIN.");
                                    }
                                    break;
                                // =====================================
                                // ACCOUNT DETAILS
                                // =====================================

                                case 3:
                                    System.out.print("Enter PIN : ");
                                    pinn = ob.nextInt();
                                    if ((Integer) users[loginIndex][8] == pinn) {
                                        System.out.println("Username: " + users[loginIndex][6] + " | Balance: "
                                                + users[loginIndex][10]);

                                        System.out.println("Mobile No: " + users[loginIndex][5] + " | Email: "
                                                + users[loginIndex][4]);
                                        System.out.println("Account Type: " + users[loginIndex][9]);
                                    } else {
                                        System.out.println("Please Enter Valid PIN.");
                                    }
                                    break;
                                // =====================================
                                // LOGOUT
                                // =====================================

                                case 4:
                                    loggedIn = false;
                                    System.out.println("Logging out...");
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                            }
                        }
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                // =====================================================
                // EXIT
                // =====================================================

                case 3:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid! Please enter valid " + "choice of operation.");
            }
            System.out.print("\nDo you want to re-login or re-register?: ");
            repeat = ob.next();
        } while (repeat.equals("yes") || repeat.equals("YES"));

        // =============================================================
        // VIEW REGISTERED USERS
        // =============================================================
        System.out.print("\nDo you want to view registered users?(yes/no): ");
        String viewChoice = ob.next();
        ob.nextLine();
        if (viewChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter choice [1=Admin , 2=User]: ");
            int finalChoice = ob.nextInt();
            ob.nextLine();
            // =========================================================
            // ADMIN
            // =========================================================

            if (finalChoice == 1) {
                System.out.print("Enter Admin Username: ");
                String adminUser = ob.nextLine();
                System.out.print("Enter Admin Password: ");
                String adminPass = ob.nextLine();
                if (adminUser.equals("admin2598") && adminPass.equals("admin696548")) {
                    boolean adminMenu = true;
                    while (adminMenu) {
                        System.out.println("===================================");
                        System.out.println("            Admin Menu");
                        System.out.println("===================================");
                        System.out.print("1. View All Users\n" + "2. Delete a User\n" + "3. Exit\n" + "Enter choice: ");
                        int achoice = ob.nextInt();
                        ob.nextLine();
                        switch (achoice) {
                            // =========================================
                            // VIEW ALL USERS
                            // =========================================

                            case 1:
                                System.out.println("===================================");
                                System.out.println("       All Registered Users");
                                System.out.println("===================================");
                                for (int i = 0; i < count; i++) {
                                    System.out.println(
                                            "Name: " + users[i][0] + " | Username: " + users[i][6] + " | Password: "
                                                    + users[i][7] + " | Account No: " + users[i][11]
                                                    + " | Account Type: " + users[i][9] + " | Balance: " + users[i][10]
                                                    + " | Mobile: " + users[i][5] + " | Email: " + users[i][4]);
                                }
                                break;
                            // =========================================
                            // DELETE USER
                            // =========================================
                            case 2:
                                System.out.print("Enter username to delete: ");
                                String delUser = ob.nextLine();
                                int delIndex = -1;
                                for (int i = 0; i < count; i++) {
                                    if (users[i][6].equals(delUser)) {
                                        delIndex = i;
                                        break;
                                    }
                                }
                                if (delIndex == -1) {
                                    System.out.println("User not found.");
                                } else {
                                    for (int i = delIndex; i < count - 1; i++) {
                                        for (int j = 0; j < 13; j++) {
                                            users[i][j] = users[i + 1][j];
                                        }
                                    }
                                    count--;
                                    System.out.println("User deleted successfully.");
                                }
                                break;
                            // =========================================
                            // EXIT ADMIN
                            // =========================================
                            case 3:
                                adminMenu = false;
                                System.out.println("Exiting Admin Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                } else {
                    System.out.println("Invalid Admin credentials. " + "Access Denied.");
                }
            } else if (finalChoice == 2) {
                System.out.print("Enter your Username: ");
                String u = ob.nextLine();
                System.out.print("Enter your Password: ");
                String p = ob.nextLine();
                int uIndex = -1;
                for (int i = 0; i < count; i++) {
                    if (users[i][6].equals(u) && users[i][7].equals(p)) {
                        uIndex = i;
                        break;
                    }
                }
                if (uIndex == -1) {
                    System.out.println("Invalid username or password.");
                } else {
                    boolean userMenu = true;
                    while (userMenu) {
                        System.out.println("===================================");
                        System.out.println("            User Menu");
                        System.out.println("===================================");
                        System.out.print(
                                "1. View Details\n" + "2. View Full Account Info\n" + "3. Delete My Account\n"
                                        + "4. Exit\n" + "Enter choice: ");

                        int uchoice = ob.nextInt();

                        ob.nextLine();
                        switch (uchoice) {
                            case 1:
                                System.out.println(
                                        "Name: " + users[uIndex][0] + " | Username: " + users[uIndex][6]
                                                + " | Account No: " + users[uIndex][11] + " | Account Type: "
                                                + users[uIndex][9]);
                                break;
                            case 2:
                                System.out.println(
                                        "Name: " + users[uIndex][0] + " | Username: " + users[uIndex][6]
                                                + " | Address: " + users[uIndex][1] + " | Gender: " + users[uIndex][2]
                                                + " | DOB: " + users[uIndex][3] + " | Email: " + users[uIndex][4]
                                                + " | Mobile: " + users[uIndex][5] + " | Account No: "
                                                + users[uIndex][11] + " | Account Type: " + users[uIndex][9]
                                                + " | Balance: " + users[uIndex][10]);
                                break;
                            case 3:
                                for (int i = uIndex; i < count - 1; i++) {
                                    for (int j = 0; j < 13; j++) {
                                        users[i][j] = users[i + 1][j];
                                    }
                                }
                                count--;
                                System.out.println("Your account has been " + "deleted successfully.");
                                userMenu = false;
                                break;
                            case 4:
                                userMenu = false;
                                System.out.println("Exiting...");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }
        ob.close();
    }

    private static boolean isBusinessEmail(String email) {
        boolean isGmailOrYahoo = email.matches("[A-Za-z0-9._%+-]+@(gmail|yahoo)\\.com");
        boolean endsInBusinessDomain = email.matches(".+\\.(com|in|org)$");
        return !isGmailOrYahoo && endsInBusinessDomain;
    }
}