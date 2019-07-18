

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class ObjectManager implements ActionListener{
	Runner runner;
	Killer killer;
	ArrayList<BouncyKiller> bKillers = new ArrayList<>();
	ArrayList<Food> foods = new ArrayList<>();
	GamePanel gamePanel;
	int spawnDelay = 4;
	int counter = 0;
	int startDelay = 120 * 3;
	boolean started = false;
	Random random = new Random();
	

	ObjectManager(TheGame theGame, GamePanel gamePanel){
		runner = new Runner(TheGame.WIDTH/2, TheGame.HEIGHT/2, 20, 20, theGame);
		killer = new Killer(0, 0, 40, 40, runner);
		bKillers.add(new BouncyKiller(0, 0, 25, 25, Math.PI/4));
		this.gamePanel = gamePanel;
	}
	void update() {
		if(counter == startDelay || started) {
			if(started == false) {
				counter = 0;
				started = true;
			}
			runner.move();
			killer.speed = 1 + .05 * gamePanel.score;
			killer.move();
			for(BouncyKiller bKiller: bKillers) {
				bKiller.move();
			}
		}
		else {
			counter++;
		}
	}
	
	void drawObjects(Graphics g) {
		runner.draw(g);
		killer.draw(g);
		for(Food food: foods) {
			food.draw(g);
		}
		for(BouncyKiller bKiller: bKillers) {
			bKiller.draw(g);
		}
	}
	boolean checkCollision() {
		checkFoodCollision();
		if(runner.hitbox.intersects(killer.hitbox)) {
			return true;
		}
		for(BouncyKiller bKiller: bKillers) {
			if(bKiller.hitbox.intersects(runner.hitbox)) {
				return true;
			}
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
		if(counter == spawnDelay) {
			bKillers.add(new BouncyKiller(0, 0, 25, 25, Math.PI/4 + (10-random.nextInt(20)) * Math.PI/(8 * 10)));
			counter = 0;
		}
		else {
			counter++;
		}
	}
	
	
	
}
