import java.util.Scanner;

class LoginService {

    static int login(Scanner ob, Account[] accounts, int count) {
        System.out.println("===================================");
        System.out.println("               Login");
        System.out.println("===================================");

        System.out.print("Enter username: ");
        String loginUser = ob.next();
        System.out.print("Enter password: ");
        String loginPwd = ob.next();

        for (int i = 0; i < count; i++) {
            User u = accounts[i].getOwner();
            if (u.username.equals(loginUser) && u.password.equals(loginPwd)) {
                return i;
            }
        }
        return -1;
    }
}
