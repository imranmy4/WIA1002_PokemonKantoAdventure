
package pokemon.kanto.adventure;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public abstract class Pokemon {         //Pokemon parent class
    private String name;
    private String type;
    private int level;
    private int HP;
    private int XP;
    private String[] strength;          //Which type the pokemon is strong against
    private String[] weakness;          // which type the pokemon is weak against
    private ArrayList<Skill> movesAndDmg;       //the pokemon total moves/skills
    private Skill[] currentMovesAndDmg;         //the pokemon currently used moves/skills 
    
    Pokemon(String name, String type, int level, int HP, int XP){       //constructor for child classes
        this.name = name;
        this.type = type;
        this.level = level;
        this.HP = HP;
        this.XP = XP;
        this.strength = initializeStrength();               //strength to movesAndDmg is initialized by child classes using methods
        this.weakness = initializeWeakness();
        this.movesAndDmg = initializeMoveAndDmg();
        this.currentMovesAndDmg = initializeCurrentMovesAndDmg();       //currentMovesAndDmg initialized for new pokemon created
    }
    
    public abstract String[] initializeStrength();          //child class initialize pokemon strength
    
    public abstract String[] initializeWeakness();          // child class initialize pokemon weakness
    
    public abstract ArrayList<Skill> initializeMoveAndDmg();        //child class initialize first strating moves/skills and its damages
    
    public Skill[] initializeCurrentMovesAndDmg(){              //initialize currently used moves/skills for newly created pokemon
        Skill initialMove1, initialMove2;
        initialMove1 = movesAndDmg.get(0);
        initialMove2 = movesAndDmg.get(1);
        return new Skill[]{initialMove1,initialMove2};      //return moves/skill to currentMovesAndDMg(only for first time pokemon)
    }
    
    public void addMoves(Skill skill){          //add new moves to existing pokemon
        movesAndDmg.add(skill);
    }
    
    public int attack(Pokemon enemy, int enemyHP){           //method for player pokemon to attack enemy
        Scanner input = new Scanner(System.in);
        int check1 = 0, check2 = 0;                     //check for player pokemon strength and weakness
        int move;
        int damage;
        double dmgMultiplier = 1;                       //damage multiplier according to player pokemon strength and weakness
        String line = enemy.type;
        String splitBy = "/";
        String[] enemyType = line.split(splitBy);
        for(String str1 : enemyType){                       //check if player pokemon is strong against enemy types
            for(String str2 : strength){
                if(str2.equals(str1)){              //if yes, bonus 20% attack damage and check1 is raised
                    dmgMultiplier = 1.2;
                    check1 = 1;
                    
                }
            }
        }
        for(String str1 : enemyType){                       //check if player pokemon is weak against enemy types
            for(String str2 : weakness){
                if(str2.equals(str1)){               //if yes, 20% reduction in attack damage and check2 is raised
                    dmgMultiplier = 0.8;
                    check2 = 1;
                }
            }
        }
        if(check1 == 1 && check2 == 1)                  //if both check is raised(player pokemon is both strong and weak against enemy types), damage normally
            dmgMultiplier = 1;
        
        System.out.println(name+" Moves:");                //tell player pokemon moves/skills available
        for(int i=0; i<2; i++){
            System.out.println((i+1)+". "+currentMovesAndDmg[i].getMoveName()+" ["+ (int) currentMovesAndDmg[i].getDamage()+" damage}");
        }
        System.out.println("Which moves will "+name+" use?");        //player choose which moves/skills to use
        move = input.nextInt();
        
        switch(move){
            case 1 : System.out.println(name+" uses "+currentMovesAndDmg[0].getMoveName()+"!");       //player use first moves/skills 
            damage = (int) Math.ceil(currentMovesAndDmg[0].getDamage()*dmgMultiplier);
            enemyHP -= damage;
            break;
            
            case 2 : System.out.println(name+" uses "+currentMovesAndDmg[1].getMoveName()+"!");          //player use second moves/skills
            damage = (int) Math.ceil(currentMovesAndDmg[1].getDamage()*dmgMultiplier);
            enemyHP -= damage;
            break;
        }
        
        return enemyHP;
    }
    
    public int defense(Pokemon enemy, int myHP){         //method for player taking damage from enemy
        int check1 = 0, check2 = 0;                                 //basically 50% same as attack method just reverse role
        double dmgMultiplier = 1;
        int damage;
        int enemyMoveChoice;
        String line = type;
        String splitBy = "/";
        String[] myType = line.split(splitBy);
        for(String str1 : myType){
            for(String str2 : enemy.strength){
                if(str2.equals(str1)){
                    dmgMultiplier = 1.2;
                    check1 = 1;
                }
            }
        }
        for(String str1 : myType){
            for(String str2 : enemy.weakness){
                if(str2.equals(str1)){
                    dmgMultiplier = 0.8;
                    check2 = 1;
                }
            }
        }
        if(check1 == 1 && check2 == 1)
            dmgMultiplier = 1;
        Random rand = new Random();                     //enemy randomly choose moves/skills
        enemyMoveChoice = rand.nextInt(2)+1;
        switch(enemyMoveChoice){
            case 1 : System.out.println(enemy.name+" uses "+enemy.currentMovesAndDmg[0].getMoveName()+"!");
            damage = (int) Math.ceil(enemy.currentMovesAndDmg[0].getDamage()*dmgMultiplier);
            myHP -= damage;
            break;
            
            case 2 : System.out.println(enemy.name+" uses "+enemy.currentMovesAndDmg[1].getMoveName()+"!");
            damage = (int) Math.ceil(enemy.currentMovesAndDmg[1].getDamage()*dmgMultiplier);
            myHP -= damage;
            break;
        }
        return myHP;
    }
    
    public void levelUp(int XPwon){              //method for player pokemon to check for level up 
        int XPThreshold;                                            //minimum XP requirement to level up
        int currentLevel = getLevel();
        XP += (XPwon*5);                                  //player pokemon XP increase by 5 times enemy pokemon level
        while(XP>0){
            if(currentLevel>=1 && currentLevel<=9)
                XPThreshold = 100;                                  //XP requirement for level 1 to 9
            else if(currentLevel>=10 && currentLevel<=29)
                XPThreshold = 200;                                  //XP requirement for level 10 to 29
            else if(currentLevel>=30)
                XPThreshold = 300;                                  //XP requirement dor level 30 and above
            else{
                System.out.println("Error in leveling up!");        //just in case problem
                break;
            }
            if(XP>=XPThreshold){                          //check if player XP reach minimum requirement
                level++;                                  //increase player pokemon level
                HP += 5;                                  //increase player pokemon health
                System.out.println(name+" leveled up!");
                System.out.println(name+"[level "+currentLevel+" --> level "+level+"]");      //tell level increase
                System.out.println(name+" HP increase to "+HP);       // (temporary) show HP increase
                for(int i=0; i<getMovesAndDmg().size(); i++){
                    movesAndDmg.get(i).addDamage();                   //increase player pokemon damage for all moves/skills
                    System.out.println(movesAndDmg.get(i).getMoveName()+" damage increase to "+movesAndDmg.get(i).getDamage()+" !");        //temporary
                }
                skillCheck(level);           //check if enough level to add new moves/skills
                currentLevel++;                                                     //increase currentLevel check
                XP -= XPThreshold;                                        //minus player pokemon XP from minimum requirement to level up
            }
            else
                break;
        }
        if(XP<0)              //reset player pokemon XP to zero
            XP = 0;
    }
    
    public void skillCheck(int level){           //to be implemented
        
    }
    
    public void equipMoves(){                       //equip moves/skills for player pokemon
        Scanner input = new Scanner(System.in);
        int moveNum1, moveNum2;
        System.out.println("Which moves would you like to equip on "+name);
        for(int i=0; i<getMovesAndDmg().size();i++){
            System.out.print("\t"+(i+1)+". "+movesAndDmg.get(i).getMoveName()+" ["+(int) movesAndDmg.get(i).getDamage()+" damage]");
        }
        System.out.println();
        System.out.print("1st move: ");
        moveNum1 = input.nextInt();
        System.out.print("2nd move: ");
        moveNum2 = input.nextInt();
        
        currentMovesAndDmg[0] = movesAndDmg.get(moveNum1-1);
        currentMovesAndDmg[1] = movesAndDmg.get(moveNum2-1);
    }
    
    public String getName(){
        return name;
    }
    
    public String getType(){
        return type;
    }
    
    public int getLevel(){
        return level;
    }
    
    public int getHP(){
        return HP;
    }
    
    public int getXP(){
        return XP;
    }
    
    public String[] getStrength(){
        return strength;
    }
    
    public String[] getWeakness(){
        return weakness;
    }
    
    public Skill[] getCurrentMovesAndDmg(){
        return currentMovesAndDmg;
    }
    
    public ArrayList<Skill> getMovesAndDmg(){
        return movesAndDmg;
    }
    
}
