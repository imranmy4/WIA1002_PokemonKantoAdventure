
package pokemon.kanto.adventure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class PokemonKantoAdventure {

    
    public static void main(String[] args) {
        fileExists();
        Player player = null;
        boolean play = true;
        System.out.println("Welcome to Pokemon - Kanto Adventure\n");
        while(play){
            switch(gamePrompt()){
                case 1 :
                    player = newGame();
                    break;
                case 2: 
                    player = loadPlayerData();
                    System.out.println(player.getName());
                    break;
                case 3 : 
                    saveAndExit(player);
                    play = false;
                    break;
                    
            }
        }
        /*Scanner input = new Scanner(System.in);
        String name;
        System.out.println("Player name: ");
        name = input.nextLine();
        Player player = new Player(name);       //Create new Player(demo)
        WildPokemon wild = new WildPokemon();       //Demo wild enemy
        System.out.println("\nPOKEMON BATTLEEEEE!!!!!\n");      //Player choose Pokemon for battle
        fight(player,wild.getEnemy());*/
    }
    
    public static void fight(Player player, Pokemon enemy){     //myPokemon from Player, enemy from demo
        Pokemon myPokemon = player.choosePokemon();
        Scanner input = new Scanner(System.in);
        System.out.println(myPokemon.getName()+" [level "+myPokemon.getLevel()+"] vs "+enemy.getName()+" [level "+enemy.getLevel()+"]");
        while(true){
            System.out.println();
            //myPokemon.attack will return enemyHP after taking damage by myPokemon
            if(myPokemon.attack(enemy) <= 0){               //check if Player won
                System.out.println();
                System.out.println(enemy.getName()+" [HP : 0"+"/"+enemy.getHP()+"]");        //tell enemy pokemon hp turns zero
                System.out.println(myPokemon.getName()+" Won!");                        //tell Player won
                myPokemon.levelUp(enemy.getLevel());                     //myPokemon.levelUp check if XP from enemy enough to level up and if so, player pokemon levels up
                System.out.println(myPokemon.getName()+" [XP : "+myPokemon.getXP()+"/"+myPokemon.getXPThreshold()+"]");     //tell player pokemon XP after defeating enemy or after levels up(if it did)
                break;
            } else
                System.out.println(enemy.getName()+" [HP : "+enemy.getCurrentHP()+"/"+enemy.getHP()+"]");     //tell enemy remaining HP
            
            System.out.println();
            //myPokemon.defense will return player pokemon HP after taking damage by enemy
            if(myPokemon.defense(enemy) <= 0){                  //check if Player lose
                System.out.println();
                System.out.println(myPokemon.getName()+" [HP : 0"+"/"+myPokemon.getHP()+"]");        //tell player pokemon HP turns zero
                myPokemon = player.removeCurrentPokemon();
                player.removeBattlePokemon();
                if(player.getBattlePokemon().size()<=0){
                    System.out.println("You lose");
                    break;
                } else {
                    System.out.println("Pick another pokemon!");
                    myPokemon = player.choosePokemon();
                }
            } else
                System.out.println(myPokemon.getName()+" [HP : "+myPokemon.getCurrentHP()+"/"+myPokemon.getHP()+"]");        //tell player pokemon remaining HP
            
        }
    }
    
    public static void saveAndExit(Player player){
        String name = player.getName();
        String playerSave = name+".bin";
        int slot = player.getSaveSlot();
        String line;
        String array[];
        ArrayList<String[]> data = new ArrayList<>();
        File file1 = new File("Game Slot.txt");
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file1));
            
            while((line = br.readLine()) != null){
                array = line.split(",");
                data.add(array);
            }
            br.close();
            
        } catch(IOException e){
            e.printStackTrace();
        }
        
        try{
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
            
            for(int i=0; i<data.size(); i++){
                if(slot == Integer.parseInt(data.get(i)[0])){
                    bw.write(String.valueOf(slot)+","+name);
                    bw.newLine();
                } else {
                    if(data.get(i).length == 2){
                        bw.write(data.get(i)[0]+","+data.get(i)[1]);
                        bw.newLine();
                    } else if(data.get(i).length == 1){
                        bw.write(data.get(i)[0]);
                        bw.newLine();
                    } else{
                        System.out.println("Error in saving data.(csv file)");
                        break;
                    }
                }
            }
            bw.close();
            
        } catch(IOException e){
            e.printStackTrace();
        }
        
        
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(playerSave));
            
            out.writeObject(player);
            out.close();
            System.out.println("Saved!");
            
        } catch(IOException e){
            e.printStackTrace();
        }
        
        
            
            
        
    }
    
    
    public static Player loadPlayerData(){
        Scanner input = new Scanner(System.in);
        boolean success = false;
        String line;
        String name = "";
        String[] array = null;
        ArrayList<String[]> slots = new ArrayList<>();
        int choice;
        Player player = null;
        System.out.print("Which game file would you like to load: ");
        while(success == false){
            try{
                BufferedReader br = new BufferedReader(new FileReader("Game Slot.txt"));
                System.out.print("\nGame Saves:\t");
                do{
                    while((line = br.readLine()) != null){
                        array = line.split(",");
                        if(array.length == 1){
                            System.out.print(array[0]+". (empty)\t");
                        } else if(array.length == 2){
                            System.out.print(array[0]+". ("+array[1]+")\t");
                        } else {
                            System.out.print(array[0]+". (corrupted save file)");
                        }
                        slots.add(array);
                    }
                    
                System.out.print("\n\nLoad: ");
                choice = input.nextInt();
                input.nextLine();
                if(choice < 1 || choice > 3)
                        System.out.println("\nInvalid game save.");
                } while(choice < 1 || choice > 3);
                
                for(int i=0; i<slots.size(); i++){
                    if(choice == Integer.parseInt(slots.get(i)[0])){
                        if(slots.get(i).length == 2){
                            name = slots.get(i)[1];
                            success = true;
                            break;
                        } else if(slots.get(i).length == 1){
                            System.out.println("Choose available game file only.");
                        } else{
                            System.out.println("Game file is corrupted. Choose another available game file.");
                        }
                    }
                }
                } catch(IOException e){
                    e.printStackTrace();
                }
        }
        
        try{
            File filename = new File(name+".bin");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            if(name.equals("") || filename.exists() == false){
                System.out.println("Fail to load game file(no name or file does not exist).");
            } else{
                player = (Player) ois.readObject();
                System.out.println("Welcome back "+player.getName()+"!");
            }
        } catch(IOException e){
            e.printStackTrace();
        } catch(ClassNotFoundException f){
            f.printStackTrace();
        }
        return player;
    }
    
    public static Player newGame(){
        Scanner input = new Scanner(System.in);
        int choice = 0;
        String name;
        Player player = null;
        
        while(player == null){
            System.out.print("\nNew Game:\t");
            String line;
            String[] temp;
            String[] slot;
            String answer;
            boolean overwrite = false;
            boolean unique = false;
            ArrayList<String[]> slots = new ArrayList<>();
            try{
                BufferedReader br = new BufferedReader(new FileReader("Game Slot.txt"));
                while((line = br.readLine()) != null){
                    slot = line.split(",");
                    if(slot.length == 1){
                        System.out.print(slot[0]+". (empty)\t");
                    } else if(slot.length == 2){
                        System.out.print(slot[0]+". ("+slot[1]+")\t");
                    } else{
                        System.out.println(slot[0]+". Error(corrupted save file)");
                    }
                    slots.add(slot);
                }
                br.close();
                
                do {
                    System.out.print("\n\nGame Slot: ");
                    choice = input.nextInt();
                    input.nextLine();
                    if(choice <1 || choice >3)
                        System.out.println("Invalid Save Slot.");
                } while(choice <1 || choice >3);
                
                if(slots.get(choice-1).length == 2){
                    while(overwrite == false){
                        System.out.println("Overwrite save file?");
                        System.out.print("You can't revert back after overwriting this game file. [yes/no] : ");
                        answer = input.nextLine();
                        if(answer.equalsIgnoreCase("yes")){
                            while(unique == false){
                            System.out.print("Enter your name: ");
                            name = input.nextLine();
                            for(int j=0; j<3; j++){
                                temp = slots.get(j);
                                if(temp.length == 2){
                                    if(name.equalsIgnoreCase(temp[1]) && choice == Integer.parseInt(temp[0])){
                                        unique = true;
                                        break;
                                    } else if(name.equalsIgnoreCase(temp[1]) && choice != Integer.parseInt(temp[0])){
                                        System.out.println("Please enter unique name.");
                                        unique = false;
                                        break;
                                    } else
                                        unique = true;
                                }
                            }
                            if(unique == true){
                                player = new Player(name);
                                player.setSaveSlot(choice);
                                try{
                                    File oldFile = new File(slots.get(choice-1)[1]+".bin");
                                    File sameFile = new File(name+".bin");
                                    if(sameFile.exists())
                                        sameFile.delete();
                                    else if(oldFile.exists())
                                        oldFile.delete();
                                } catch(SecurityException s){
                                    s.printStackTrace();
                                }
                                
                                overwrite = true;
                            }
                            }
                            
                        } else if(answer.equalsIgnoreCase("no")){
                            overwrite = false;
                            break;
                        }
                    }
                    
                }else if(slots.get(choice-1).length == 1){
                    while(unique == false){
                        System.out.println("Enter your name: ");
                        name = input.nextLine();
                        for(int k=0; k<3; k++){
                            temp = slots.get(k);
                            if(temp.length == 2){
                                if(name.equalsIgnoreCase(temp[1])){
                                    unique = false;
                                    break;
                                }
                            } else if(temp.length == 1){
                                unique = true;
                            }
                        }
                        if(unique == false){
                            System.out.println("Please enter unique name.");
                        } else{
                            player = new Player(name);
                            player.setSaveSlot(choice);
                            System.out.println(player.getName()+" save slot " +player.getSaveSlot());
                            break;
                        }
                    }
                }
                
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        return player;
    }
    
    public static void fileExists(){
        File file = new File("Game Slot.txt");
        if(!file.exists()){
        createFile();
        }
    }
    
    public static void createFile(){
        try{
            FileWriter fw = new FileWriter("Game Slot.txt");
            fw.write("1\n2\n3\n");
            fw.close();
            System.out.println("File Created");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static int gamePrompt(){
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("1. Start a new adventure.");
        System.out.println("2. Resume previous adventure.");
        System.out.println("3. Save and quit");
        choice = input.nextInt();
        input.nextLine();
        return choice;
        
    }
    
    public static boolean gameOver(){
        return false;
    }
}
