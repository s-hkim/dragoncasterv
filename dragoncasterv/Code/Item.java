package items;

public interface Item {	
	//Returns the amount of the item the player has
	int getAmount();
	
	//Sets the amount of the item the player has
	void setAmount(int a);
	
	//Returns the name of the item
	String getName();	
	
	//Returns the cost of the item
	int getMonetaryValue();
	
	//Sets the cost of the item
	void setMonetaryValue(int a);
}	
