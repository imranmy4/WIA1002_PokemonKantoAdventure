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
import java.io.*;

public class Pikachu extends Pokemon{

    public Pikachu() {
        super("Pikachu","Electric",5,105,0);
    }
    
    public Pikachu(String location){
        super("Pikachu","Electric",105, location);
    }
    
    public Pikachu(int level) {
        super("Pikachu","Electric",level,105);
    }

    @Override
    public String[] setStrength() {
        return new String[]{"Water","Flying"};
    }

    @Override
    public String[] setWeakness() {
        return new String[]{"Ground"};
    }

    @Override
    public Stack<Skill> allMoves() {
        Stack<Skill> moveset = new Stack<>();
        moveset.push(new Skill("Thunder",105.0,46));
        moveset.push(new Skill("Thunderbolt",65.0,27));
        moveset.push(new Skill("Spark",42.0,16));
        moveset.push(new Skill("Electro Ball",23.0,8));
        moveset.push(new Skill("Nuzzle",15.0,5));
        moveset.push(new Skill("Quick Attack",14.0,5));
        
        
        return moveset;
    }
    
    public void display(){
        try{
            Scanner sc = new Scanner(new FileInputStream("pikachu.txt"));
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();
        }catch(IOException e){
            System.out.println("Pikachu picture is not found");
        }
    }
    
}
