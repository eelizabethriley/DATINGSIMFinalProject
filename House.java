import java.util.Scanner;

public class House {
    // The points gained or lost while at this location, to be added to the overall game total in the main game loop.
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
    
    public House() {
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

    public void DormRoomEntrance() {
        // Each location has two branches when called, one for when this is your first time here and another for when you've already been to this place.
        if (hasBeenDRE) {  // execute this branch when the player has been to this room before
            System.out.println("There isn't much to see here.");
        } else { // event branch; 
            int roommateFriend = (int)(Math.random() * (2 - 1 + 1) + 1);

            if (roommateFriend % 2 == 1) {
                System.out.println("Your roommate smiles when you enter the room. Yay! *** +10 POINTS *** \n");
                System.out.println("Hey! It's nice to finally meet you in person. I'm Jess, but everyone calls me Jelly.  *Jelly goes back to unpacking* :D \n");
                roommateFriendship = true;
                locationPoints += 10;
            } else {
                System.out.println("Your roommate glares at you and seems to be mad you're breathing so loudly. *** -10 POINTS ***\n");
                System.out.println(" 'Oh, hi. I guess you want to be in my room... that's cool I guess, I'm Jess' *Jess starts smoking weed (and doesn't even offer to share!) :( * \n");
                roommateFriendship = false;
                locationPoints -= 10;
            }
    
            System.out.println("You notice a -Smith Cookie- on your roommate's desk. You kind of want it. 'Hey roomie' you say, half smiling, 'Can I have that cookie?'\n ");
            if (roommateFriendship == true) {
                System.out.println("'Sure! I wasn't even going to eat it anyway'\n Cool! Now it's in your nice Conaway Center Tote Bag. *** +5 POINTS *** \n");
                // inventory.add("Smith Cookie");
                locationPoints += 5;
            }
    
            if (roommateFriendship == false) {
                System.out.println("'HELL NO, it's for Mr.Twinkles' *Jess proceeds to feed the cookie to her unregistered, feral, emotional support rat that lives on your dresser*  :((\n");
            }
            hasBeenDRE = true;
        }
    }

    public void HouseKitchenette() {
        if(hasBeenHK) {
            System.out.println("The kitchenette is quiet now. There isn't much to do here.");
        } else {
            System.out.println("You enter the kitchette and see two Smithies making Peanut Butter Cookies and vibing. 'Oh golly' you think to yourself 'I better introduce myself and make some friends' What do you open with? \n **Bust it down (type 'B')** \n **Just introduce yourself (type 'I')** \n **Make Fun of your rival house (type M)** \n");
            userResponse = userInput.nextLine().toUpperCase();

            switch (userResponse) {
                case "B":
                    System.out.println("Quirked up you goated with the sause busts it down platonic style and impress them with your sweet moves! *** +15 POINTS *** \n");
                    locationPoints += 15;
                break;
                case "I":
                    System.out.println("You say 'Hi, I just moved in, I live in room 302. It's nice to meet you'. That was kind of basic but they seem to like you. *** +5 POINTS *** \n");
                    locationPoints += 5;
                break;
                case "M":
                    System.out.println("You start trash talking your rival house that's basically a clone of your house and gain their respect. Nothing builds camaraderie more than a common enemy. *** +10 POINTS *** \n");
                    locationPoints += 10;
                break;
                default: 
                    System.out.println("OH NO! You fail to say anything and now they're really uncomfortable as you stare blankly at them. *** -10 POINTS *** \n");
                    locationPoints -= 10;
            }
            hasBeenHK = true;
        }

    }

    public void LaundryRoom() {
        if(hasBeenLR) {
            System.out.println("The laundry room is pretty empty. There isn't much to do here.");
        } else {
            System.out.println("There isn't much to see besides washing machines going and a free bin. Looking around, you notice a picture discarded on the floor with the following words: \n *** Mendenhall *** \n *** Ford Hall *** \n");
            hasBeenLR = true;
        }
    }

    public void HouseLounge() {
        if(hasBeenHL) {
            System.out.println("The lounge area is quiet now. There's not much to see.");
        } else {
            System.out.println("You enter the lounging area with a few Smithies studying and doing their own thing. 'Oh boy' you think to yourself 'I better not bother them, they look busy'.");
            hasBeenHL = true;
        }
    }

    public void LoungeLibrary() {
        if(hasBeenLL) {
            System.out.println("There's nobody near the bookcase now. There isn't much to see here.");
        }
        else {
            System.out.println("Immediately, in the corner of this room, you see a book of Greek Myths with a page hanging out. You go to pick it up but then someone's hand swoops in and takes it. \n 'Hey, I'm Alex (they/them), I live on the 4th floor.' You notice that they're wearing a shirt for Newsies...they must be a theatre kid. WHAT DO YOU DO??? \n **They kind of cute? Flirt??? (type 'F')** \n **Start shrieking (type 'S')** \n ** Ask about the book (type B)** \n ");
            userResponse = userInput.nextLine().toUpperCase();

            switch (userResponse) {
                case "F":
                    System.out.println("EW! That's house incest, which is never a good idea. HOUSE BOOTY = BAD BOOTY *** -10 POINTS *** \n");
                    locationPoints -= 10;
                break;
                case "S":
                    System.out.println("Your screaming disorients them and you can get a better look at the book but at what cost??? *** -5 POINTS ***  \n");
                    locationPoints -= 5;
                break;
                case "B":
                    System.out.println("'Oh, that's a book I found from Josten. Me and some of my  friends are putting on a play about King Minos of Crete.'Alex says to you. *** +10 POINTS *** \n");
                    locationPoints += 10;
                break;
                default: 
                    System.out.println("You just stare blankly at them and Alex hisses at you and walks off as if you've been marked. Nice going! *** -15 POINTS *** \n");
                    locationPoints -= 15;
            }
            System.out.println("'Well, that was nice and totally not important' you think to yourself as they walk away");
            hasBeenLL = true;
        }

    }

    public void HouseEntrance() {
        if (hasBeenHE) {
            System.out.println("There isn't much to do here.");
        }
        else {
            // The intro sequence represents the events for this room, there is no other unique dialogue.
            this.hasBeenHE = true;
        }
    }

    public void HouseExit() {
        System.out.println("Pick a new location");
    }
}
