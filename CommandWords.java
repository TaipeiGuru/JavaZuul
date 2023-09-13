/*
 *  This is the game of Zuul, a text-based adventure game that focuses on the user finding
 *  certain items in the rooms of a castle and making it out safely. It was initially created 
 *  by Michael Kolling and David J. Barnes, and was modified by Jason Randolph. Last edits were 
 *  made 12/10/21.
 */

class CommandWords
{
    // a constant array that holds all valid command words ("inventory," "get," and "drop" were added to the original command words)
    private static final String validCommands[] = {
        "go", "quit", "help", "inventory", "get", "drop"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. 
     * Return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    /*
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(int i = 0; i < validCommands.length; i++) {
            System.out.print(validCommands[i] + "  ");
        }
        System.out.println();
    }
}
