package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import actors.BaseObject;
import actors.Button;

@SuppressWarnings("serial")
public class StateManager extends JPanel{
	
	static final int UPDATES_PER_SEC = 60;    // number of game update per second
	static final long UPDATE_PERIOD_NSEC = 1000000000L / UPDATES_PER_SEC;  // nanoseconds
	
	boolean gameover = false;
	boolean DEBUGGING = true;

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
		addMouseMotionListener((MouseMotionListener) new myMouseMotionListener());
	}
	
	public void gameStart() {
		Thread gameThread = new Thread() {
			@Override
			public void run() {
				gameLoop();
			}
		};
		gameThread.start();
	}
	
	public void gameLoop() {
		long beginTime, timeTaken, timeLeft;
		
		while(!gameover) {
			// Starting Time
			beginTime = System.nanoTime();
			
			repaint();
			
			// End Time and sleep to retain consistent FPS (Hopefully)
			timeTaken = System.nanoTime() - beginTime;
			timeLeft = (UPDATE_PERIOD_NSEC - timeTaken) / 1000000; // Converts to milliseconds
			try {
				Thread.sleep(timeLeft);
			} catch (InterruptedException e) {}
		}
	}
	
	public void checkHovered(MouseEvent e) {
		List<BaseObject> tempList = stack.getFirst().getObjects(); 
		
		int l, r, t, b;
		
		int x = e.getX();
		int y = e.getY();
		
		for(int i = 0; i < tempList.size(); i++) {
			BaseObject tempObj = tempList.get(i);
			l = tempObj.getLeftX();
			r = tempObj.getRightX();
			t = tempObj.getTopY();
			b = tempObj.getBottomY();
			
			if(tempObj instanceof Button) {
				tempObj.resetHovered();
				if(x > l && x < r && y > t && y < b) {
					tempObj.setHovered();
					break;
				}
			}
		}
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
	public class myKeyListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			stack.getFirst().getInput(e.getKeyCode());
		}
		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}
	}
	
	// Internal class for overriding a mouse motion listener
	public class myMouseMotionListener implements MouseMotionListener {
		@Override
		public void mouseDragged(MouseEvent arg0) {}
		@Override
		public void mouseMoved(MouseEvent arg0) {
			checkHovered(arg0);
		}
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
		// Takes all of the objects to be drawn (SHOULD be sorted
		// by draw priority) and displays based on their top left corner
		List<BaseObject> tempList = stack.getFirst().getObjects();
		for(int i = 0; i < tempList.size(); i++) {
			BaseObject tempObj = tempList.get(i);
			g.drawImage(tempObj.getImage(), tempObj.getLeftX(), tempObj.getTopY(), this);
			if(DEBUGGING) {
				g.setColor(Color.RED);
				g.drawRect(tempObj.getLeftX(), tempObj.getTopY(), tempObj.width(), tempObj.height());
			}
			
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
		
		manager.gameStart();
	}
}
