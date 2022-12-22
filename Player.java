
/** A class Player that stores information about this user, with a String for name, int for class year, and String for player house */
public class Player {
    // public ArrayList<String> inventory;
    private String name;
    protected int classYear;
    private String playerHouse;

    /* Full constructor for a player. */
    /**
     * All the player's chosen personal information
     * @param name
     * @param classYear
     * @param playerHouse
     */
    public Player(String name, int classYear, String playerHouse) {
        // this.inventory = new ArrayList<String>();
        this.name = name;
        this.classYear = classYear;
        this.playerHouse = playerHouse;
    }


    //       ** Accessor methods for the player **

    /**
     * Accessor for player name
     * @return player name
     */
    public String getName() {
        return this.name;
    }


    /**
     * Accessor for class year
     * @return player's class year (2026, 2025, 2024, 2023)
     */
    public int getClassYear() {
        return this.classYear;
    }

    /**
     * Accessor for player house 
     * @return player's assigned Smith house (Morris, Wilson, Cutter, etc.)
     */
    public String getPlayerHouse() {
        return this.playerHouse;
    }

    //       ** Manipulator methods for the player **

    /**
     * Manipulator for player name
     * @param name the String for the new name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Manipulator for class year
     * @param classYear the int for the class year to be set to (2026, 2025, 2024, 2023)
     */
    public void setClassYear(int classYear) {
        this.classYear = classYear;
    }

    /**
     * Manipulator for player house
     * @param playerHouse the string of the house name to set this player's Smith house to (Morris, Wilson, etc.)
     */
    public void setPlayerHouse(String playerHouse) {
        this.playerHouse = playerHouse;
    }
}
