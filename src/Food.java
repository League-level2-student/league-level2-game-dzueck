import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Food extends GameObject{
	boolean gotImage = false;
	BufferedImage foodImage;
	static Random random = new Random();
	boolean isActive = true;
	
	Food(){
		super(50 + random.nextInt(TheGame.WIDTH - 100),50 + random.nextInt(TheGame.HEIGHT - 100),15,15);
		setFoodImage();
	}
	private void setFoodImage() {
		try {
			foodImage = ImageIO.read(this.getClass().getResourceAsStream("food.png"));
			gotImage = true;
		} catch (Exception e) {
			
		}
	}
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(foodImage, (int) x, (int) y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect((int)x, (int)y, width, height);
		}
	}
}
