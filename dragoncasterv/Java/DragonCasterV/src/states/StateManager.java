package states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import actors.BaseObject;

@SuppressWarnings("serial")
public class StateManager extends JPanel{

	/**
	 * Stack for the game states. Each state is
	 * responsible for popping itself off of the
	 * state. Not entirely sure how to do that though.
	 */
	Deque<State> stack;

	public StateManager() throws IOException {
		// Initializes to the main menu
		stack = new ArrayDeque<State>();
		stack.push(new MainMenu());

		addKeyListener((KeyListener) new myKeyListener());
		addMouseListener((MouseListener) new myMouseListener());
	}
	
	public void gameLoop() {
		
	}
	
	/*
	 * Currently the idea behind the listeners is that
	 * they need to be somewhat global because no matter
	 * where you are you still need input reading.
	 * 
	 * I'm not sure if this is inefficient (sending the 
	 * state objects the input every time)
	 */

	// Internal class for overriding key listener
	public class myKeyListener implements KeyListener{
		
		@Override
		public void keyPressed(KeyEvent e) {
			stack.getFirst().getInput(e.getKeyCode());
		}
		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}
	}

	// Internal class for overriding mouse listener
	public class myMouseListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
	}

	/**
	 * Apparently this is called automatically. What a load of bull.
	 */
	@Override
	public void paint(Graphics g) {
		List<BaseObject> tempList = stack.getFirst().getObjects();
		for(int i = 0; i < tempList.size(); i++) {
			BaseObject tempObj = tempList.get(i);
			g.drawImage(tempObj.getImage(), tempObj.getDisplayX(), tempObj.getDisplayY(), this);
		}
	}
	
	// Run me baby
	public static void main(String[] args) throws IOException {
		StateManager manager = new StateManager();
		
		JFrame frame = new JFrame("Dragon Caster V");
		frame.add(manager);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
