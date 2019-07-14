import javax.swing.JFrame;

public class TheGame {
	JFrame frame;
	GamePanel gamePanel;
	public static final int WIDTH = 1500;
	public static final int HEIGHT = 1500;
	
	TheGame(){
		frame = new JFrame();
		gamePanel = new GamePanel();
	}
	void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(gamePanel);
		
	}
	public static void main(String[] args) {
		TheGame runner = new TheGame();
		runner.setup();
		

	}

}
