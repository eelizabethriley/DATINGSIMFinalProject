import java.util.HashMap;

/** A class Commands that contains methods for user commands called during the game
 * 
 */
public class Commands {
    
    public Commands() {

    }

/**
 * Print out a list of avaiable commands.
 */
    public void showOptions() {
        System.out.println("\nAvailable game commands:" +
        "\n + 'HELP' - print a list of available commands. \n + 'LOOK AROUND' - print out a description of the current surroundings." + 
        "\n + 'DROP x' - remove the item x from your inventory. " +
        "\n + 'N' - go north on the map. \n + 'E' - go east on the map. \n + 'S' - go south on the map. \n + 'W' - go west on the map." + 
        "\n + 'CHECK SCORE' - check how many points you currently have. \n + 'CHECK INVENTORY' - check what items you currently have in your inventory. \n + 'QUIT' - exit the game. \n");
    }

    /**
     * Print out a list of all the items in the inventory
     * @param currentPlaythrough an intance of GameLoop for the playthrough current running. Stores inventory and points, passed in so that we can access the inventory.
     */
    public void printInventory(GameLoop currentPlaythrough) {
        System.out.print("Current Inventory: ");
        for(int i =0; i<currentPlaythrough.inventory.size(); i++) {
            System.out.println("-- " + currentPlaythrough.inventory.get(i));
        }
        System.out.println(" ");
    }

        // ** NAVIGATION METHODS **
        /**
         * Allows players to move to the room north of the current room
         * @param currentRoom an instance of Room; the room the player is in when this is called, we need to access this to check if there is a path available in the north direction, and if so which room is north (exitNorth)
         * @param currentMap the map of the room the player is currently in, we need this to access the exitNorth for the room
         * @return currentRoom in the GameLoop we will set the current room to this new room, the exitNorth of the room originally passed in
         */
    public Room goNorth(Room currentRoom, HashMap<String, Room> currentMap) {
        // Check which map we are in, then check which room this is, then change current room to the room north of this one
        if(currentRoom.isExit("N")) {
            System.out.print("\n> You moved north into the next room. ");
            currentRoom = currentMap.get(currentRoom.exitNorth);
            System.out.println(currentRoom.name + currentRoom.description);
            
        } else {
            System.out.println("Sorry, you cannot move in this direction from here. Try going another way.");
        } return currentRoom;
    }
        /**
        * Allows players to move to the room east of the current room
        * @param currentRoom an instance of Room; the room the player is in when this is called, we need to access this to check if there is a path available in the east direction, and if so which room is north (exitEast)
        * @param currentMap the map of the room the player is currently in, we need this to access the exitEast for the room
        * @return currentRoom in the GameLoop we will set the current room to this new room, the exitEast of the room originally passed in
        */
    public Room goEast(Room currentRoom, HashMap<String, Room> currentMap) {
        if(currentRoom.isExit("E")) {
            System.out.print("\n> You moved east into the next room. ");
            currentRoom = currentMap.get(currentRoom.exitEast);
            System.out.println(currentRoom.name + currentRoom.description);
            // add conditional for e1 or e2
        } else {
            System.out.println("Sorry, you cannot move in this direction from here. Try going another way.");
        } return currentRoom;
    }

        /**
        * Allows players to move to room west of the current room
        * @param currentRoom an instance of Room; the room the player is in when this is called, we need to access this to check if there is a path available in the north direction, and if so which room is north (exitWest)
        * @param currentMap the map of the room the player is currently in, we need this to access the exitWest for the room
        * @return currentRoom in the GameLoop we will set the current room to this new room, the exitWest of the room originally passed in
        */
    public Room goWest(Room currentRoom, HashMap<String, Room> currentMap) {
        if(currentRoom.isExit("W")) {
            System.out.print("\n> You moved west into the next room. ");
            currentRoom = currentMap.get(currentRoom.exitWest);
            System.out.println("You are now in " + currentRoom.name + currentRoom.description);
        } else {
            System.out.println("Sorry, you cannot move in this direction from here. Try going another way.");
        } return currentRoom;
    }

    /**
    * Allows players to move to the south side of the room
     * @param currentRoom
     * @param currentMap
     * @return currentRoom
     */
    public Room goSouth(Room currentRoom, HashMap<String, Room> currentMap) {
        if(currentRoom.isExit("S")) {
            System.out.print("\n> You moved south into the next room. ");
            currentRoom = currentMap.get(currentRoom.exitSouth);
            System.out.println(currentRoom.name + currentRoom.description);
        } else {
            System.out.println("Sorry, you cannot move in this direction from here. Try going another way.");
        } return currentRoom;
    }

}
