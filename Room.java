import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
 *  This is the game of Zuul, a text-based adventure game that focuses on the user finding
 *  certain items in the rooms of a castle and making it out safely. It was initially created 
 *  by Michael Kolling and David J. Barnes, and was modified by Jason Randolph. Last edits were 
 *  made 12/10/21.
 */

class Room 
{
    private String description;
    private HashMap exits;        // stores exits of this room.
    
    // Creating the array list to store items 
    ArrayList<Item> items = new ArrayList<Item>();

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court 
     * yard".
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap();
    }

    /**
     * Define an exit from this room.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * Return the description of the room (the one that was defined in the
     * constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a long description of this room, in the form:
     *     You are in the kitchen.
     *     Exits: north west
     */
    public String getLongDescription()
    {
        return "You are " + description + "\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set keys = exits.keySet();
        for(Iterator iter = keys.iterator(); iter.hasNext(); ) {
            returnString += " " + iter.next();
        }
        
        // Modified from original code to ensure that when the user enters a room, items are displayed in that room
        returnString += "\nItems in the room: ";
        returnString += getRoomItems();
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Room getExit(String direction) 
    {
        return (Room)exits.get(direction);
    }
    
    // This method gets items from a room.
    public Item getItem(int index) {
    	return items.get(index);
    }
    
    // getItem method, used for selecting the item from the array list in the room
    public Item getItem(String itemName) {
    	for (int i = 0; i < items.size(); i++) {
			if(items.get(i).getDescription().equals(itemName)) {
				return items.get(i);
			}
		}
    	return null;
    }
    
 // getItem method, used for removing the item from the array list in the room
    public void removeItem(String itemName) {
    	for (int i = 0; i < items.size(); i++) {
			if(items.get(i).getDescription().equals(itemName)) {
				items.remove(i);
			}
		}
    }
    
    // This method adds an item to a room. 
    public void setItem(Item newitem) {
    	items.add(newitem);
    }
    
    // Getting a description of the items in a room. 
    public String getRoomItems() {
    	String output = "";
    	
    	// Again, code is slightly more complex to account for grammatical discrepancies
    	if(items.size() == 0) {
    		return "none";
    	} else {
    		for (int i = 0; i < items.size(); i++) {
        		if(items.size() == 1) {
        			output += items.get(i).getDescription() + " ";

        		} else if(items.size() == 2) {
        			if(i == items.size() - 1) {
            			output += items.get(i).getDescription();
        			} else {
        				output += items.get(i).getDescription() + " and ";
        			}
        		} else {
        			if(i == items.size() - 1) {
            			output += "and " + items.get(i).getDescription() + " ";
        			} else {
            			output += items.get(i).getDescription() + ", ";
        			}
        		}
        	}
        	return output;
    	}
    }
 }

