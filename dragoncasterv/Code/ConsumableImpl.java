package items;

public class ConsumableImpl implements Consumable{

	//Instantiating the values of the item
	private String name;
	private int amount;
	
	private int healValue, manaRegenValue, monetaryValue;
	
	public ConsumableImpl(String name, int amount, int healValue, int manaRegenValue, int monetaryValue) {
		
		this.name = name;
		this.amount = amount;
		
		this.healValue = healValue;
		this.manaRegenValue = manaRegenValue;
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

	//Returns the cost of the item
	public int getMonetaryValue() {
		return monetaryValue;
	}

	//Sets the cost of the item
	public void setMonetaryValue(int value) {
		monetaryValue = value;
	}

	//Returns the amount that the consumable heals for
	public int getHealValue() {
		return healValue;
	}

	//Returns the amount that the consumable gives to the player in mana
	public int getManaRegenValue() {
		return manaRegenValue;
	}
	
}
