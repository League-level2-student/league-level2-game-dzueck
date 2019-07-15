

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ObjectManager implements ActionListener{
	Runner runner;
	Killer killer;
	ArrayList<Food> foods = new ArrayList<>();
	GamePanel gamePanel;
	

	ObjectManager(TheGame theGame, GamePanel gamePanel){
		runner = new Runner(TheGame.WIDTH/2, TheGame.HEIGHT/2, 20, 20, theGame);
		killer = new Killer(0, 0, 40, 40, runner);
		this.gamePanel = gamePanel;
	}
	void update() {
		runner.move();
		killer.move();
	}
	
	void drawObjects(Graphics g) {
		runner.draw(g);
		killer.draw(g);
		for(Food food: foods) {
			food.draw(g);
		}
	}
	boolean checkCollision() {
		checkFoodCollision();
		if(runner.hitbox.intersects(killer.hitbox)) {
			return true;
		}
		
		return false;
	}
	private void checkFoodCollision() {
		for(int i = 0; i < foods.size(); i ++) {
			if(foods.get(i).hitbox.intersects(runner.hitbox)) {
				foods.remove(i);
				gamePanel.addScore();
			}
		}
	}
	private void spawnFood() {
		foods.add(new Food());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		spawnFood();
	}
	
	
	
}
