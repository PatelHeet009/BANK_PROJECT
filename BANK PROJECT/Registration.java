import java.util.Scanner;

class Registration {

    static Account registerUser(Scanner ob, Account[] accounts, int count) {

        if (count >= accounts.length) {
            System.out.println("Maximum user limit reached.");
            return null;
        }

        System.out.println("===================================");
        System.out.println("         Registration Form");
        System.out.println("===================================");

        System.out.print("Enter Name: ");
        String name = ob.nextLine();

        System.out.print("Enter Address: ");
        String address = ob.nextLine();

        System.out.print("Enter Gender: ");
        char gender = ob.next().charAt(0);

        // DOB
        String dob;
        do {
            System.out.print("Enter Date of Birth (DD/MM/YYYY): ");
            dob = ob.next();
            if (!dob.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}")) {
                System.out.println("Invalid DOB. Please use DD/MM/YYYY format.");
            }
        } while (!dob.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}"));

        // Email (basic)
        String email = readBasicEmail(ob, "Enter Email: ");

        // Mobile
        String mobileInput;
        do {
            System.out.print("Enter Mobile No: ");
            mobileInput = ob.next();
            if (!mobileInput.matches("\\d{10}")) {
                System.out.println("Invalid mobile number. Please enter exactly 10 digits.");
            }
        } while (!mobileInput.matches("\\d{10}"));
        long mobile = Long.parseLong(mobileInput);

        // Username
        String username;
        while (true) {
            System.out.print("Enter new username: ");
            username = ob.next();
            int digits = countDigits(username);
            boolean firstCapital = Character.isUpperCase(username.charAt(0));
            boolean hasAt = username.contains("@");
            if (!firstCapital || digits < 3 || !hasAt) {
                System.out.println("Username must start with a capital letter, contain minimum 3 digits and @.");
            } else {
                break;
            }
        }

        // Password
        String password;
        while (true) {
            System.out.print("Enter new password: ");
            password = ob.next();
            boolean upper = false, lower = false, special = false;
            for (int j = 0; j < password.length(); j++) {
                char c = password.charAt(j);
                if (Character.isUpperCase(c)) upper = true;
                if (Character.isLowerCase(c)) lower = true;
                if (!Character.isLetterOrDigit(c)) special = true;
            }
            if (password.length() < 6 || !upper || !lower || !special || countDigits(password) < 3) {
                System.out.println("Password must be minimum 6 characters, contain minimum 3 digits, "
                        + "1 uppercase, 1 lowercase and 1 special character.");
            } else {
                break;
            }
        }

        // PIN
        int pin;
        while (true) {
            System.out.print("Set PIN of 4 digits(0-9): ");
            pin = ob.nextInt();
            if (pin < 0 || pin > 9999) {
                System.out.println("PIN must contain exactly 4 digits.");
            } else {
                break;
            }
        }

        // Account type
        int accChoice;
        do {
            System.out.print("Choose Account Type [1=Saving , 2=Current]: ");
            accChoice = ob.nextInt();
            if (accChoice != 1 && accChoice != 2) {
                System.out.println("Invalid choice, please enter 1 or 2.");
            }
        } while (accChoice != 1 && accChoice != 2);

        // Email rule per account type
        if (accChoice == 1) {
            while (!email.matches("[A-Za-z0-9._%+-]+@(gmail|yahoo)\\.com")) {
                System.out.println("Your email does not meet the Saving Account requirement.");
                System.out.println("For Saving Account, use a valid Gmail.com or Yahoo.com email ending in .com.");
                email = readBasicEmail(ob, "Enter a new Email: ");
            }
        } else {
            while (!isBusinessEmail(email)) {
                System.out.println("Your email does not meet the Current Account requirement.");
                System.out.println("For Current Account, use a business email (not Gmail/Yahoo), ending in .com or .in.");
                email = readBasicEmail(ob, "Enter a new Email: ");
            }
        }

        // Opening balance
        double opBalance;
        do {
            System.out.print("Enter opening balance [minimum 20000]: ");
            opBalance = ob.nextDouble();
            if (opBalance < 20000) {
                System.out.println("Opening balance should be minimum 20000, please enter again.");
            }
        } while (opBalance < 20000);

        User user = new User(name, address, gender, dob, mobile, email, username, password, pin);

        Account account;
        if (accChoice == 1 && opBalance > 1000000) {
            System.out.println("Opening balance exceeds 10,00,000. Your account has been switched to Current account.");
            account = new CurrentAccount(user, opBalance);
        } else if (accChoice == 1) {
            account = new SavingAccount(user, opBalance);
        } else {
            account = new CurrentAccount(user, opBalance);
        }

        System.out.println("Registered Successfully.");
        return account;
    }

    // ---------- helpers ----------

    private static String readBasicEmail(Scanner ob, String prompt) {
        String email;
        while (true) {
            System.out.print(prompt);
            email = ob.next();
            boolean hasAt = email.contains("@");
            boolean endsOk = email.endsWith(".com") || email.endsWith(".in");
            if (!hasAt || countDigits(email) < 3 || !endsOk) {
                System.out.println("Invalid Email. Email must contain @, minimum 3 digits and end with .com or .in.");
            } else {
                return email;
            }
        }
    }

    private static int countDigits(String s) {
        int d = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                d++;
            }
        }
        return d;
    }

    private static boolean isBusinessEmail(String email) {
        boolean isGmailOrYahoo = email.matches("[A-Za-z0-9._%+-]+@(gmail|yahoo)\\.com");
        boolean endsInBusinessDomain = email.matches(".+\\.(com|in|org)$");
        return !isGmailOrYahoo && endsInBusinessDomain;
    }
}
