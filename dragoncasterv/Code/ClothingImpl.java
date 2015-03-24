package items;

public class ClothingImpl implements Clothing{
	
	//Instantiating variables to hold stat and misc values of items
	private String name;
	private int amount;
	
	private int armorValue, healthValue, strengthValue, manaValue, agilityValue, magicValue;
	
	private int monetaryValue;
	
	public ClothingImpl(String name, int amount, int armorValue, int healthValue, int strengthValue, int manaValue, int agilityValue,
						int magicValue, int monetaryValue) {
		this.name = name;
		this.amount = amount;
		
		this.armorValue = armorValue;
		this.healthValue = healthValue;
		this.strengthValue = strengthValue;
		this.manaValue = manaValue;
		this.agilityValue = agilityValue;
		this.magicValue = magicValue;
		
		this.monetaryValue = monetaryValue;
		
	}

	//Returns the amount of the item the player has
	public int getAmount() {
		return amount;
	}

	//Sets the amount of the item the player has
	public void setAmount(int amount) {
		this.amount = amount;
		
	}

	//Returns the name of the item
	public String getName() {
		return name;
	}

	//Returns the armor rating of the item
	public int getArmorValue() {
		return armorValue;
	}

	//Returns the health rating of the item
	public int getHealthValue() {
		return healthValue;
	}

	//Returns the mana rating of the item
	public int getManaValue() {
		return manaValue;
	}

	//Returns the strength rating of the item
	public int getStrengthValue() {
		return strengthValue;
	}

	//Returns the agility rating of the item
	public int getAgilityValue() {
		return agilityValue;
	}

	//Returns the magic rating of the item
	public int getMagicValue() {
		return magicValue;
	}

	//Returns the cost of the item from a store
	public int getMonetaryValue() {
		return monetaryValue;
	}

	//Sets the armor rating for the item
	public void setArmorValue(int value) {
		armorValue = value;
	}

	//Sets the health rating for the item
	public void setHealthValue(int value) {
		healthValue = value;
	}

	//Sets the mana rating for the item
	public void setManaValue(int value) {
		manaValue = value;
	}

	//Sets the strength rating for the item
	public void setStrengthValue(int value) {
		strengthValue = value;
	}

	//Sets the agility rating for the item
	public void setAgilityValue(int value) {
		agilityValue = value;
	}

	//Sets the magic value for the item
	public void setMagicValue(int value) {
		magicValue = value;
	}

	//Sets the cost of the item
	public void setMonetaryValue(int value) {
		monetaryValue = value;
	}
	
	
}
