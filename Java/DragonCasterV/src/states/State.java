package states;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import actors.BaseObject;

@SuppressWarnings("serial")
public abstract class State extends JPanel{

	List<BaseObject> objects;
	
	// Constructor
	public State() {
		objects = new ArrayList<BaseObject>();
	}
	
	// To be overwritten
	public abstract void getInput(int code);
	
	// To be overwritten
	public abstract void update();

	public List<BaseObject> getObjects() {
		return objects;
	}
}
