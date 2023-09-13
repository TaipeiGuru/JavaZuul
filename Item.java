// This class sets up the methods that get the descriptions of items, which will be used later on in the code 
public class Item {
	String description;
	// constructor
	public Item(String newdescription) { 
		description = newdescription;
	}
	
	public String getDescription() { 
		return description;
	}
}
