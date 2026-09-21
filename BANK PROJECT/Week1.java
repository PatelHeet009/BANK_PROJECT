import java.util.Scanner;

public class Week1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== BANK MANAGEMENT SYSTEM =====");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();

        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();

        System.out.println("\n----- ACCOUNT DETAILS -----");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}