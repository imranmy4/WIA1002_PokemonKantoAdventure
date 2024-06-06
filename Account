
package pokemonkantoadventure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Account {

    public static void main(String[] args) {

        Account newUser = new Account();
    }

    String name;
    String password;
    static final String DataDirectory = "C:/Users/saada/OneDrive/Desktop/Java/Data Structure/PokemonKantoAdventure";
    static final String UserDataFile = DataDirectory + "/users.txt";
    Scanner r = new Scanner(System.in);
    boolean start = false;
    Map<String, String> users;

    Account() {
        this.users = new HashMap<>();
        loadUserData();

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

    private void loadUserData() {
        File file = new File(UserDataFile);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        users.put(parts[0], parts[1]);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading user data file: " + e.getMessage());
            }
        }
    }

    private void saveUserData() {
        File file = new File(UserDataFile);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing user data file: " + e.getMessage());
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

    public String getUserDirectory(String username) {
        return DataDirectory + File.separator + username;
    }

    public boolean getStart() {
        return start;
    }

    public String getName() {
        return name;
    }

    public void newUser(String name, String password) {

        while (existingUsername(name) || !isStrongPassword(password)) {

            if (existingUsername(name)) {
                System.out.println("The username is already taken.");
                System.out.print("Enter username: ");
                name = r.nextLine();
                break;
            }

            if (!isStrongPassword(password)) {
                System.out.println("The password is not strong.");
                System.out.println("Password must contain at least 1 upper case, 1 lower case, 1 digit and use > 5 characters.");
                System.out.print("Enter password: ");
                password = r.nextLine();
                break;
            }
        }


        users.put(name, password);
        saveUserData();
        start = true;
        File userDir = new File(getUserDirectory(name));
        if (!userDir.exists()) {
            if (userDir.mkdir()) {
                System.out.println("User directory created.");
                System.out.println("\nWelcome " + name + "!");
            } else {
                System.out.println("Failed to create user directory.");
            }
        }         
    }

    public void existingUser(String name, String password) {

        int trial = 1;

        while (trial < 4) {

            if (users.containsKey(name)) {

                if (users.get(name).equals(password)) {
                    System.out.println("Welcome " + name + "!");
                    getUserDirectory(name);
                    start = true;
                    break;
                } else {
                    System.out.println("Wrong password.");
                    trial++;
                }
            } else {
                System.out.println("This account does not exist.");
                System.out.println("Would you like to create an account?");
                String answer = r.nextLine();

                if (answer.equalsIgnoreCase("yes")) {
                    System.out.print("Enter username: ");
                    this.name = r.nextLine();
                    System.out.print("Enter password: ");
                    this.password = r.nextLine();
                    newUser(name, password);
                    start = true;
                    break;
                } else {
                    start = false;
                }
            }
        }

        start = false;
        if (trial > 4)
            System.out.println("Too many failed attempts.");
    }
}
