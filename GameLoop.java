import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


/** A GameLoop with a main method that executes the game sequence in order based on the user's input. 
 * Uses a scanner "userInput" in order to take in commands.
*/
public class GameLoop {

    // A HashMap of Location objects, rooms, with an associated String indicating which position on the "grid" of north, east, south, and west the room is.
    private static HashMap<String, Location> houseMap; // The HashMap for the rooms in the player's house.
    private static HashMap<String, Location> fordMap; // The Hashmap for the rooms in Ford Hall.
    private static HashMap<String, Location> mendenhallMap; // The Hashmap for the rooms in Mendenhall Center.

    // Store the number of points earned by the user, defaults at 0 and the user can gain or lose points based on their choices.
    private int gamePoints;

    public ArrayList<String> inventory;


    public GameLoop() {
        // Initialize HashMaps for the three locations available in the game
        houseMap = new HashMap<String, Location>();
        fordMap = new HashMap<String, Location>();
        mendenhallMap = new HashMap<String, Location>();

        this.inventory = new ArrayList<String>(); // initialize empty inventory array list to store objects
        gamePoints = 0;
        

        // Fill the HashMap for the house area with different rooms.
        houseMap.put("N2", new Location("\nDORM ROOM: Your side\n", "Your corner of the room includes your bed and desk. (S)outh of here is your roommate's side of the room. Farther (S)outh is the house entrance.\n", false, false, false, true, null, null, null, "N1"));
        houseMap.put("N1", new Location("\nDORM ROOM:\n", "The entrance of your dorm. Your roommate has set up on this side of the room. \nTo the (S)outh is the house entrance. Farther (N)orth is your side of the room.\n", true, false, false, true, "N2", null, null, "S1"));
        houseMap.put("E1", new Location("\nHOUSE KITCHENETTE:\n", "The house kitchenette. To the (W)est is the house entrance. Further (E)ast you can see the laundry room.\n", false, true, true, false, null, "E2", "S1", null));
        houseMap.put("E2", new Location("\nLAUNDRY ROOM:\n", "This is the house laundry room. There isn't much to see here except a row of washing machines and some students waiting around for their clothes. \nTo the (W)est is the kitchenette.\n", false, false, true, false, null, null, "E1", null));
        houseMap.put("W1", new Location("\nHOUSE LOUNGE:\n", "You are in the house lounge. To the (E)ast is the house entrance. To the (W)est is a large bookcase, the house library.\n", false, true, true, false, null, "S1", "W2", null));
        houseMap.put("W2", new Location("\nLOUNGE LIBRARY:\n", "You are at the house library bookcase. To the (E)ast is the rest of the house lounge.\n", false, true, false, false, null, "W1", null, null));
        houseMap.put("S1", new Location("\nHOUSE ENTRANCE:\n", "You are in the foyer of your house. To the (N)orth is your dorm room. (E)ast of here you can see the house kitchenette. Looking to the (W)est, there's the house lounge. Going (S)outh will exit the house.\n", true, true, true, true, "N1", "E1", "W1", "S2"));
        houseMap.put("S2", new Location("\nHOUSE EXIT:\n", "You left your house. Where would you like to go? (N) to return to house, (W) to visit Ford Hall, or (E) to visit Mendenhall Center.\n", true, true, true, false, "S1", "Mendenhall Center", "Ford Hall", null));
    
        // Fill the HashMap for Ford Hall with different rooms.
        fordMap.put("N2", new Location("\nTERRACE'S EDGE:\n", "The far end of the terrace, off to the side from the doors. (S)outh of here is the back of the terrace where the door is.", false, false, false, true, null, null, null, "N1"));
        fordMap.put("N1", new Location("\nTERRACE:\n", "This is a terrace extending from the second floor of Ford. There are some plants and benches near the short brick parapet.\n Moving (S)outh will take you back downstairs to the entrace. Going (N)orth will bring you across the terrace up to the parapet.", true, false, false, true, "N2", null, null, "S1"));
        fordMap.put("E1", new Location("\nLOUNGE:\n", "There are several sofas and set up around the room. Assorted desks and chairs face the tall windows. \n Moving (W)est of here will bring you back to the entrance.", false, false, true, false, null, null, "S1", null));
        fordMap.put("W1", new Location("\nHALLWAY:\n", "You stand by the stairs in the hallway near Ford's entrance.. \nTo the (W)est you see a bulletin board hanging on the wall. To the (E)ast is the entrance of the building. \n", false, true, true, false, null, "S1", "W2", null));
        fordMap.put("W2", new Location("\nBULLETIN BOARD:\n", "You stand before a large bulletin board on the wall by the stairs. There are various posters hanging advertising the various happenings around campus.", false, true, false, false, null, "W1", null, null));
        fordMap.put("S1", new Location("\nENTRANCE:\n", "This is the entrance to Ford Hall. \nGoing (N)orth will bring you up the stairs. (E)ast of here is the lounge area. To the (W)est is a big hallway. (S)outh of you are the doors to exit.", true, true, true, true, "N1", "E1", "W1", "S2"));
        fordMap.put("S2", new Location("\nFORD EXIT:\n", "This is the outside of Ford Hall. Where would you like to go? (N) to return to Ford, (E) to go to your House, and (S) to visit Mendenhall Center.\n", true, true, false, true, "S1", "House", null, "Mendenhall Center"));
    
        // Fill the HashMap for Ford Hall with different rooms.
    
    }

