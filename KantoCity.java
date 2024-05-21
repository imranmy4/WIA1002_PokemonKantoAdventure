/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kantocity;

/**
 *
 * @author ahmad
 */
import java.util.ArrayList;
import java.util.Scanner ;
import java.io.*;
import java.util.Random;
public class KantoCity {

   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        //ArrayList declaration
        ArrayList<ArrayList<City>> graph = new ArrayList<>();
        ArrayList<City> PewterCity = new ArrayList<>();//0
        ArrayList<City> ViridianCity = new ArrayList<>();//1
        ArrayList<City> PalletTown = new ArrayList<>();//2
        ArrayList<City> CinnabarIsland = new ArrayList<>();//3
        ArrayList<City> FuschiaCity = new ArrayList<>();//4
        ArrayList<City> CeladonCity = new ArrayList<>();//5
        ArrayList<City> VermillionCity = new ArrayList<>();//6
        ArrayList<City> LavenderTown = new ArrayList<>();//7
        ArrayList<City> SaffronCity = new ArrayList<>();//8
        ArrayList<City> CeruleanCity = new ArrayList<>();//9
        
        
        
        
        //Determining the adjacent vertx of each vertices
        PalletTown.add(new City("Viridian City",1));
        PalletTown.add(new City("Cinnabar Island",3));
        
        PewterCity.add(new City("Viridian City",1));
        PewterCity.add(new City("Cerulean City",9));
        
        ViridianCity.add(new City("Pallet Town",2));
        ViridianCity.add(new City("Pewter City",0));
        
        CinnabarIsland.add(new City("Pallet Town",2));
        CinnabarIsland.add(new City("Fuchsia City",4));
        
        FuschiaCity.add(new City("Celadon City",5));
        FuschiaCity.add(new City("Lavender Town",7));
        
        CeladonCity.add(new City("Fuchsia City",4));
        CeladonCity.add(new City("Vermillion City",6));
        CeladonCity.add(new City("Saffron City",8));
        
        VermillionCity.add(new City("Celadon City",5));
        VermillionCity.add(new City("Lavender Town",7));
        
        LavenderTown.add(new City("Vermillion City",6));
        LavenderTown.add(new City("Cerulean City",9));
        LavenderTown.add(new City("Fuchsia City",4));
        LavenderTown.add(new City("Saffron City",8));
        
        SaffronCity.add(new City("Celadon City",5));
        SaffronCity.add(new City("Cerulean City",9));
        SaffronCity.add(new City("Vermillion City", 6));
        SaffronCity.add(new City("Lavender Town",7));
        
        CeruleanCity.add(new City("Pewter City",0));
        CeruleanCity.add(new City("Saffron City",8));
        CeruleanCity.add(new City("Lavender Town",7));
        
        
           
        //Adding all the arraylist in the graph        
        graph.add(PewterCity);
        graph.add(ViridianCity);
        graph.add(PalletTown);
        graph.add(CinnabarIsland);
        graph.add(FuschiaCity);
        graph.add(CeladonCity);
        graph.add(VermillionCity);
        graph.add(LavenderTown);
        graph.add(SaffronCity);
        graph.add(CeruleanCity);
        
        int Index = 2;
        String Location = "Pallet Town";
        boolean gameloop = true ;
        
