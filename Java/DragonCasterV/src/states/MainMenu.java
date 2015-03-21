package states;

import java.awt.event.KeyEvent;
import java.io.IOException;

import actors.BaseObject;
import actors.Button;

@SuppressWarnings("serial")
public class MainMenu extends State{
	
	public MainMenu() throws IOException {
		super();
		
		// Load in all objects needed
		objects.add(new BaseObject("Images/titlescreen.png").x(400).y(200));
		objects.add(new Button("Images/startbutton.png").x(400).y(300));
	}

	@Override
	public void getInput(int code) {
		switch(code) {
			case KeyEvent.VK_UP:
				break;
			case KeyEvent.VK_DOWN:
				break;
		}
	}

	@Override
	public void update() {}
}
