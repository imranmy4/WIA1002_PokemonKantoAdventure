
package pokemonkantoadventure;

import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Account {

    String name;
    String password;
    static final String DataDirectory = System.getProperty("user.dir");
    static final String UserDataFile = DataDirectory + "/users.txt";
    Scanner r = new Scanner(System.in);
    boolean start = false;
    Map<String, String> users;

    Account() {
        this.users = new HashMap<>();
        loadUserData();
        int signingIn;
        
        do{
            System.out.println("1. Existing User \n2. New User");
            System.out.print("Enter your choice: ");
            signingIn = acceptInt();

            switch (signingIn) {

                case 1:
                    existingUser();
                    break;

                case 2:
                    newUser();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while(signingIn<1 || signingIn>2);
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

    public void newUser() {
        do{
            do{
                System.out.print("Enter username: ");
                name = r.nextLine();
            } while(name.isBlank());
            do{
                System.out.print("Enter password: ");
                password = r.nextLine();
            } while(password.isBlank());

            if (existingUsername(name)) {
                System.out.println("The username is already taken.");
            }

            if (!isStrongPassword(password)) {
                System.out.println("The password is not strong.");
                System.out.println("Password must contain at least 1 upper case, 1 lower case, 1 digit and use > 5 characters.");
            }
        }while (existingUsername(name) || !isStrongPassword(password));


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

    public void existingUser() {

        int trial = 1;

        while (trial < 4) {
            String answer = "null";
            do{
                System.out.print("Enter username: ");
                name = r.nextLine();
            } while(name.isBlank());
            do{
                System.out.print("Enter password: ");
                password = r.nextLine();
            } while(password.isBlank());

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
                
                do{
                System.out.print("[yes/no](If you choose no, game will quit): ");
                answer = r.nextLine();
                
                if (answer.equalsIgnoreCase("yes")) {
                    newUser();
                    break;
                } else if(answer.equalsIgnoreCase("no")){
                    start = false;
                    break;
                } else
                    System.out.println("Invalid choice!\n");
                } while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
            }
            if(answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("yes"))
                break;
        }
        if (trial > 3)
            System.out.println("Too many failed attempts.");  
    }
    
    public static int acceptInt() {
        int i;
        Scanner input = new Scanner(System.in);
        try {
            i = input.nextInt();
            input.nextLine();
            return i;
        } catch (InputMismatchException ex) {
            return -1;
        }
    }
}
