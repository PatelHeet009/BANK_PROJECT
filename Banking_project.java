import java.util.Scanner;

class User {
    String username;
    String password;
    String email;
    double balance;

    User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = 0.0;
    }
}

public class Banking_project {
    static int maximum_user = 5;
    static User[] users = new User[maximum_user];
    static int count_of_user = 0;
    static int index = -1;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean Exit = false;
        while(!Exit){
            Cli_skeleton();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Register();
                    break;
                case 2: 
                    Login();
                    break;
                case 3:
                    Exit = true;
                    System.out.println("Thanks for Banking !");
                    break;
                default:
                    System.out.println("\nYour choice is invalid, please repeat the process ....\n");
                    break;
            }
        }
    }

    public static void Cli_skeleton(){
        System.out.println("\n Bank Management System  \n");
        System.out.println("Select following operation for your specific need ");
        System.out.println(" 1.  Register User \n 2.  Login User \n 3.  Exit");
    }

    public static void Register(){
        Scanner sc = new Scanner(System.in);

        if(count_of_user >= maximum_user){
            System.out.println("Maximum limit reached for registration.");
            return;
        }

        System.out.println("Enter Your Name : ");
        String User_Name = sc.next().trim();
        for(int i=0;i<count_of_user;i++){
            if(users[i].username.equals(User_Name)){
                System.out.println("\nName is already taken, Sorry! \nEnter different name ..\n");
                return;
            }
        }
        String email = Email_validation();
        String password = password_validation();

        users[count_of_user] = new User(User_Name, password, email);
        count_of_user++;
        System.out.println("\nRegistration successful... ");
        System.out.println("Welcome " + User_Name + " to our Bank Management System :) \n");
    }

    public static void Login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name : ");
        String User_check_name = sc.next().trim();
        System.out.println("Enter your password : ");
        String User_check_pass = sc.next().trim();
        for(int i=0;i<count_of_user ;i++){
            if(users[i].username.equals(User_check_name) && users[i].password.equals(User_check_pass)){
                System.out.println("----- login successful "+ User_check_name +" :)  ----- ");
                index = i;
                Login_fun();
                return;
            }
        }
        System.out.println("----- Sorry, login was unsuccessful :(  ----- ");
    }

    public static void Login_fun() {
        Scanner sc = new Scanner(System.in);
        boolean login_exit = false;
        while (!login_exit) {
            login_interface();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Deposit();
                    break;
                case 2:
                    Withdraw();
                    break;
                case 3:
                    Show_Balance();
                    break;
                case 4:
                    View_Account();
                    break;
                case 5:
                    login_exit = true;
                    break;
                default:
                    System.out.println("Your Choice is invalid ....");
                    break;
            }
        }
    }

    public static void login_interface() {
        System.out.println("\n Enter choice  ...\n 1. Deposit Money \n 2. Withdraw Money \n 3. Show Balance \n 4. View Account Details \n 5. Exit From Login");
    }

    public static void Deposit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Deposit money");
        double add_balance = sc.nextDouble();
        if(add_balance <= 0){
            System.out.println("Your amount cannot be deposited ... :( ");
        }
        else {
            users[index].balance += add_balance;
            System.out.println("Successfully added total amount of Rs." + add_balance );
        }
    }

    public static void Withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total amount of money you want to withdraw");
        double sub_balance = sc.nextDouble();
        if(users[index].balance >= sub_balance && sub_balance > 0){
            users[index].balance -= sub_balance;
            System.out.println("Successfully withdrew amount of Rs. " + sub_balance);
        }
        else{
            System.out.println("Current Account has Not sufficient balance ... :(  ");
        }
    }

    public static void Show_Balance(){
        System.out.println("Your current account balance is Rs." + users[index].balance);
    }

    public static void View_Account(){
        System.out.println("\n Your Account details    ");
        System.out.println("Name :- " + users[index].username);
        System.out.println("Password :- " + users[index].password);
        System.out.println("Email Address :- " + users[index].email);
        System.out.println("Balance :- " + users[index].balance);
        System.out.println("\n");
    }

    public static String Email_validation(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Your Email : ");
            String User_email = sc.next().trim();
            if(User_email.contains("@")){
                return User_email;
            }
            System.out.println("\n Invalid email address ... :( \n");
        }
    }

    public static String password_validation(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Create Password : ");
            String User_password = sc.next().trim();
            if(User_password.length() < 8 ){
                System.out.println("Password must be 8 character long.");
                continue;
            }
            int upper = 0, lower = 0, digit = 0, special = 0;
            for(int i=0;i<User_password.length();i++){
                char ch = User_password.charAt(i);
                if(Character.isUpperCase(ch)){
                    upper++;
                }
                else if(Character.isLowerCase(ch)){
                    lower++;
                }
                else if(Character.isDigit(ch)){
                    digit++;
                }
                else{
                    special++;
                }
            }
            if(upper == 0 || lower == 0 || digit == 0 || special == 0){
                System.out.println("Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
            }
            else{
                return User_password;
            }
        }
    }
}