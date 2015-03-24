package items;

public interface Clothing extends Item{
	
	//getters for the stat boosts that the clothing items provide
	int getArmorValue();
	int getHealthValue();	
	int getManaValue();
	int getStrengthValue();
	int getAgilityValue();
	int getMagicValue();
	
	//setters for the stat boosts that the clothing items provide
	void setArmorValue(int value);
	void setHealthValue(int value);
	void setManaValue(int value);
	void setStrengthValue(int value);
	void setAgilityValue(int value);
	void setMagicValue(int value);

}	
