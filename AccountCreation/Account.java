package AccountCreation;

import java.util.*;

public class Account {

    public static void main(String[] args) {

        Account newUser = new Account();
    }

    String name;
    String password;
    Scanner r = new Scanner(System.in);
    Map<String, String> users;

    Account() {

        this.users = new HashMap<>();

        System.out.println("1. Existing User \n2. New User");
        System.out.print("Enter your choice: ");
        int signingIn = r.nextInt();
        r.nextLine();

        switch (signingIn) {

            case 1:
                
                System.out.print("Enter username: ");
                this.name = r.nextLine();
                System.out.print("Enter password: ");
                this.password = r.nextLine();
                existingUser(name, password);
                break;

            case 2:
                
                System.out.print("Enter username: ");
                this.name = r.nextLine();
                System.out.print("Enter password: ");
                this.password = r.nextLine();
                newUser(name, password);
                break;

            default:
                System.out.println("Invalid choice.");
        }

    }

    public boolean existingUsername(String name) {
        return users.containsKey(name);
    }

    public boolean isStrongPassword(String password) {

        if (password.length() < 5) {
            return false;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {

            if (Character.isLowerCase(c)) {
                hasLower = true;
            }

            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }

            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasLower && hasUpper && hasDigit;
    }

    public void newUser(String name, String password) {

        while (existingUsername(name) || !isStrongPassword(password)) {

            if (existingUsername(name)) {
                System.out.println("The username is already taken.");
                System.out.print("Enter username: ");
                name = r.nextLine();
            }

            if (!isStrongPassword(password)) {
                System.out.println("The password is not strong.");
                System.out.println("Password must contain at least 1 upper case, 1 lower case, 1 digit and use > 5 characters.");
                System.out.print("Enter password: ");
                password = r.nextLine();
            }

        }

        users.put(name, password);
        System.out.println("Welcome " + name + "!");

    }

    public void existingUser(String name, String password) {

        int trial = 1;

        while (trial < 4) {

            if (users.containsKey(name)) {

                if (users.get(name).equals(password)) {
                    System.out.println("Welcome " + name + "!");
                    return;
                } else {
                    System.out.println("Wrong password.");
                    trial++;
                }
            } else {
                System.out.println("The username does not exist.");
                return;
            }
        }

        System.out.println("Too many failed attempts.");
    }

}
