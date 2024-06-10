package pokemonkantoadventure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class WildPokemon {                                          // wild pokemon class
    private ArrayList<Pokemon> wildPokemon;
    private HashMap<String,ArrayList<Pokemon>> allWildPokemon;
    private String location;
    private Pokemon enemy;
    
    WildPokemon(String location) {
        this.location = location;
        allWildPokemon = setWildPokemon();
        wildPokemon = allWildPokemon.get(location);
        enemy = setEnemy();
    }
    
    public HashMap<String,ArrayList<Pokemon>> setWildPokemon() {        // set wild pokemon in each city
        ArrayList<Pokemon> PalletTown = new ArrayList<>();
        PalletTown.add(new Bulbasaur("Pallet Town"));
        PalletTown.add(new Geodude("Pallet Town"));
        PalletTown.add(new Jigglypuff("Pallet Town"));
        
        ArrayList<Pokemon> PewterCity = new ArrayList<>();
        PewterCity.add(new Onix("Pewter City"));
        PewterCity.add(new Geodude("Pewter City"));
        PewterCity.add(new Snorlax("Pewter City"));
        
        ArrayList<Pokemon> ViridianCity = new ArrayList<>();
        ViridianCity.add(new Nidoqueen("Viridian City"));
        ViridianCity.add(new Nidoking("Viridian City"));
        ViridianCity.add(new Rhydon("Viridian City"));
        
        ArrayList<Pokemon> CinnabarIsland = new ArrayList<>();
        CinnabarIsland.add(new Arcanine("Cinnabar Island"));
        CinnabarIsland.add(new Rapidash("Cinnabar Island"));
        CinnabarIsland.add(new Ninetales("Cinnabar Island"));
        
        ArrayList<Pokemon> FuchsiaCity = new ArrayList<>();
        FuchsiaCity.add(new Weezing("Fuchsia City"));
        FuchsiaCity.add(new Muk("Fuchsia City"));
        FuchsiaCity.add(new Koffing("Fuchsia City"));
        
        ArrayList<Pokemon> CeladonCity = new ArrayList<>();
        CeladonCity.add(new Vileplume("Celadon City"));
        CeladonCity.add(new Tangela("Celadon City"));
        CeladonCity.add(new Victreebel("Celadon City"));
        
        ArrayList<Pokemon> VermilionCity = new ArrayList<>();
        VermilionCity.add(new Pikachu("Vermilion City"));
        VermilionCity.add(new Raichu("Vermilion City"));
        VermilionCity.add(new Voltorb("Vermilion City"));
        
        ArrayList<Pokemon> SaffronCity = new ArrayList<>();
        SaffronCity.add(new Alakazam("Saffron City"));
        SaffronCity.add(new MrMime("Saffron City"));
        SaffronCity.add(new Espeon("Saffron City"));
        
        ArrayList<Pokemon> CeruleanCity = new ArrayList<>();
        CeruleanCity.add(new Blastoise("Cerulean City"));
        CeruleanCity.add(new Psyduck("Cerulean City"));
        CeruleanCity.add(new Squirtle("Cerulean City"));
        
        ArrayList<Pokemon> LavenderTown = new ArrayList<>();
        LavenderTown.add(new Machop("Lavender Town"));
        LavenderTown.add(new Eevee("Lavender Town"));
        LavenderTown.add(new Snorlax("Lavender Town"));
        
        HashMap<String,ArrayList<Pokemon>> temp = new HashMap<>();
        temp.put("Pallet Town", PalletTown);
        temp.put("Pewter City", PewterCity);
        temp.put("Viridian City", ViridianCity);
        temp.put("Cinnabar Island", CinnabarIsland);
        temp.put("Fuchsia City", FuchsiaCity);
        temp.put("Celadon City", CeladonCity);
        temp.put("Vermilion City", VermilionCity);
        temp.put("Saffron City", SaffronCity);
        temp.put("Cerulean City", CeruleanCity);
        temp.put("Lavender Town", LavenderTown);
        
        return temp;
    }
    
    public Pokemon setEnemy() {                        // randomly pick wild pokemon for battle
        Random rand = new Random();
        int chosen = rand.nextInt(3);
        enemy = wildPokemon.get(chosen);
        
        return enemy;
    }
    
    public Pokemon getEnemy() {
        return enemy;
    }
    
    public String stringPokemonInArea() {                // print common wild pokemon in city
        return "[" + wildPokemon.get(0).getName() + "," + wildPokemon.get(1).getName() + " and " + wildPokemon.get(2).getName() + " is common.]";
    }
}