        while(gameloop){
            int arr_size = graph.get(Index).size();
            ArrayList<City> currentLocation = graph.get(Index);
            System.out.println("You are now at "+Location);
            
            //First Option (Move to other places)
            System.out.println("[1] Move To : ");
            char options = 'a';
            for(int i=0 ; i<arr_size ; i++){
                System.out.print((char)(options + i)+"."+currentLocation.get(i).name+"  ");
            }
            
            
            //Second option (Fight wild pokemon)
            System.out.println("\n[2] Fight Wild Pokemon ");//
            
            
            //Third Option
            System.out.println("[3] Player Options ");
            System.out.println("a.Show Map  b.Show My Pokemon  c.Show My Badges  d.Save and Exit");
            
            
            
            //Fourth option to challenge gym leader (Pallet Town and Lavender City doesnt have gym)
            if(!(Location.equals("Pallet Town")|| Location.equals("Lavender Town"))){
            String gymLeader ;
            switch (Location) {
                case "Pewter City":
                    gymLeader = "Brock - Rock type";
                    break;
                case "Viridian City":
                    gymLeader = "Giovanni - Ground type";  
                    break;
                case "Pallet Town":
                    gymLeader = "No Gym in Pallet Town";
                    break;
                case "Cinnabar Island":
                    gymLeader = "Blaine - Fire type";
                    break;
                case "Fuchsia City":
                    gymLeader = "Koga - Poison type";  
                    break;
                case "Celadon City":
                    gymLeader = "Erika - Grass type";
                    break;
                case "Vermilion City":
                    gymLeader = "Lt. Surge - Electric type";
                    break;
                case "Lavender Town":
                    gymLeader = "No Gym in Lavender Town";
                    break;
                case "Cerulean City":
                    gymLeader = "Misty - Water type";
                    break;
                case "Saffron City":
                    gymLeader = "Sabrina - Psychic type";
                    break;
                default :
                    gymLeader = "";
            }
            System.out.println("[4] Challenge Gym Leader "+"["+gymLeader+"]");
            }
            if(Location.equals("Lavender Town")){
                System.out.println("[4] PokeMaze");
            }
            else if(Location.equals("Pallet Town")){
                System.out.println("[4]Talk to MOM (Your hometown has no gym)");
            }
            
            if(Location.equals("Saffron City")){
                System.out.println("[5] Rival's Race");
            }else if(Location.equals("Fuchsia City")){
                System.out.println("[5] Safari Zone");
            }
            
            System.out.println("---------------------------------------------------------------");
            String input ;
            System.out.print("Your Choice : ");
            input = sc.nextLine();
            System.out.println("---------------------------------------------------------------\n");
            
            
            while(true){
                if(!(Location.equals("Pallet Town")||Location.equals("Fuchsia City")||Location.equals("Saffron City"))&&!(input.charAt(0)>='1' && input.charAt(0)<='4')){
                    System.out.println("1.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                }else if(Location.equals("Pallet Town")&&!(input.charAt(0)>='1' && input.charAt(0)<='4')){
                    System.out.println("2.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                }
                else if((input.charAt(0)=='1'||input.charAt(0)=='3') && input.length() != 2){
                    System.out.println("3.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                }else if((input.charAt(0)=='2' || input.charAt(0)=='4') && input.length() !=1){
                    System.out.println("4.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                }else if ((input.charAt(0)=='1' && arr_size ==2 )&& !(input.charAt(1)=='a' || input.charAt(1)=='b')){
                    System.out.println("5.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                }else if (input.charAt(0)=='1' && arr_size==3 && !(input.charAt(1)=='a' || input.charAt(1)=='b' || input.charAt(1)=='c')){
                    System.out.println("6.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                }else if (input.charAt(0)=='1' && arr_size==4 && !(input.charAt(1)=='a' || input.charAt(1)=='b' || input.charAt(1)=='c'|| input.charAt(1)=='d')){
                    System.out.println("7.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                }else if(input.charAt(0)=='3'&& !(input.charAt(1)=='a' || input.charAt(1)=='b' || input.charAt(1)=='c'|| input.charAt(1)=='d')){
                    System.out.println("8.Invalid input, please try again");
                    System.out.print("Your Choice : ");
                    input = sc.nextLine();
                }
                else{
                    break;
                }
            }
            
            
            
            //if user choose option 1
            if(input.charAt(0)=='1'){
            char input_char = input.charAt(1);
            Location = currentLocation.get(input_char-'a').name;
            Index = currentLocation.get(input_char-'a').index ;
            System.out.println("\n");
            }
            
            else if(input.charAt(0)=='2'){
                //Fight wild pokemon function
            }
            
            else if(input.charAt(0)=='3'){
                if(input.charAt(1)=='a'){
                    //display kanto map
                    convertMap(Location);
                    System.out.println("\n");
                }else if(input.charAt(1)=='b'){
                    //Show pokemon
                    System.out.println("\n");
                }else if(input.charAt(1)=='c'){
                    //Show badges
                    System.out.println("\n");
                }else if(input.charAt(1)=='d'){
                    //Save and exit
                    System.out.println("\n");
                }
            }
            else if(input.charAt(0)=='4' && Location.equals("Pallet Town")){
                System.out.println("MOM : Oh hi there (player name) ! ");
                try{
                    Scanner sc2 = new Scanner(new FileInputStream("mom's dialogue.txt"));
                    while(sc2.hasNextLine()){
                        System.out.println(sc2.nextLine());
                    }
                    System.out.println("\n");
                }catch(IOException e){
                    System.out.println("Theres a problem with mom's dialogue");
                }
            }
            
            else if(input.charAt(0)=='4' && Location.equals("Lavender Town")){
                pokemaze();
            }
            
            else if(input.charAt(0)=='4' && !Location.equals("Lavender Town")){
                //Challenge gym leader
            }
            
            else if(input.charAt(0)=='5' && Location.equals("Saffron City")){
                //Rival Race
            }
            
            else if(input.charAt(0)=='5' && Location.equals("Fuchsia City")){
                //safari zone
            }
        }
        

        
    }
    
    public static void convertMap (String city){
        try{
        Scanner sc = new Scanner(new FileInputStream("PokemonMap.txt"));
        while(sc.hasNextLine()){
            String temp = sc.nextLine();
            if(!(city.equals("Viridian City") || city.equals("Pallet Town"))){
            String line = temp.replace(city,"**"+ city+"**");
            System.out.println(line);
            }else{
            String line = temp.replace(city+"]    ","**"+ city+"**]");
            System.out.println(line);
            }
        }
        sc.close();
        
        }
        catch(IOException e){
            System.out.println("There is something wrong with the pokemon map");
        }

    }
    
    public static void pokemaze(){
        Random rand = new Random();
        int maze_option = rand.nextInt(5)+1;
        String filename ;
        switch(maze_option){
            case 1:
                filename="maze1.txt";
                break;
            case 2 :
                filename="maze2.txt";
                break;
            case 3 :
                filename="maze3.txt";
                break;
            case 4 :
                filename="maze4.txt";
                break;
            case 5 :
                filename="maze5.txt";
                break;
            default :
                filename = " ";
                break;
        }
        
        try{
        Scanner sc = new Scanner(new FileInputStream(filename));
        int num_line = 0 ;
        while(sc.hasNextLine()){
            num_line++;
            sc.nextLine();
        }
        
        String[][] arr = new String[num_line][];
        
        Scanner sc2 = new Scanner(new FileInputStream(filename));
        
        for(int i=0 ; i<num_line ; i++){
            arr[i]= sc2.nextLine().split(" ");
        }
        
        gameStart(arr);
        
        
        
        }catch(IOException e){
            System.out.println("There is a problem with the map");
        }
        
    }
    
    public static void gameStart(String arr[][]){
        MyStack<String> stack = new MyStack<>();
        
        Scanner sc = new Scanner(System.in);
        String you = "Y";
        ArrayList<coordinate> hashlist = new ArrayList<>();
        int ghastcount = 0 ;
        int x_ghast1 =0 ;
        int y_ghast1 =0 ;
        int x_ghast2 =0;
        int y_ghast2 =0 ;
        int x =0;
        int y =0;;
        int x_end=0, y_end=0 ;
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[i].length ; j++){
                if(arr[i][j].equals("S")){
                    x=i;
                    y=j;
                }
                
                if(arr[i][j].equals("E")){
                    x_end = i;
                    y_end = j ;
                }
                
                if(arr[i][j].equals("G")){
                    if(ghastcount==0){
                        x_ghast1 = i ;
                        y_ghast1 = j ;
                        ghastcount ++;
                    }else{
                        x_ghast2 = i ;
                        y_ghast2 = j ;
                    }
                }
                
                if(arr[i][j].equals("#")){
                    hashlist.add(new coordinate(i,j));
                }
            }
            
            
        }
        
        while (true){
            String temp = arr[x][y];
            System.out.println("Enter direction (R-right , L-left , U-up , D-down) : ");
            for(int i=0 ; i<arr.length ; i++){
                for(int j=0 ; j<arr[i].length ; j++){
                System.out.print(arr[i][j]+" ");
                }System.out.println();
            }
            
            String input = sc.nextLine();
            System.out.println();
            if(arr[x][y].equals("S")){
            arr[x][y] = temp;
            }else{
                arr[x][y]=".";
            }
            int old_x = x;
            int old_y = y ;
            
            if(input.equals("R") || input.equals("r")){
                y++;
                stack.push("right");
            }else if(input.equals("L") || input.equals("l")){
                y--;
                stack.push("left");
            }else if(input.equals("U") || input.equals("u")){
                x--;
                stack.push("up");
            }else if(input.equals("D") || input.equals("d")){
                x++;
                stack.push("down");
            }else{
                System.out.println("Invalid input, please tray again.");
                arr[x][y]="Y";
                continue ;
            }
            
            
            //System.out.println("X = "+x+", Y = "+y);
            coordinate target = new coordinate(x,y);
           
            if(target.contains(hashlist)){
                System.out.println("Why are you approaching a wall, try again.\n");
                x = old_x;
                y = old_y;
                arr[x][y]="Y";
                stack.pop();
                continue ;
            }
            
            arr[x][y]="Y";
            System.out.println("Your moves : "+stack);
            
            if(x==x_end&& y==y_end){
                System.out.println("Congratulations ,you have reached the end of the maze !");
                break;
            }
            
            if(x==x_ghast1 && y==y_ghast1){
                System.out.println("You have encountered a ghast, you have been kicked out of the maze. \n");
                break;
            }
            
            if(x==x_ghast2 && y==y_ghast2){
                System.out.println("You have encountered a ghast, you have been kicked out of the maze.");
                break;
            }
            
            if(stack.size()==40){
                System.out.println("You took too long in the maze, you are kicked out.");
                break;
            }
            
            
        }
        
        
    }
    
}
