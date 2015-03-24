package actors;

import java.io.IOException;

import combat.VarStat;
import constants.Constants;

/**
 * ABSTRACT class for a generic character.
 * Contains all stats and basic abilities
 * 
 * @author Kevin
 *
 */
public abstract class Character extends BaseObject {

	private VarStat health;
	private VarStat mana;
	private VarStat shield;
	private VarStat defence;
	private VarStat speed;
	private int exp;
	private int level;

	public Character (int h, int m, int sh, int d, int sp, String path) throws IOException {
		super(path);
		health.set(h);
		mana.set(m);
		shield.set(sh);
		defence.set(d);
		speed.set(sp);
		exp = 0;
		level = 1;
	}

	/** COMBAT ABILITIES **/
	
	/**
	 * Function to allow a character to
	 * take a turn. Not sure how do do this
	 * @param action	Action the character takes
	 */
	public void turn(int action) {
			switch (action) {
				case 0: cAttack(); break;
				case 1: cDefend(); break;
				case 2: cSpells(); break;
				case 3: cUseItem(); break;
				default: System.out.println("This move does not exist!"); break;
		}
	}

	private void cAttack() {}
	private void cDefend() {}
	private void cSpells() {}
	private void cUseItem() {}

	/** STAT RETURNS **/
	public int getHealth() {
		return health.get();
	}

	public int getMana() {
		return mana.get();
	}

	public int getShield() {
		return shield.get();
	}
	
	public int getDefence() {
		return defence.get();
	}
	
	public int getSpeed() {
		return speed.get();
	}
	
	public int getExp() {
		return exp;
	}
		
	// SETTERS or modifiers
	
	/**
	 * Function to add experience
	 * @param toAdd
	 * @return
	 */
	public int addExp(int toAdd) {
		exp += toAdd;
		return exp;
	}
	
	public void setLevel(int lvl) {
		level = lvl;
	}
	
	// OTHER FUNCTIONS
	
	public int checkLevel() {
		int i;
		// If experience is somehow 0, we return level 1
		// and set experience to 0
		if (exp < 0) {
			exp = 0;
			return 1;
		}
		// We can use 1 based indexing since
		// we set the size to 101 and set the
		// 0th index to nothing
		for(i = 1; i <= 100; i++) {
			if (Constants.levelThresholds[i] >= exp)
				break;
		}
		level = i;
		return level;
	}

	/** MAP MOVEMENT
	 *  This should probably be moved
	 *  into the group object that will
	 *  only be used in order to move
	 *  around on the map
	 */
	public void mMove() {}
	public void mTeleport() {}
}
