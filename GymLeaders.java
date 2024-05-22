
package pokemon.kanto.adventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public abstract class GymLeaders {
    String name;
    String badge;
    String type;
    ArrayList<Pokemon> allPokemon = new ArrayList<>();
    Stack<Pokemon> remainingPokemon = new Stack<>();
    Pokemon currentPokemon = null;
    
    GymLeaders(String name, String type, String badge){
        this.name = name;
        this.badge = badge;
        this.type = type;
        allPokemon = gymLeaderPokemon();
        for(int i=0; i<allPokemon.size(); i++)
            remainingPokemon.push(allPokemon.get(i));
    }
    
    abstract public ArrayList<Pokemon> gymLeaderPokemon();
    
    public String getName(){
        return name;
    }
    
    public String getBadge(){
        return badge;
    }
    
    public ArrayList<Pokemon> getAllPokemon(){
        return allPokemon;
    }
    
    public Stack<Pokemon> getRemainingPokemon(){
        return remainingPokemon;
    }
    
    public void resetPokemon(){
        remainingPokemon.clear();
        allPokemon = gymLeaderPokemon();
        for(int i=0; i<allPokemon.size(); i++)
            remainingPokemon.push(allPokemon.get(i));
    }
    
    public Pokemon nextBattlePokemon(){
        currentPokemon = remainingPokemon.pop();
        return currentPokemon;
    }
    
    public void removeCurrentPokemon(){
        currentPokemon = null;
    }
    
    public boolean remainingPokemonEmpty(){
        return remainingPokemon.isEmpty();
    }
    
    public Pokemon getCurrentPokemon(){
        return currentPokemon;
    }
    
    public void setCurrentPokemon(){
        currentPokemon = nextBattlePokemon();
    }
}

class PewterCityGymLeader extends GymLeaders{

        public PewterCityGymLeader() {
            super("Brock","Rock","The Boulder Badge");
        }

        @Override
        public ArrayList<Pokemon> gymLeaderPokemon() {
            ArrayList<Pokemon> temp = new ArrayList<>();
            temp.add(new Onix(15));
            temp.add(new Geodude(12));
            
            return temp;
        }
    
}

class CeruleanCityGymLeader extends GymLeaders{
    
    public CeruleanCityGymLeader(){
        super("Misty","Water","The Cascade Badge");
    }
    @Override
    public ArrayList<Pokemon> gymLeaderPokemon() {
        ArrayList<Pokemon> temp = new ArrayList<>();
        temp.add(new Blastoise(24));
        temp.add(new Psyduck(21));
        
        return temp;
    }
    
}

class VermilionCityGymLeader extends GymLeaders{

    public VermilionCityGymLeader() {
        super("Lt. Surge","Electric","The Thunder Badge");
    }

    @Override
    public ArrayList<Pokemon> gymLeaderPokemon() {
        ArrayList<Pokemon> temp = new ArrayList<>();
        temp.add(new Raichu(34));
        temp.add(new Pikachu(32));
        temp.add(new Voltorb(29));
        
        return temp;
    }
    
}