    public static void main(String[] args) {

        // Create an instance of a GameLoop in order to initialize HashMaps.
        GameLoop currentPlaythrough = new GameLoop();

        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);
        String userResponse = ""; // Storage for user's responses

        // Create a Commands option to help us manage gameplay.
        Commands userControl = new Commands();


        // String lists of all the Smith houses, which we will use to assign the player a random house based on their chosen neighborhood in the following introduction.
        String [] gardenNeighborhood = {"COMSTOCK HOUSE", "HAVEN/WESLEY", "GARDINER HOUSE", "MORROW HOUSE", "SESSIONS COMPLEX", "WILDER HOUSE", "WILSON HOUSE"};
        String [] ivyNeighborhood = {"ALBRIGHT HOUSE","BALDWIN HOUSE","CHAPIN HOUSE",
                                         "DUCKETT HOUSE","HUBBARD HOUSE","LAWRENCE HOUSE","MORRIS HOUSE","TYLER HOUSE",
                                         "WASHBURN HOUSE"
                                        };
        String [] mountainNeighborhood = {"CAPEN HOUSE",
                                              "CUTTER HOUSE","GILLETT HOUSE","LAMONT HOUSE","NORTHROP HOUSE",
                                              "TALBOT HOUSE","ZISKIND HOUSE"
                                             };
        String [] paradiseNeighborhood = {"CUSHING HOUSE",
                                              "EMERSON HOUSE","FRIEDMAN APARTMENTS","JORDAN HOUSE","KING HOUSE","PARK HOUSE","PARSONS HOUSE","SCALES HOUSE"
                                             };
        String [] specialInterestHousing = {"CHASE HOUSE","HOPKINS HOUSE",
                                                "PARK ANNEX","PARSONS ANNEX","TENNEY HOUSE"
                                               };

        ///////////////////////////////////////////////////////////////
        //            ----------- GAME OPENING ---------------
        System.out.println("*******************************");
        System.out.println("SMITH COLLEGE DATING SIMULATOR");
        System.out.println("*******************************");

        // -------- PLAYER INTRODUCTION ----------
        // Asks user for input about the player name, desired House Neighborhood, and class year.

        System.out.println("Hi! my name Sophia Smith and I'm going to help you find love... or confess to your crush. What's your name?");
        String playerName = userInput.nextLine();
        System.out.println("Well, it's nice to meet you " + playerName + "! Let's begin. What neighborhood do you wanna live in?  Enter: \n 'A' for Garden Neighborhood, \n 'B' for Ivy Neighborhood, \n 'C' for Mountain Neighborhood, \n 'D' for Paradise Neighborhood \n 'E' for Special Interest Housing: ");
        String playerNeighborhood = userInput.nextLine().toUpperCase();

