package states;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import actors.BaseObject;

@SuppressWarnings("serial")
public abstract class State extends JPanel{

	Map<String, BaseObject> objects;
	
	// Constructor
	public State() {
		objects = new HashMap<String, BaseObject>();
	}

	public abstract void useInput(int input);
	
	// To be overwritten
	public abstract void update();

	public Map<String, BaseObject> getObjects() {
		return objects;
	}
}
