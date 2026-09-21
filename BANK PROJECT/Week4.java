class Person {

    String name;
    String email;

    Person(String name, String email) {

        this.name = name;
        this.email = email;
    }
}


class User extends Person {

    String username;
    String password;

    User(
            String name,
            String email,
            String username,
            String password) {

        super(name, email);

        this.username = username;
        this.password = password;
    }

    void showUser() {

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Username: " + username);
    }
}


public class Week4 {

    public static void main(String[] args) {

        User user = new User(
                "Heet",
                "heet@gmail.com",
                "heet123",
                "1234"
        );

        user.showUser();
    }
}