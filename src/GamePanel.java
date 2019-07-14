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
	
	
	
	
	GamePanel(){
		frameRate = new Timer(1000/120, this);
		titleFont = new Font("Arial", Font.PLAIN, 22);
		
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
	void drawMenu(Graphics g) {
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Running Failure", 5, 100);
		g.drawString("Press enter to play", 5, 200);
		g.drawString("Space for instructions", 5, 300);
		System.out.println("happening all the time");
	}
	void drawGame(Graphics g) {
		
	}
	void drawEnd(Graphics g) {
		
	}
	void drawInstructions(Graphics g) {
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Place your mouse on the screen to move the runner", 5, 100);
		g.drawString("Collect the aliens", 5, 200);
		g.drawString("Avoid the nerd square", 5, 300);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("kill me");
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
			}
			else if (gameState == INSTRUCTIONS) {
				gameState = MENU;
			}
			else if (gameState == END) {
				gameState = MENU;
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
