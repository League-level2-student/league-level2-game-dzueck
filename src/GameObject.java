import java.awt.Rectangle;

public class GameObject {
	double x;
	double y;
	int width;
	int height;
	Rectangle hitbox;
	
	GameObject(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		hitbox = new Rectangle(x,y,width,height);
	}
	void update() {
		hitbox.x = (int) x;
		hitbox.y = (int) y;
	}
}
