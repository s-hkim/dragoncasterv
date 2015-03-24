package states.combatState;

import states.State;
import actors.Actor;

@SuppressWarnings("serial")
public class Combat extends State {
	
	int numTilesWide;
	int numTilesHigh;
	Tile[][] tiles;
	boolean waitingForAction;
	Actor[] entities;
	int currentEntityNum;
	int numEntities;
	
	public Combat(int[][] t, Actor[] entities) {
		super();
		
		initializeGrid(t);
		this.entities = entities;
		currentEntityNum = 0;
		waitingForAction = true;
		
		// Load objects (buttons and menus) here
	}
	
	public void stateLoop() {
		numEntities = entities.length;
		Actor currentEntity = entities[currentEntityNum];
		
		while(waitingForAction) {
			// User characters will return true while waiting
			// for a command
			// AI will always return false
			waitingForAction = currentEntity.turn();
		}
		
		// Cycles through entities
		currentEntity = entities[(currentEntityNum + 1) % numEntities];
	}
	
	public void useInput() {}
	
	public void initializeGrid(int[][] t) {
		// * Please note these may be reversed
		// because I don't know what I'm doing
		// Also this should be after the asterisks
		
		int width = t.length;
		int height = t[0].length;
		tiles = new Tile[width][height];
		
		// Rows*
		for(int i = 0; i < width; i++) {
			// Columns*
			for(int j = 0; j < height; j++) {
				Tile temp = new Tile("Images/basicTile.png");
				temp.setType(t[i][j]);
				tiles[i][j] = temp;
			}
		}
	}

	@Override
	public void useInput(int input) {}

	@Override
	public void update() {}
}
