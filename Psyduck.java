/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemonkantoadventure;

/**
 *
 * @author ahmad
 */
import java.util.Stack;
import java.util.Scanner;
import java.io.* ;

public class Psyduck extends Pokemon{

    public Psyduck() {
        super("Psyduck","Water",5,100,0);
    }
    
    public Psyduck(String location){
        super("Psyduck","Water",100,location);
    }
    
    public Psyduck(int level){
        super("Psyduck","Water",100,level);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Fire","Ground","Rock"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Electric","Grass"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Aqua Tail",107.0,43));
        moveset.push(new Skill("Zen Headbutt",72.0,29));
        moveset.push(new Skill("Water Pulse",46.0,18));
        moveset.push(new Skill("Fury Swipes",25.0,9));
        moveset.push(new Skill("Water Gun",17.0,5));
        moveset.push(new Skill("Scratch",14.0,5));
        
        return moveset;
    }
    
    public void display(){
        try{
            Scanner sc = new Scanner(new FileInputStream("psyduck.txt"));
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();
        }catch(IOException e){
            System.out.println("Psyduck picture is not found");
        }
    }
    
}
