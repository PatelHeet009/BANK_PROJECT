class User extends Person {
    long mobile;
    String email;
    String username;
    String password;
    int pin;

    User(String name, String address, char gender, String dob,
            long mobile, String email, String username, String password, int pin) {
        super(name, address, gender, dob);
        this.mobile = mobile;
        this.email = email;
        this.username = username;
        this.password = password;
        this.pin = pin;
    }
}
