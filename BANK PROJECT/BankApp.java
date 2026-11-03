import java.util.Scanner;

class BankApp {

    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        Account[] accounts = new Account[500];
        int count = 0;
        String repeat;

        System.out.println("===================================");
        System.out.println("         Welcome to the App");
        System.out.println("===================================");

        do {
            System.out.print("Enter the choice of Operation [1=Register , 2=Login , 3=Exit.]: ");
            int log = ob.nextInt();
            ob.nextLine();

            switch (log) {
                case 1:
                    Account newAccount = Registration.registerUser(ob, accounts, count);
                    if (newAccount != null) {
                        accounts[count] = newAccount;
                        count++;
                    }
                    break;

                case 2:
                    int loginIndex = LoginService.login(ob, accounts, count);
                    if (loginIndex == -1) {
                        System.out.println("Invalid username or password.");
                    } else {
                        Account acc = accounts[loginIndex];
                        System.out.println("===================================");
                        System.out.println("       Logged In Successfully");
                        System.out.println("===================================");
                        System.out.println("Your Account No is : " + acc.getAccountNumber());
                        System.out.println("Your Account Type is : " + acc.getAccountType());

                        accounts[loginIndex] = TransactionService.runAccountMenu(ob, acc);
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

        } while (repeat.equalsIgnoreCase("yes"));

        System.out.print("\nDo you want to view registered users?(yes/no): ");
        String viewChoice = ob.next();
        ob.nextLine();

        if (viewChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter choice [1=Admin , 2=User]: ");
            int finalChoice = ob.nextInt();
            ob.nextLine();

            if (finalChoice == 1) {
                count = AdminService.runAdminMenu(ob, accounts, count);

            } else if (finalChoice == 2) {
                System.out.print("Enter your Username: ");
                String u = ob.nextLine();
                System.out.print("Enter your Password: ");
                String p = ob.nextLine();

                int uIndex = -1;
                for (int i = 0; i < count; i++) {
                    User owner = accounts[i].getOwner();
                    if (owner.username.equals(u) && owner.password.equals(p)) {
                        uIndex = i;
                        break;
                    }
                }

                if (uIndex == -1) {
                    System.out.println("Invalid username or password.");
                } else {
                    Account self = accounts[uIndex];
                    User owner = self.getOwner();
                    boolean userMenu = true;
                    while (userMenu) {
                        System.out.println("===================================");
                        System.out.println("            User Menu");
                        System.out.println("===================================");
                        System.out.print(
                                "1. View Details \n2. View Full Account Info \n3. Delete My Account \n4. Exit\nEnter choice: ");
                        int uchoice = ob.nextInt();
                        ob.nextLine();

                        switch (uchoice) {
                            case 1:
                                System.out.println("Name: " + owner.name + " | Username: " + owner.username
                                        + " | Account No: " + self.getAccountNumber()
                                        + " | Account Type: " + self.getAccountType());
                                break;

                            case 2:
                                System.out.println("Name: " + owner.name + " | Username: " + owner.username
                                        + " | Address: " + owner.address + " | Gender: " + owner.gender
                                        + " | DOB: " + owner.dob + " | Email: " + owner.email
                                        + " | Mobile: " + owner.mobile + " | Account No: " + self.getAccountNumber()
                                        + " | Account Type: " + self.getAccountType()
                                        + " | Balance: " + self.getBalance());
                                break;

                            case 3:
                                for (int i = uIndex; i < count - 1; i++) {
                                    accounts[i] = accounts[i + 1];
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