        //  ** ASSIGNING A PLAYER HOUSE **
        double neighborhoodIndex; // an index found using a random that is used to pick 
        int houseIndex; // the random integer as an int used to assign playerHouse to the house at this index
        String playerHouse; // the house assigned to the player

        /* A switch statement with cases for each neighborhood choice that generates a random index and assigns the user the house at that index in the neighborhood list. 
            Defaults to Sessions house if the user does not input any of the given options. */ 
        switch(playerNeighborhood) {
            //for the randomization of houses
            case "A":
                neighborhoodIndex = (int)(Math.random()*(((gardenNeighborhood.length-1)-0)+1))+0;
                houseIndex = (int) neighborhoodIndex;
                playerHouse = gardenNeighborhood[houseIndex];
                System.out.println("Great! Welcome to " + playerHouse);
            break;
            case "B":
                neighborhoodIndex = (int)(Math.random()*(((ivyNeighborhood.length-1)-0)+1))+0;
                houseIndex = (int) neighborhoodIndex;
                playerHouse = ivyNeighborhood[houseIndex];
                System.out.println("Great! Welcome to " + playerHouse);
            break;
            case "C":
                neighborhoodIndex = (int)(Math.random()*(((mountainNeighborhood.length-1)-0)+1))+0;
                houseIndex = (int) neighborhoodIndex;
                playerHouse = mountainNeighborhood[houseIndex];
                System.out.println("Great! Welcome to " + playerHouse);
            break;
            case "D":
                neighborhoodIndex = (int)(Math.random()*(((paradiseNeighborhood.length-1)-0)+1))+0;
                houseIndex = (int) neighborhoodIndex;
                playerHouse = paradiseNeighborhood[houseIndex];
                System.out.println("Great! Welcome to " + playerHouse);
            break;
            case "E":
                neighborhoodIndex = (int)(Math.random()*(((specialInterestHousing.length-1)-0)+1))+0;
                houseIndex = (int) neighborhoodIndex;
                playerHouse = specialInterestHousing[houseIndex];
                System.out.println("Great! Welcome to " + playerHouse);
            break;
            default:
                System.out.println("That wasn't an option... You know what? You had your chance, we're putting you in Sessions, have fun with the ghosts.");
                playerHouse = "SESSIONS HOUSE";
        }

        // Create the new player, assigning them a default class year of 0.
        Player currentUser = new Player(playerName, 0, playerHouse);

        //Ask the user for the player's class year and assign the int value of their class year using a switch statement to check the input. Defaults to first-year.
        System.out.println("Now, what's your class year? (senior, junior, sophomore, first-year)");
        String classYear = userInput.nextLine().toUpperCase();
        switch(classYear) {
            case "SENIOR":
                currentUser.classYear = 2023;
            break;
            case "JUNIOR":
                currentUser.classYear = 2024;
            break;
            case "SOPHOMORE":
                currentUser.classYear = 2025;
            break;
            case "FIRST-YEAR":
                currentUser.classYear = 2026;
            break;
            default:
                System.out.println("That isn't a class year...you seem confused, you must be a first year!");
                currentUser.classYear = 2026;
        }


