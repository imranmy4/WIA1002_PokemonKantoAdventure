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

public class Raichu extends Pokemon{

    public Raichu() {
        super("Raichu","Electric",5,110,0);
    }
    
    public Raichu(String location){
        super("Raichu","Electric",110,location);
    }
    
    public Raichu(int level){
        super("Raichu","Electric",level,110);
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
        moveset.push(new Skill("Thunderbolt",84.0,34));
        moveset.push(new Skill("Thunder Punch",66.0,26));
        moveset.push(new Skill("Thunder Shock",41.0,15));
        moveset.push(new Skill("Thunder",25.0,8));
        moveset.push(new Skill("Electro Ball",16.0,5));
        moveset.push(new Skill("Nuzzle",17.0,5));
        
        return moveset;
    }
    
    public void display(){
        try{
            Scanner sc = new Scanner(new FileInputStream("raichu.txt"));
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();
        }catch(IOException e){
            System.out.println("Raichu picture is not found");
        }
    }
    
    
    
}
