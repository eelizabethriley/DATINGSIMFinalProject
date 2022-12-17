import java.util.Scanner;

public class FordHall {
    private int locationPoints;

    //    Visited Location Trackers: hasBeen boolean variables that indicate whether or not the player has been in this room before.
    boolean hasBeenYD; // has been in the "YourDorm" room
    boolean hasBeenDRE; // has been in the "DormRoomEntrance" room
    boolean hasBeenHK; // has been in the "HouseKitchenette" room
    boolean hasBeenLR; // has been in the "LaundryRoom" room
    boolean hasBeenHL; // has been in the "HouseLounge" room
    boolean hasBeenLL; // has been in the "LoungeLibrary" room
    boolean hasBeenHE; // has been in the "HouseExit" room

    //   A boolean that stores whether or not the user's roommate likes them.
    boolean roommateFriendship;

    //  Take in input from the user to make choices during certain events.
    Scanner userInput = new Scanner(System.in);
    String userResponse = ""; // Storage for user's responses
    
    public FordHall() {
        locationPoints = 0;
        hasBeenYD = false;
        hasBeenDRE = false;
        hasBeenHK = false;
        hasBeenLR = false;
        hasBeenHL = false;
        hasBeenLL = false;
        hasBeenHE = false;
    }


    public int YourDorm() {
        if (hasBeenYD) {
            System.out.println("You've already unpacked. There isn't much to do here now.");
        } else {
            System.out.println("You walk further into your dorm and start unpacking. On your desk you see an old photo of Smithies from the 1800s doing a play. One Smithie is dressed in a gown and another is as a monster. That's weird... Should you take it? (Y/N) \n");
            hasBeenYD = true;
        } return locationPoints;

    }
}
