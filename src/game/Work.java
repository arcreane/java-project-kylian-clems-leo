package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.environnement.GameElements;
import game.environnement.Shield;
import game.environnement.ShieldBonus;
import game.personnage.Enemy;
import game.personnage.Player;

public class Work extends JPanel implements ActionListener {

	private int space;
	private int width = 90;
	private int height = 100;
	private int speed;

	private int count = 1;

	private int score = 0;
	private ArrayList<GameElements> gameElement;
	private Random rand;
	private boolean isALive = true;
	BufferedImage bg;
	BufferedImage shieldImage;
	BufferedImage bonusImage;
	Timer t;
	private Player car;

	public Work() {

		car = new Player(105, 570);

		try {
			bg = ImageIO.read(new File("src/bg-game.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t = new Timer(20, this);
		rand = new Random();

		gameElement = new ArrayList<GameElements>();
		gameElement.add(car);
		fillGameElements();
		space = 105;
		speed = 3;
		addKeyListener(car);
		setFocusable(true);

		t.start();
	}

	public void fillGameElements() {
		int[] positionEnnemies = { 105, 205, 305, 405 };
		int select = rand.nextInt(4);
		// System.out.println("num�ro : " + select);
		int positionX = (int) Array.get(positionEnnemies, select);
		int x = 105;
		int y = 0;
		int Width = width;
		int Height = height;

		x = positionX;
		// Creation des ennemis
		for (int i = 0; i < 10; i++) {
			gameElement.add(new Enemy(x, y));// - 200 - (gameElement.size() * space) - 100));
		}
		// Creation des Shield
		for (int i = 0; i < 3; i++) {
			Shield tmp = new Shield(x, y - 200 - (gameElement.size() * space) - 100);
			gameElement.add(tmp);
			if (shieldImage == null)
				shieldImage = tmp.getImage();
		}
		// Creation des bombes
		for (int i = 0; i < 3; i++) {
			GameElements tmp = new ShieldBonus(x, y - 200 - (gameElement.size() * space) - 100);
			gameElement.add(tmp);
			if (bonusImage == null)
				bonusImage = tmp.getImage();
		}
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);

		g.drawImage(bg, 0, 0, null);

		car.Draw(g);

		g.setColor(Color.red);
		g.drawString("SPACE", 30, 30);
		g.drawString("ESCAPE", 25, 45);
		g.drawString("____________", 10, 60);
		g.drawString("SCORE : " + score, 15, 100);
		g.drawString("VITESSE : " + speed, 15, 125);

		g.drawString("RAMASSEZ", 15, 240);
		g.drawString("L'ICON", 25, 260);
		g.drawImage(shieldImage, 5, 265, null);
		g.drawString("REDUIT", 25, 335);
		g.drawString("LA VITESSE", 10, 350);

		g.drawString("RAMASSEZ", 15, 440);
		g.drawString("L'ICON", 25, 460);
		g.drawImage(bonusImage, 5, 465, null);
		g.drawString("DETRUIT", 25, 535);
		g.drawString("LES ENNEMIES", 5, 550);

		g.drawString("____________", 10, 640);
		g.drawString("DEV BY KCL", 15, 660);
		// g.setColor(Color.MAGENTA);

		for (GameElements rect : gameElement) {
			rect.Draw(g);
		}

		if (isALive == false) {
			g.setColor(Color.red);
			Font myFont = new Font("Courier New", 1, 24);
			g.setFont(myFont);
			g.drawString("GAME OVER", 240, 100);
			g.drawString("VOTRE SCORE : " + score, 200, 120);
			g.setColor(Color.white);
			Font myFont2 = new Font("Courier New", 1, 20);
			g.setFont(myFont2);
			g.drawString("Tapez entrer pour recommercer", 130, 160);
		}
	}

	public void actionPerformed(ActionEvent e) {
		for (GameElements gameElements : gameElement) {
			gameElements.Move();
			gameElements.interact(car);
		}

//		if (ennemies.isEmpty()) {
//			for (int j = 0; j < 3; j++) {
//				addennemies(true);
//			}
//		}
//
//		if (isALive == true) {
//			if (count % 1000 == 0) {
//				speed = speed + 2;
//				if (move < 50) {
//					move += 10;
//				}
//			}
//			if (count % 20 == 0) {
//				score = score + 1;
//			}
//
//		}
//
		repaint();
//
//		for (int i = 0; i < ennemies.size(); i++) {
//			rect = ennemies.get(i);
//			if (rect.y + rect.height > HEIGHT) {
//				ennemies.remove(rect);
//				if (isALive == true) {
//					for (int j = 0; j < 6; j++) {
//						addennemies(false);
//					}
//					int num = rand.nextInt(101);
//					// System.out.println(num);
//					if (num < 30) {
//						addbonus();
//
//					}
//					if (num <= 30) {
//
//						addshield();
//
//					}
//				}
//			}
//		}
	}

}