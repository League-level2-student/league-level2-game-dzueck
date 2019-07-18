import java.awt.Color;
import java.awt.Graphics;

public class Killer extends GameObject {
	Runner runner;
	public double speed = 1;
	
	Killer(int x, int y, int width, int height, Runner runner){
		super(x,y,width,height);
		this.runner = runner;
	}
	void move() {
		
		double killerX = x + width/2;
		double killerY = y + height/2;
		double runnerX = runner.x + runner.width/2;
		double runnerY = runner.y + runner.height/2;
		double movementAngle = Math.atan((killerY - runnerY)/(killerX - runnerX));
		if(runnerX - killerX < 0) {
			movementAngle += Math.PI;
		}
		x += Math.cos(movementAngle) * speed;
		y += Math.sin(movementAngle) * speed;

		super.update();
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x, (int)y, width, height);
	}
}
