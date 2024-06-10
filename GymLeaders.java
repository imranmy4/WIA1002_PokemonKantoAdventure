package pokemonkantoadventure;

import java.util.ArrayList;
import java.util.Stack;

// gymleader abstract parent class
public abstract class GymLeaders {                                                
    String name;
    String badge;
    String type;
    ArrayList<Pokemon> allPokemon = new ArrayList<>();
    Stack<Pokemon> remainingPokemon = new Stack<>();
    Pokemon currentPokemon = null;
    
    GymLeaders(String name, String type, String badge) {
        this.name = name;
        this.badge = badge;
        this.type = type;
        allPokemon = gymLeaderPokemon();
        for(int i = 0 ; i < allPokemon.size() ; i++)
            remainingPokemon.push(allPokemon.get(i));
    }
    
    abstract public ArrayList<Pokemon> gymLeaderPokemon();                        // set pokemon for each gymleader
    
    public String getName() {
        return name;
    }
    
    public String getBadge() {
        return badge;
    }
    
    public ArrayList<Pokemon> getAllPokemon() {
        return allPokemon;
    }
    
    public Stack<Pokemon> getRemainingPokemon() {
        return remainingPokemon;
    }
   
    public void resetPokemon() {                                                    // reset gymleader pokemon after battle
        allPokemon = new ArrayList<>();
        allPokemon = gymLeaderPokemon();
        remainingPokemon = new Stack<>();
        for(int i = 0 ; i < allPokemon.size() ; i++)
            remainingPokemon.push(allPokemon.get(i));
    }
    
    public Pokemon nextBattlePokemon() {                                            // get next gymleader pokemon in stack
        currentPokemon = remainingPokemon.pop();
        return currentPokemon;
    }
    
    public void removeCurrentPokemon() {
        currentPokemon = null;
    }
    
    public boolean remainingPokemonEmpty() {
        return remainingPokemon.isEmpty();
    }
    
    public Pokemon getCurrentPokemon() {
        return currentPokemon;
    }
    
    public void setCurrentPokemon() {                                                // set currently used gymleader pokemon
        currentPokemon = nextBattlePokemon();
    }
}

// Pewter City gymleader child class
class PewterCityGymLeader extends GymLeaders {                                        

    public PewterCityGymLeader() {
        super("Brock","Rock","The Boulder Badge");
    }

    @Override
    public ArrayList<Pokemon> gymLeaderPokemon() {
        ArrayList<Pokemon> temp = new ArrayList<>();
        temp.add(new Onix(8));
        temp.add(new Geodude(6));
        
        return temp;
    }
}

// Cerulean City gymleader child class
class CeruleanCityGymLeader extends GymLeaders {
    
    public CeruleanCityGymLeader() {
        super("Misty","Water","The Cascade Badge");
    }
    
    @Override
    public ArrayList<Pokemon> gymLeaderPokemon() {
        ArrayList<Pokemon> temp = new ArrayList<>();
        temp.add(new Blastoise(12));
        temp.add(new Psyduck(10));
        
        return temp;
    }
}

// Vermilion City gymleader child class
class VermilionCityGymLeader extends GymLeaders {

    public VermilionCityGymLeader() {
        super("Lt. Surge","Electric","The Thunder Badge");
    }

    @Override
    public ArrayList<Pokemon> gymLeaderPokemon() {
        ArrayList<Pokemon> temp = new ArrayList<>();
        temp.add(new Raichu(17));
        temp.add(new Pikachu(15));
        temp.add(new Voltorb(14));
        
        return temp;
    }
}

// Celadon City gymleader child class
class CeladonCityGymLeader extends GymLeaders{
    
    public CeladonCityGymLeader(){
        super("Erika","Grass","The Rainbow Badge");
    }

    @Override
    public ArrayList<Pokemon> gymLeaderPokemon() {
        ArrayList<Pokemon> temp = new ArrayList<>();
        temp.add(new Vileplume(22));
        temp.add(new Tangela(20));
        temp.add(new Victreebel(19));
        
        return temp;
    }
}

// Fuchsia City gymleader child class
class FuchsiaCityGymLeader extends GymLeaders {
    
    public FuchsiaCityGymLeader() {
        super("Koga","Poison","The Soul Badge");
    }

    @Override
    public ArrayList<Pokemon> gymLeaderPokemon() {
        ArrayList<Pokemon> temp = new ArrayList<>();
        temp.add(new Weezing(27));
        temp.add(new Muk(25));
        temp.add(new Koffing(24));
        
        return temp;
    }
}

// Saffron City gymleader child class
class SaffronCityGymLeader extends GymLeaders {
    
    public SaffronCityGymLeader() {
        super("Sabrina","Psychic","The Marsh Badge");
    }

    @Override
    public ArrayList<Pokemon> gymLeaderPokemon() {
        ArrayList<Pokemon> temp = new ArrayList<>();
        temp.add(new Alakazam(32));
        temp.add(new MrMime(30));
        temp.add(new Espeon(29));
        
        return temp;
    }
}

// Cinnabar Island gymleader child class
class CinnabarIslandGymLeader extends GymLeaders {
    
    public CinnabarIslandGymLeader() {
        super("Blaine","Fire","The Volcano Badge");
    }

    @Override
    public ArrayList<Pokemon> gymLeaderPokemon() {
        ArrayList<Pokemon> temp = new ArrayList<>();
        temp.add(new Arcanine(37));
        temp.add(new Rapidash(35));
        temp.add(new Ninetales(34));
        
        return temp;
    }
}

// Viridian City gymleader child class
class ViridianCityGymLeader extends GymLeaders {

    public ViridianCityGymLeader() {
        super("Giovanni","Ground","The Earth Badge");
    }

    @Override
    public ArrayList<Pokemon> gymLeaderPokemon() {
        ArrayList<Pokemon> temp = new ArrayList<>();
        temp.add(new Rhydon(42));
        temp.add(new Nidoking(40));
        temp.add(new Nidoqueen(39));
        
        return temp;
    }
}
