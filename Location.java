
/** A class Location
 * 
 */
public class Location {

    //      Identifying information
    protected String name; // the name of this room, ex. "lounge area"
    protected String description; // the description of this room, provides information on adjacent rooms and which direction they are from here

    //      Booleans indicating whether there is an exit present in a direction n, e, s, w. An "exit" is a room that can be moved into from this one.
    private boolean isNorth; // true when there is a room north of this room
    private boolean isEast; // true when there is a room east of this room
    private boolean isWest; // true when there is a room west of this room
    private boolean isSouth; // true when there is a room south of this room

    //      Strings that identify which room the exit is in the direction n, e, s, w.
    String exitNorth;
    String exitEast;
    String exitWest;
    String exitSouth;


    /* Default constructor for a location of unspecified name, description, and exits. */
    public Location() {
        this("<Undefined Name", "<Empty Description>", false, false, false, false, "N1", "E1", "W1", "S1");
    }

    /* Complete constructor for a location of specified name, description, and exits. */
    public Location (String name, String description, boolean isNorth, boolean isEast, boolean isWest, boolean isSouth, String exitNorth, String exitEast, String exitWest, String exitSouth) {
        // Constructor for a Location
        this.name = name;
        this.description = description;
        this.isNorth = isNorth;
        this.isEast = isEast;
        this.isWest = isWest;
        this.isSouth = isSouth;
        this.exitNorth = exitNorth;
        this.exitEast = exitEast;
        this.exitWest = exitWest;
        this.exitSouth = exitSouth;
    }

    //         ** Accessor methods **
    // location name
    public String getName() {
        return name;
    }

    // location description
    public String getDesc() {
        return description;
    }

    /* Accessor for different direction typ booleanss, indicating whether or not the player can move in this direction. */
    public boolean isExit(String direction) {
        switch(direction) {
            case "N":
                return this.isNorth;
            case "E":
                return this.isEast;
            case "W":
                return this.isWest;
            case "S":
                return this.isSouth;
            default:
                return false;
        }
    }

    
    // ** NAVIGATION METHODS **    (I moved this to commands)
    // public void goNorth() {
    //     if(this.isNorth) {
    //         System.out.println("You moved north into the next room.");
    //     } else {
    //         System.out.println("Sorry, you cannot move in this direction. Try going another way.");
    //     }
    // }

    // public void goEast() {
    //     if(this.isEast) {
    //         System.out.println("You moved east into the next room.");
    //     } else {
    //         System.out.println("Sorry, you cannot move in this direction. Try going another way.");
    //     }
    // }

    // public void goWest() {
    //     if(this.isWest) {
    //         System.out.println("You moved west into the next room.");
    //     } else {
    //         System.out.println("Sorry, you cannot move in this direction. Try going another way.");
    //     }
    // }

    // public void goSouth() {
    //     if(this.isSouth) {
    //         System.out.println("You moved south into the next room.");
    //     } else {
    //         System.out.println("Sorry, you cannot move in this direction. Try going another way.");
    //     }
    // }
}

