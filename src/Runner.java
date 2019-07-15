import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Runner extends GameObject{
	int speed = 2;
	boolean gotImage = false;
	BufferedImage runnerImage;
	TheGame theGame;
	
	Runner(int x, int y, int width, int height, TheGame theGame){
		super(x,y,width,height);
		this.theGame = theGame;
		setRunnerImage();
	}
	void move() {
		Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
		double runnerX = x + width/2;
		double runnerY = y + height/2;
		double movementAngle = Math.atan((runnerY - ((mouseLocation.getY()-theGame.getJFrame().getY())-30))/(runnerX - ((mouseLocation.getX()-theGame.getJFrame().getX())-7)));
		if(mouseLocation.getX()-theGame.getJFrame().getX() - runnerX -7  < 0) {
			movementAngle += Math.PI;
		}
		x += Math.cos(movementAngle) * speed;
		y += Math.sin(movementAngle) * speed;

		super.update();
	}
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(runnerImage, (int) x, (int) y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect((int)x, (int)y, width, height);
		}
	}
	private void setRunnerImage() {
		try {
			runnerImage = ImageIO.read(this.getClass().getResourceAsStream("runner.png"));
			gotImage = true;
		} catch (Exception e) {
			
		}
	}
}
