import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener, KeyListener{
	int gameState = 0;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	final int INSTRUCTIONS = 3;
	final Font titleFont;
	Timer frameRate;
	Timer foodSpawnRate;
	TheGame frame;
	int score = 0;

	ObjectManager objectManager;
	
	
	
	
	GamePanel(TheGame theGame){
		objectManager = new ObjectManager(theGame, this);
		frameRate = new Timer(1000/120, this);
		foodSpawnRate = new Timer(3000, objectManager);
		titleFont = new Font("Arial", Font.PLAIN, 22);
		frameRate.start();
		frame = theGame;
		
		
	}
	@Override
	public void paintComponent(Graphics g){
		switch(gameState) {
		case(MENU):
			drawMenu(g);
			break;
		case(GAME):
			drawGame(g);
			break;
		case(END):
			drawEnd(g);
			break;
		case(INSTRUCTIONS):
			drawInstructions(g);
			break;
		}
	}
	void addScore() {
		score++;
	}
	void drawMenu(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0,TheGame.WIDTH,TheGame.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Running Failure", 5, 100);
		g.drawString("Press enter to play", 5, 200);
		g.drawString("Space for instructions", 5, 300);
	}
	void drawGame(Graphics g) {
		g.setColor(new Color(0,155,0));
		g.fillRect(0,0,TheGame.WIDTH,TheGame.HEIGHT);
		objectManager.drawObjects(g);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Score: " + score, 5, 40);
	}
	void drawEnd(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0,TheGame.WIDTH,TheGame.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("You Failed", 5, 100);
		g.drawString("That was inevitable anyways", 5, 200);
		g.drawString("Press enter to fail again", 5, 300);
		if(score == 0) {
			g.drawString("REALLY YOU SCORED 0!?!??!?!?!? ", 5, 400);
			g.drawString("I KNEW YOU WERE GOING TO FAIL BUT COME ON!!!!!", 5, 423);
		}
		}
	void drawInstructions(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0,TheGame.WIDTH,TheGame.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Place your mouse on the screen to move the runner", 5, 100);
		g.drawString("Collect the aliens", 5, 200);
		g.drawString("Avoid the nerd square", 5, 300);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(gameState == GAME) {
			objectManager.update();
			if(objectManager.checkCollision()) {
				gameState = END;
			}
		}
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("at least i tried");
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(gameState == MENU) {
				gameState = GAME;
				foodSpawnRate.start();
			}
			else if (gameState == INSTRUCTIONS) {
				gameState = MENU;
			}
			else if (gameState == END) {
				gameState = MENU;
				objectManager = new ObjectManager(frame, this);
				foodSpawnRate = new Timer(3000, objectManager);
				score = 0;
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(gameState == MENU) {
				gameState = INSTRUCTIONS;
			}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
