import java.util.Scanner;

class AdminService {

    private static final String ADMIN_USER = "admin2598";
    private static final String ADMIN_PASS = "admin696548";

    // Admin has only 3 functions: View All Users, Delete a User, Exit
    static int runAdminMenu(Scanner ob, Account[] accounts, int count) {
        System.out.print("Enter Admin Username: ");
        String adminUser = ob.nextLine();
        System.out.print("Enter Admin Password: ");
        String adminPass = ob.nextLine();

        if (!adminUser.equals(ADMIN_USER) || !adminPass.equals(ADMIN_PASS)) {
            System.out.println("Invalid Admin credentials. Access Denied.");
            return count;
        }

        boolean adminMenu = true;
        while (adminMenu) {
            System.out.println("===================================");
            System.out.println("            Admin Menu");
            System.out.println("===================================");
            System.out.print("1. View All Users\n2. Delete a User\n3. Exit\nEnter choice: ");
            int achoice = ob.nextInt();
            ob.nextLine();

            switch (achoice) {
                case 1:
                    System.out.println("===================================");
                    System.out.println("       All Registered Users");
                    System.out.println("===================================");
                    for (int i = 0; i < count; i++) {
                        User u = accounts[i].getOwner();
                        System.out.println("Name: " + u.name + " | Username: " + u.username
                                + " | Account No: " + accounts[i].getAccountNumber()
                                + " | Account Type: " + accounts[i].getAccountType()
                                + " | Balance: " + accounts[i].getBalance()
                                + " | Mobile: " + u.mobile + " | Email: " + u.email);
                    }
                    break;

                case 2:
                    System.out.print("Enter username to delete: ");
                    String delUser = ob.nextLine();
                    int delIndex = -1;
                    for (int i = 0; i < count; i++) {
                        if (accounts[i].getOwner().username.equals(delUser)) {
                            delIndex = i;
                            break;
                        }
                    }
                    if (delIndex == -1) {
                        System.out.println("User not found.");
                    } else {
                        for (int i = delIndex; i < count - 1; i++) {
                            accounts[i] = accounts[i + 1];
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
        return count;
    }
}
