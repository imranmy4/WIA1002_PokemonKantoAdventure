package com.example.demo;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import java.io.*;
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            Thread.sleep(7000); //  seconds delay (adjust as needed)
        } catch (InterruptedException e) {
        // Handle interrupted exception
            e.printStackTrace();
        }
        // Register a new user
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Do you want to save your progress in a local storage or database?");
        System.out.println("1.Local Storage");
        System.out.println("2.Database");
        String options ;
        String createNewAcc = "";
        options = sc.nextLine();
        while(options.equals("1")==false && options.equals("2")==false ){
            System.out.print("Invalid input, please try again :");
            options = sc.nextLine();
        }
        if(options.equals("1")){
            PokemonKantoAdventure.mainGame(true,null);
        }else{
            System.out.print("Do you have an account ? :");
            options = sc.nextLine();
            while(options.equalsIgnoreCase("yes")==false && options.equalsIgnoreCase("no")==false ){
                System.out.println("Invalid input, please try again :");
                options = sc.nextLine();
            }
            if(options.equalsIgnoreCase("yes")){
                while(true){
                    System.out.println("-------------------------------------");
                    System.out.print("Username : ");
                    String username = sc.nextLine();
                    System.out.print("Password : ");
                    String password = sc.nextLine();
                    if(userService.isValid(username,password)){
                        Player retrieved_player = userService.getUser(username).getPlayer();
                        try{
                        Scanner skaner = new Scanner(new FileInputStream("pokemon_logo.txt"));
                        while(skaner.hasNextLine()){
                            System.out.println(skaner.nextLine());
                        }
                        skaner.close();
                        }catch(IOException e){
                            System.out.println("There is something wrong with the pokemon logo");
                        }
                        Player saved_player = PokemonKantoAdventure.mainGame(false, retrieved_player);
                        userService.updatePlayer(username, saved_player);
                        createNewAcc="no";
                        
                        break;
                    }else{
                        System.out.println("Invalid input, do you want to create a new account?");
                        createNewAcc = sc.nextLine();
                        while(createNewAcc.equalsIgnoreCase("yes")==false && createNewAcc.equalsIgnoreCase("no")==false ){
                            System.out.println("Invalid input, please try again :");
                            createNewAcc = sc.nextLine();
                        }
                        if(createNewAcc.equalsIgnoreCase("yes")){
                            options="no";
                            break;
                        }else{
                            continue;
                        }
                    }
                }
                
            }else{
                createNewAcc="yes";
            }
            if(createNewAcc.equalsIgnoreCase("yes") && options.equalsIgnoreCase("no")){
                //create a new account
                
                while(true){
                System.out.println("-------------------------------------");
                System.out.println("Account Creation");
                System.out.println("Enter your Username and Password");
                System.out.print("Username : ");
                String username = sc.nextLine();
                System.out.print("Password : ");
                String password = sc.nextLine();
                if(userService.usernameAvailable(username)){
                    userService.register(username, password);
                    System.out.println("Your account has been created successfully");
                    try{
                    Scanner skaner = new Scanner(new FileInputStream("pokemon_logo.txt"));
                    while(skaner.hasNextLine()){
                        System.out.println(skaner.nextLine());
                    }
                    skaner.close();
                    }catch(IOException e){
                        System.out.println("There is something wrong with the pokemon logo");
                    }
                    Player new_player =new Player(username,1);
                    Player saved_player = PokemonKantoAdventure.mainGame(false,new_player);
                    userService.updatePlayer(username, saved_player);
                    break;
                   }
                else{
                     System.out.println("The username is aleady taken, try another one ");
                    }
                }
                

                
                
                        
            }
        }
        
       System.out.println("Thank you for playing the game");

       
    }
    
    

}
