//Admin --- us=admin2598 || psw = admin696548

import java.util.*;

class project {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        String repeat;
        int i;
        int count = 0;
        int pinn;
        String username[] = new String[500];
        String name[] = new String[500];
        String password[] = new String[500];
        String address[] = new String[1000];
        String dob[] = new String[500];
        char gen[] = new char[500];
        String email[] = new String[500];
        int pin[] = new int[500];
        long mob[] = new long[500];
        double balance[] = new double[500];
        long AccountNo[] = new long[500];
        String accountType[] = new String[500];
        int transCount[] = new int[500];

        System.out.println("===================================");
        System.out.println("         Welcome to the App");
        System.out.println("===================================");

        do {
            System.out.print("Enter the choice of Operation [1=Register , 2=Login , 3=Exit.]: ");
            int log = ob.nextInt();
            ob.nextLine();

            switch (log) {
                case 1:
                    System.out.println("===================================");
                    System.out.println("         Registration Form");
                    System.out.println("===================================");

                    System.out.print("Enter Name: ");
                    name[count] = ob.nextLine();

                    System.out.print("Enter Address: ");
                    address[count] = ob.nextLine();

                    System.out.print("Enter Gender: ");
                    gen[count] = ob.next().charAt(0);

                    // DOB validation
                    do {
                        System.out.print("Enter Date of Birth (DD/MM/YYYY): ");
                        dob[count] = ob.next();

                        if (!dob[count].matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}")) {
                            System.out.println("Invalid DOB. Please use DD/MM/YYYY format.");
                        }
                    } while (!dob[count].matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}"));

                    // Basic Email validation
                    do {
                        System.out.print("Enter Email: ");
                        email[count] = ob.next();

                        int digitCount = 0;
                        for (int j = 0; j < email[count].length(); j++) {
                            if (Character.isDigit(email[count].charAt(j))) {
                                digitCount++;
                            }
                        }

                        boolean hasAt = email[count].contains("@");
                        boolean hasCom = email[count].endsWith(".com");
                        boolean hasIn = email[count].endsWith(".in");

                        if (!hasAt || digitCount < 3 || (!hasCom && !hasIn)) {
                            System.out.println(
                                    "Invalid Email. Email must contain @, minimum 3 digits and end with .com or .in.");
                        } else {
                            break;
                        }
                    } while (true);

                    System.out.print("Enter Mobile No: ");
                    String mobileInput;
                    do {
                        mobileInput = ob.next();

                        if (!mobileInput.matches("\\d{10}")) {
                            System.out.println("Invalid mobile number. Please enter exactly 10 digits.");
                        }
                    } while (!mobileInput.matches("\\d{10}"));
                    mob[count] = Long.parseLong(mobileInput);

                    // Username validation
                    do {
                        System.out.print("Enter new username: ");
                        username[count] = ob.next();

                        int digitCount = 0;
                        for (int j = 0; j < username[count].length(); j++) {
                            if (Character.isDigit(username[count].charAt(j))) {
                                digitCount++;
                            }
                        }

                        boolean firstCapital = username[count].length() > 0
                                && Character.isUpperCase(username[count].charAt(0));
                        boolean hasAt = username[count].contains("@");

                        if (!firstCapital || digitCount < 3 || !hasAt) {
                            System.out.println(
                                    "Username must start with a capital letter, contain minimum 3 digits and @.");
                        } else {
                            break;
                        }
                    } while (true);

                    // Password validation
                    do {
                        System.out.print("Enter new password: ");
                        password[count] = ob.next();

                        boolean upper = false;
                        boolean lower = false;
                        boolean special = false;
                        int digitCount = 0;

                        for (int j = 0; j < password[count].length(); j++) {
                            char c = password[count].charAt(j);

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

                        if (password[count].length() < 6 || !upper || !lower
                                || !special || digitCount < 3) {
                            System.out.println(
                                    "Password must be minimum 6 characters, contain minimum 3 digits, "
                                            + "1 uppercase, 1 lowercase and 1 special character.");
                        } else {
                            break;
                        }
                    } while (true);

                    System.out.print("Set PIN of 4 digits(0-9): ");
                    pin[count] = ob.nextInt();

                    int accChoice;
                    do {
                        System.out.print("Choose Account Type [1=Saving , 2=Current]: ");
                        accChoice = ob.nextInt();

                        if (accChoice != 1 && accChoice != 2) {
                            System.out.println("Invalid choice, please enter 1 or 2.");
                        }
                    } while (accChoice != 1 && accChoice != 2);

                    accountType[count] = (accChoice == 1) ? "Saving" : "Current";
                    transCount[count] = 0;

                    // Check the already-entered email according to account type
                    if (accountType[count].equals("Saving")) {
                        boolean savingEmailValid = email[count].matches("[A-Za-z0-9._%+-]+@(gmail|yahoo)\\.com");

                        while (!savingEmailValid) {
                            System.out.println(
                                    "Your email does not meet the Saving Account requirement.");
                            System.out.println(
                                    "For Saving Account, use a valid Gmail.com or Yahoo.com email ending in .com.");
                            System.out.print("Enter a new Email: ");
                            email[count] = ob.next();

                            int digitCount = 0;
                            for (int j = 0; j < email[count].length(); j++) {
                                if (Character.isDigit(email[count].charAt(j))) {
                                    digitCount++;
                                }
                            }

                            boolean hasAt = email[count].contains("@");
                            boolean hasCom = email[count].endsWith(".com");
                            boolean hasIn = email[count].endsWith(".in");

                            if (!hasAt || digitCount < 3 || (!hasCom && !hasIn)) {
                                System.out.println(
                                        "Invalid Email. Email must contain @, minimum 3 digits and end with .com or .in.");
                                continue;
                            }

                            savingEmailValid = email[count].matches("[A-Za-z0-9._%+-]+@(gmail|yahoo)\\.com");
                        }
                    }

                    double opbalance;

                    do {
                        System.out.print("Enter opening balance [minimum 20000]: ");
                        opbalance = ob.nextDouble();

                        if (opbalance < 20000) {
                            System.out.print("Opening balance should be minimum 20000, please enter again.\n");
                        }

                    } while (opbalance < 20000);

                    balance[count] = opbalance;

                    if (accountType[count].equals("Saving") && balance[count] > 1000000) {
                        accountType[count] = "Current";
                        System.out.println(
                                "Opening balance exceeds 10,00,000. Your account has been switched to Current account.");
                    }

                    AccountNo[count] = (long) (Math.random() * 9999999999.0f + 10000000000.0f);

                    count++;
                    System.out.println("Registered Successfully.");
                    break;

                case 2:
                    System.out.println("===================================");
                    System.out.println("               Login");
                    System.out.println("===================================");

                    System.out.print("Enter username: ");
                    String loginUser = ob.next();
                    System.out.print("Enter password: ");
                    String loginPwd = ob.next();

                    boolean found = false;

                    for (i = 0; i < count; i++) {
                        if (username[i].equals(loginUser) && password[i].equals(loginPwd)) {
                            found = true;
                            break;
                        }
                    }

                    if (found) {

                        System.out.println("===================================");
                        System.out.println("       Logged In Successfully");
                        System.out.println("===================================");

                        System.out.println("Your Account No is : " + AccountNo[i]);
                        System.out.println("Your Account Type is : " + accountType[i]);

                        boolean loggedIn = true;

                        while (loggedIn) {
                            System.out.println("===================================");
                            System.out.println("            Account Menu");
                            System.out.println("===================================");

                            System.out.print(
                                    "1. Make Transaction \n 2. View Balance \n 3. View Account Details \n 4. Exit \n Enter choice: ");

                            int choice = ob.nextInt();

                            switch (choice) {
                                case 1:
                                    if (accountType[i].equals("Saving") && (transCount[i] + 1) == 15) {
                                        System.out.println(
                                                "Alert: If you proceed with this transaction, your account will be switched to a Current account.");
                                    }

                                    System.out.print("Press 1 for Deposit, 2 for Withdraw: ");
                                    int trchoice = ob.nextInt();

                                    if (trchoice == 1) {
                                        System.out.print("Enter amount to deposit: ");
                                        double depositAmount = ob.nextDouble();

                                        balance[i] += depositAmount;
                                        transCount[i]++;
                                        System.out.println(
                                                "Amount deposited successfully. New Balance is : " + balance[i]);

                                    } else if (trchoice == 2) {
                                        System.out.print("Enter amount to withdraw: ");
                                        double withdraw = ob.nextDouble();

                                        if (balance[i] - withdraw < 20000) {
                                            System.out
                                                    .println("Insufficient balance. Please maintain balance of 20000.");
                                        } else {
                                            balance[i] -= withdraw;
                                            transCount[i]++;
                                            System.out.println(
                                                    "Amount withdrawn successfully. New Balance is: " + balance[i]);
                                        }
                                    } else {
                                        System.out.println("Invalid transaction choice.");
                                    }

                                    if (accountType[i].equals("Saving")) {

                                        if (balance[i] > 1000000) {
                                            accountType[i] = "Current";
                                            System.out.println(
                                                    "Your balance has crossed 10,00,000. Your account has been switched to Current account.");
                                        } else if (transCount[i] >= 15) {
                                            accountType[i] = "Current";
                                            System.out.println(
                                                    "Your transaction count has reached 15. Your account has been switched to Current account.");
                                        }
                                    }

                                    break;

                                case 2:
                                    System.out.print("Enter PIN : ");
                                    pinn = ob.nextInt();
                                    if (pin[i] == pinn) {
                                        System.out.println("Your Balance is: " + balance[i]);
                                    } else {
                                        System.out.println("Please Enter Valid PIN.");
                                    }
                                    break;

                                case 3:
                                    System.out.print("Enter PIN : ");
                                    pinn = ob.nextInt();

                                    if (pin[i] == pinn) {
                                        System.out.println("Username: " + username[i] + " | Balance: " + balance[i]);
                                        System.out.println("Mobile No: " + mob[i] + " | Email: " + email[i]);
                                        System.out.println("Account Type: " + accountType[i]);
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
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                case 3:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid! Please enter valid choice of operation.");
            }

            System.out.print("\nDo you want to re-login or re-register?: ");
            repeat = ob.next();

        } while (repeat.equals("yes") || repeat.equals("YES"));

        System.out.print("\nDo you want to view registered users?(yes/no): ");
        String viewChoice = ob.next();
        ob.nextLine();

        if (viewChoice.equalsIgnoreCase("yes")) {

            System.out.print("Enter choice [1=Admin , 2=User]: ");
            int finalChoice = ob.nextInt();
            ob.nextLine();

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
                        System.out.print("1. View All Users \n2. Delete a User \n3. Exit\nEnter choice: ");
                        int achoice = ob.nextInt();
                        ob.nextLine();

                        switch (achoice) {
                            case 1:
                                System.out.println("===================================");
                                System.out.println("       All Registered Users");
                                System.out.println("===================================");

                                for (i = 0; i < count; i++) {
                                    System.out.println("Name: " + name[i] + " | Username: " + username[i]
                                            + " | Password: " + password[i] + " | Account No: " + AccountNo[i]
                                            + " | Account Type: " + accountType[i] + " | Balance: " + balance[i]
                                            + " | Mobile: " + mob[i] + " | Email: " + email[i]);
                                }
                                break;

                            case 2:
                                System.out.print("Enter username to delete: ");
                                String delUser = ob.nextLine();

                                int delIndex = -1;
                                for (i = 0; i < count; i++) {
                                    if (username[i].equals(delUser)) {
                                        delIndex = i;
                                        break;
                                    }
                                }

                                if (delIndex == -1) {
                                    System.out.println("User not found.");
                                } else {
                                    for (i = delIndex; i < count - 1; i++) {
                                        username[i] = username[i + 1];
                                        name[i] = name[i + 1];
                                        password[i] = password[i + 1];
                                        address[i] = address[i + 1];
                                        dob[i] = dob[i + 1];
                                        gen[i] = gen[i + 1];
                                        email[i] = email[i + 1];
                                        pin[i] = pin[i + 1];
                                        mob[i] = mob[i + 1];
                                        balance[i] = balance[i + 1];
                                        AccountNo[i] = AccountNo[i + 1];
                                        accountType[i] = accountType[i + 1];
                                        transCount[i] = transCount[i + 1];
                                    }
                                    count--;
                                    System.out.println("User deleted successfully.");
                                }
                                break;

                            case 3:
                                adminMenu = false;
                                System.out.println("Exiting Admin Menu...");
                                break;

                            default:
                                System.out.println("Invalid choice.");
                        }
                    }

                } else {
                    System.out.println("Invalid Admin credentials. Access Denied.");
                }

            } else if (finalChoice == 2) {
                System.out.print("Enter your Username: ");
                String u = ob.nextLine();
                System.out.print("Enter your Password: ");
                String p = ob.nextLine();

                int uIndex = -1;
                for (i = 0; i < count; i++) {
                    if (username[i].equals(u) && password[i].equals(p)) {
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
                                "1. View Details \\n2. View Full Account Info \\n3. Delete My Account \\n4. Exit\\nEnter choice: ");
                        int uchoice = ob.nextInt();
                        ob.nextLine();

                        switch (uchoice) {
                            case 1:
                                System.out.println("Name: " + name[uIndex] + " | Username: " + username[uIndex]
                                        + " | Account No: " + AccountNo[uIndex]
                                        + " | Account Type: " + accountType[uIndex]);
                                break;

                            case 2:
                                System.out.println("Name: " + name[uIndex] + " | Username: " + username[uIndex]
                                        + " | Address: " + address[uIndex] + " | Gender: " + gen[uIndex]
                                        + " | DOB: " + dob[uIndex] + " | Email: " + email[uIndex]
                                        + " | Mobile: " + mob[uIndex] + " | Account No: " + AccountNo[uIndex]
                                        + " | Account Type: " + accountType[uIndex] + " | Balance: " + balance[uIndex]);
                                break;

                            case 3:
                                for (i = uIndex; i < count - 1; i++) {
                                    username[i] = username[i + 1];
                                    name[i] = name[i + 1];
                                    password[i] = password[i + 1];
                                    address[i] = address[i + 1];
                                    dob[i] = dob[i + 1];
                                    gen[i] = gen[i + 1];
                                    email[i] = email[i + 1];
                                    pin[i] = pin[i + 1];
                                    mob[i] = mob[i + 1];
                                    balance[i] = balance[i + 1];
                                    AccountNo[i] = AccountNo[i + 1];
                                    accountType[i] = accountType[i + 1];
                                    transCount[i] = transCount[i + 1];
                                }
                                count--;
                                System.out.println("Your account has been deleted successfully.");
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
}