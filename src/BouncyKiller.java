import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class BouncyKiller extends GameObject{
	
	double speed = 2;
	double angle;
	Random random = new Random();

	
	BouncyKiller(int x, int y, int width, int height, double angle){
		super(x,y,width,height);
		this.angle = angle;
		}
	void move() {
		x += speed * Math.cos(angle);
		y -= speed * Math.sin(angle);
		if(x + width > TheGame.WIDTH) {
			if (angle % (2 * Math.PI) > Math.PI) {
				angle += Math.PI/4 + (1-random.nextInt(2)) * Math.PI/8;
			}
			else if (angle % (2 * Math.PI) < Math.PI) {
				angle -= Math.PI/4 + (1-random.nextInt(2)) * Math.PI/8;
			}
		}
		else if(x < 0) {
			if (angle % (2 * Math.PI) > Math.PI) {
				angle += Math.PI/4 + (1-random.nextInt(2)) * Math.PI/8;
			}
			else{
				angle -= Math.PI/4 + (1-random.nextInt(2)) * Math.PI/8;
			}
		}
		if(y + height > TheGame.HEIGHT) {
			if (angle % (2 * Math.PI) > Math.PI/2 && angle % (2 * Math.PI) < (3*Math.PI)/2) {
				angle += Math.PI/4 + (1-random.nextInt(2)) * Math.PI/8;
			}
			else {
				angle -= Math.PI/4 + (1-random.nextInt(2)) * Math.PI/8;
			}
		}
		else if(y < 0) {
			if (angle % (2 * Math.PI) > Math.PI) {
				angle += Math.PI/4 + (1-random.nextInt(2)) * Math.PI/8;
			}
			else if (angle % (2 * Math.PI) < Math.PI) {
				angle -= Math.PI/4 + (1-random.nextInt(2)) * Math.PI/8;
			}
		}
		
		super.update();
	}
	
	void draw(Graphics g) {
		g.setColor(new Color(176, 0, 0));
		g.fillRect((int)x, (int)y, width, height);
	}
}
