
package pokemon.kanto.adventure;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;


public abstract class Pokemon {         //Pokemon parent class
    final private String name;
    final private String type;
    private int level;
    private int HP;
    private int XP;
    final private String[] strength;          //Which type the pokemon is strong against
    final private String[] weakness;          // which type the pokemon is weak against
    private Stack<Skill> moveset;           //moves the pokemon have not unlocked yet
    private ArrayList<Skill> movesAndDmg;       //the pokemon total moves/skills
    private Skill[] currentMovesAndDmg;         //the pokemon currently used moves/skills 
    
    Pokemon(String name, String type, int level, int HP, int XP){       //constructor for new/saved child classes
        this.name = name;
        this.type = type;
        this.level = level;
        this.HP = setHP(level,HP);
        this.XP = XP;
        this.strength = setStrength();               //set in child class(permanent)
        this.weakness = setWeakness();               //set in child class(permanent)
        this.moveset = allMoves();                      //automatic for each pokemon
        this.movesAndDmg = unlockedMoves();                 //automatic for each pokemon
        this.currentMovesAndDmg = initializeCurrentMovesAndDmg();       //currentMovesAndDmg initialized for new pokemon created
    }
    
    Pokemon(String name, String type, int HP, String location){       //constructor for WildPokemon child classes
        this.name = name;
        this.type = type;
        this.level = setWildLevel(location);
        this.HP = setHP(level, HP);
        this.strength = setStrength();               //same as above
        this.weakness = setWeakness();
        this.moveset = allMoves();
        this.movesAndDmg = unlockedMoves();
        this.currentMovesAndDmg = wildPokemonMoves();       //currentMovesAndDmg initialized for wild pokemon randomly
    }
    
    public abstract String[] setStrength();          //child class set pokemon strength
    
    public abstract String[] setWeakness();          // child class set pokemon weakness   
    
    public abstract Stack<Skill> allMoves();                //child class set pokemon moveset
    
    final public int setWildLevel(String location){     //set wild pokemon level according to location
        Random rand = new Random();
        int newWildLevel = 0;
            switch(location){
                case "Pewter City" : newWildLevel = (rand.nextInt(3)+5);
                break;
                case "Cerulean City" : newWildLevel = (rand.nextInt(3)+9);
                break;
                default : System.out.println("No pokemon");
                break;
            }
        return newWildLevel;
    }
    
    final public int setHP(int level, int HP){          //set pokemon HP according to level
        while(level>5){
            HP += 5;
            level--;
        }
        return HP;
    }
    
    final public Skill moveDamageLeveling(Skill skill){         //increase damage according to level (+2 damage for each level)
        int levelCheck = level;
        int moveLevel = skill.getLevel();
        while(levelCheck>moveLevel){
            skill.addDamage();
            levelCheck--;
        }
        return skill;
    }
    
    public ArrayList<Skill> unlockedMoves(){                //automatically unlock moves according to pokemon level
        int levelCheck = level;
        int movesLevelCheck;
        ArrayList<Skill> unlockedMoveset = new ArrayList<Skill>();
        while(levelCheck >= (movesLevelCheck = moveset.peek().getLevel())){
            unlockedMoveset.add(moveset.pop());
            if(moveset.empty()){
                break;
            }
        }
        for(int i=0; i<unlockedMoveset.size(); i++){
            unlockedMoveset.set(i, moveDamageLeveling(unlockedMoveset.get(i)));
        }
        return unlockedMoveset;
    }
    
    public Skill unlockNewMoves(){
        Skill newSkill;
        newSkill = moveset.pop();
        return newSkill;   
    }
    
    final public Skill[] initializeCurrentMovesAndDmg(){              //initialize currently used moves/skills for newly created pokemon
        Skill initialMove1, initialMove2;
        initialMove1 = movesAndDmg.get(0);
        initialMove2 = movesAndDmg.get(1);
        return new Skill[]{initialMove1,initialMove2};      //return moves/skill to currentMovesAndDmg for newly created pokemon
    }
    
    public Skill[] wildPokemonMoves(){          //wild pokemon randomly choose its moves
        Random rand = new Random();
        int move1, move2;
        Skill currentMove1, currentMove2;
        int moveChoices = movesAndDmg.size();
        move1 = rand.nextInt(moveChoices);
        do
            move2 = rand.nextInt(moveChoices);
        while(move2 == move1);
        
        currentMove1 = movesAndDmg.get(move1);
        currentMove2 = movesAndDmg.get(move2);
        return new Skill[]{currentMove1,currentMove2};
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
            System.out.println((i+1)+". "+currentMovesAndDmg[i].getMoveName()+" ["+ (int) currentMovesAndDmg[i].getDamage()+" damage}");        //player pokemon moves list
        }
        System.out.println("Which moves will "+name+" use?");        //player choose which moves/skills to use
        move = input.nextInt();
        
        switch(move){
            case 1 : System.out.println(name+" uses "+currentMovesAndDmg[0].getMoveName()+"!");       //player use first moves 
            damage = (int) Math.ceil(currentMovesAndDmg[0].getDamage()*dmgMultiplier);
            enemyHP -= damage;
            break;
            
            case 2 : System.out.println(name+" uses "+currentMovesAndDmg[1].getMoveName()+"!");          //player use second moves
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
    
    public void levelUp(int enemyLevel){              //method for player pokemon to check for level up 
        int XPThreshold;                                            //minimum XP requirement to level up
        int currentLevel = level;
        XP += (enemyLevel*5);                                  //player pokemon XP increase by 5 times enemy pokemon level
        while(XP>0){
            if(level>=1 && level<=9)
                XPThreshold = 100;                                  //XP requirement for level 1 to 9
            else if(level>=10 && level<=29)
                XPThreshold = 200;                                  //XP requirement for level 10 to 29
            else if(level>=30)
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
                    System.out.println(movesAndDmg.get(i).getMoveName()+" damage increase to "+movesAndDmg.get(i).getDamage()+" !");        //(temporary) show damage increase
                }
                 
                if(level >= moveset.peek().getLevel())
                    movesAndDmg.add(unlockNewMoves());                                      //unlock new moves
                currentLevel++;
                XP -= XPThreshold;                                        //minus player pokemon XP from minimum requirement to level up
            }
            else
                break;
        }
        if(XP<0)              //reset player pokemon XP to zero
            XP = 0;
    }
    
    public void equipMoves(){                       //equip moves for player pokemon
        Scanner input = new Scanner(System.in);
        int moveNum1, moveNum2;
        System.out.println("Which moves would you like to equip on "+name);
        for(int i=0; i<getMovesAndDmg().size();i++){
            System.out.print("\t"+(i+1)+". "+movesAndDmg.get(i).getMoveName()+" ["+(int) movesAndDmg.get(i).getDamage()+" damage]");
        }
        System.out.println();
        System.out.print("1st move: ");
        moveNum1 = input.nextInt();
        
        do{
            System.out.print("2nd move: ");
            moveNum2 = input.nextInt();
            if(moveNum2 == moveNum1){
                System.out.println("\nYou have already selected this move!");
                System.out.println("Please pick another move!\n");
            }
        } while(moveNum2 == moveNum1);
        
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