        // Introduction + start of the game
        System.out.println("Welcome to the Smith College Dating Simulator! Type 'HELP' for a list of available commands. \n");
        System.out.println(currentUser.name + " walks in to " + currentUser.playerHouse + ". \n'Wowza!' You say in disbelief as you walk around and look at your new home. \n There's a wide array of Smithies buzzing around and getting ready for classes. All of a sudden, a familiar looking woman appears: \n'Hey, it's me, Sophia Smith again, I just wanted to tell you you can explore Smith's Campus by going (N)orth, (E)ast, (S)outh, or (W)est. \nAlso, you can impress your crush by talking with them or giving gifts you find. \nOkay, good luck kid :D' \n");
        // Initial location, the house entrance; prompt user to pick a direction
        System.out.println("With that, it's time for adventure... and love??? A bit overwhemled, you look at everything that beholds you. \nTo the east (E) you can smell some ramen and hear a Smithie bitterly complaining about the food at Smith and further east the thudding of washing machines. \nTo the west (W) you can see the lounging area and Smithies Studying. \nNorth (N) is the staircase that leads to your room.\n");
        // Set starting location so that the user can navigate from here. Store which room we are in as currentRoom, a Location, and what building we are in as a HashMap currentMap.
        Location currentRoom = houseMap.get("S1"); // Set the starting location to the house entrance.
        HashMap<String, Location> currentMap = houseMap; // Define a String to keep track of which location we are in, and therefore which map to navigate.
        House gameHouse = new House();

        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {
            // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓


            // if current map is house, create house object, check which room, execute associated method


            System.out.println("Where would you like to go next? (N, E, S, W) // type 'help' for a list of commands");
            userResponse = userInput.nextLine().toUpperCase();

            /* Switch statement for the main game loop.
             * Checks input against the defined commands and executes the specified command when recognized. 
             */
            switch(userResponse) {
                case "HELP": 
                    userControl.showOptions();
                break;
                case "LOOK AROUND": 
                    // Print out the description of the current room.
                    System.out.println(currentRoom.description);
                break;
                case "GRAB": System.out.println("add item to inventory");
                break;
                case "DROP": System.out.println("drop the item");
                break;
                case "N":  // go north
                    currentRoom = userControl.goNorth(currentRoom, currentMap);
                break;
                case "E": // go east
                    currentRoom = userControl.goEast(currentRoom, currentMap);
                break;
                case "S": // go south
                    currentRoom = userControl.goSouth(currentRoom, currentMap);
                break;
                case "W": // go west
                    currentRoom = userControl.goWest(currentRoom, currentMap);
                break;
                case "CHECK SCORE": // print the current number of game points
                    System.out.println(currentPlaythrough.gamePoints);
                break;
                case "CHECK INVENTORY": // print out the items currently held in the inventory
                    System.out.println("Current Inventory:" + currentPlaythrough.inventory);
                break;
                case "QUIT": // exit the game
                    System.out.println("Ending the game.");
                    stillPlaying = false;
                break;
                default: System.out.println("Invalid input. Type 'HELP' for a list of recognized commands.");
            }

            if (currentMap.equals(houseMap)) {
                switch(currentRoom.name) {
                    case "\nDORM ROOM: Your side\n":
                        gameHouse.YourDorm();
                    break;
                    case "\nDORM ROOM:\n":
                        gameHouse.DormRoomEntrance();
                    break;
                    case "\nHOUSE KITCHENETTE:\n":
                        gameHouse.HouseKitchenette();
                    break;
                    case "\nLAUNDRY ROOM:\n":
                        gameHouse.LaundryRoom();
                    break;
                    case "\nHOUSE LOUNGE:\n":
                        gameHouse.HouseLounge();
                    break;
                    case "\nLOUNGE LIBRARY:\n":
                        gameHouse.LoungeLibrary();
                    break;
                    case "\nHOUSE ENTRANCE:\n":
                        gameHouse.HouseEntrance();
                    break;
                    case "\nHOUSE EXIT:\n":
                        gameHouse.HouseExit();
                    break;
                    default: System.out.println("No location detected");
                }
            }

            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            if (userResponse.equals("WIN") || userResponse.equals("LOSE")) {
                stillPlaying = false;
            }
        } while (stillPlaying);

        // Tidy up - close our scanner
        userInput.close();

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        if (userResponse.equals("WIN")) {
            System.out.println("CONGRATULATIONS! Thanks for playing!");
        } else { // userResponse.equals("LOSE")
            System.out.println("Game over. Better luck next time.");
        }

    }
}