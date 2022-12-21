This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.

IN GAME COMMANDS:
-- 'HELP': print a list of available commands.
-- 'LOOK AROUND': print out a description of the current surroundings. This is a helpful command to use when you are confused or are not sure
    where to go next. The description includes information about what adjacent rooms are available to move into, and what direction they're
    located in.
-- 'DROP' - remove the item x from your inventory. When called, it prompts the user to input which item they would like dropped, so it must first be typed
    as simply "drop" and then the user will be asked to write in which item to drop.
-- 'N': go north on the map into the next room.
-- 'E' - go east on the map into the next room.
-- 'S' - go south on the map. 
-- 'W' - go west on the map. 
-- 'CHECK SCORE': check how many points you currently have.
-- 'CHECK INVENTORY': check what items you currently have in your inventory.
-- 'QUIT': exit the game.
* Note that casing does not matter when writing into the terminal, as all input is converted to uppercase when parsed.
   


# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.

The winning condition of the game is to have greater than or equal to 100 points. Going to Mendenhall and beating the minotaur will greatly increase
your points and thus make you likely to win. Other ways to earn points are making good decisions during other events in the game, especially when
talking to "crushes."

If the player's score drops to 50 points or fewer, they will automatically lose. Again, the minotaur fight will change the player's points significantly,
and losing will cost the player 30 points immediately. Points are also lost when the player embarasses themself or makes irresponsible choices.

Events like the minotaur fight and roommate greeting are randomized to be in the player's favor or not, so winning is in part up to chance.

There are certain points that can be earned based on other conditions, for example having the cookie from your roommate allows you to gift this to Portabella in Ford Hall if
you ask her what she's doing on the terrace.