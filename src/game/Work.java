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

public class Work extends JPanel implements ActionListener, KeyListener {
	
	private int space;
	private int width=90;
	private int height=100;
	private int speed;
	private int move = 100;
	private int count = 1;
	private int WIDTH=800;
	private int HEIGHT=800;
	private int score = 0;
	private ArrayList <Rectangle> ennemies;
	private ArrayList <Rectangle> bonus;
	private ArrayList <Rectangle> shield;
	private Random rand;
	private boolean isALive = true;
	BufferedImage carImage;
	BufferedImage ennemie;
	BufferedImage bg;
	BufferedImage bonusImage;
	BufferedImage shieldImage;
	Timer t;
	private Rectangle car;
	
	public Work() {
		try {
			
			carImage=ImageIO.read(new File( "src/car.png"));
			ennemie=ImageIO.read(new File("src/ennemy.png"));
			shieldImage=ImageIO.read(new File("src/shield.png"));
			bg=ImageIO.read(new File("src/bg-game.png"));
			bonusImage = ImageIO.read(new File("src/bonus-more.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t=new Timer(20, this);
		rand = new Random();
		
		ennemies = new ArrayList<Rectangle>();
		bonus = new ArrayList<Rectangle>();
		shield = new ArrayList<Rectangle>();
		car = new Rectangle(105, HEIGHT-230, width, height);
		space = 105;
		speed = 3;
		
		addKeyListener(this);
		setFocusable(true);
		
		for(int i=0; i<6; i++) {
			
			addennemies(true);
			
		}

		t.start();
	}
	
	
	public void addbonus() {
		int [] positionEnnemies = {105,205,305,405};
		int select=rand.nextInt(4);
		//System.out.println("numéro : " + select);
		int positionX = (int)Array.get(positionEnnemies, select);
		int x=0;
		int y=0;
		int Width=width;
		int Height=height;
		
		if(positionX == 105) {
			x=105;
		} else if(positionX == 205) {
			x=205;
		} else if(positionX == 305) {
			x=305;
		} else if(positionX == 405) {
			x=405;
		} else {
			
		}

			bonus.add(new Rectangle(x, y-100-(bonus.size()*space), Width, 50));
		
	}
	
	public void addshield() {
		int [] positionEnnemies = {105,205,305,405};
		int select=rand.nextInt(4);
		//System.out.println("numéro : " + select);
		int positionX = (int)Array.get(positionEnnemies, select);
		int x=0;
		int y=0;
		int Width=width;
		int Height=height;
		
		if(positionX == 105) {
			x=105;
		} else if(positionX == 205) {
			x=205;
		} else if(positionX == 305) {
			x=305;
		} else if(positionX == 405) {
			x=405;
		} else {
			
		}

			shield.add(new Rectangle(x, y-100-(shield.size()*space), Width, 50));
		
	}
	
	
	public void addennemies(boolean first) {
		int [] positionEnnemies = {105,205,305,405};
		int select=rand.nextInt(4);
		//System.out.println("numéro : " + select);
		int positionX = (int)Array.get(positionEnnemies, select);
		int x=0;
		int y=0;
		int Width=width;
		int Height=height;
		
		if(positionX == 105) {
			x=105;
		} else if(positionX == 205) {
			x=205;
		} else if(positionX == 305) {
			x=305;
		} else if(positionX == 405) {
			x=405;
		} else {
			
		}
		
		if(first) {
			ennemies.add(new Rectangle(x, y-200-(ennemies.size()*space), Width, 90));
		} else {
			ennemies.add(new Rectangle(x, ennemies.get(ennemies.size()-1).y-250, Width, 90));
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		
		g.drawImage(bg, 0, 0, null);
		
		g.drawImage(carImage, car.x, car.y, null);
		
		g.setColor(Color.red);
		g.drawString("SPACE", 30, 30);
		g.drawString("ESCAPE", 25, 45);
		g.drawString("____________", 10, 60);
		g.drawString("SCORE : " + score, 15, 100);
		g.drawString("VITESSE : " + speed, 15, 125);
		
		
		g.drawString("RAMASSEZ" , 20, 340);
		g.drawString("L'ICON" , 30, 360);
		g.drawImage(bonusImage, 10, 365, null);
		g.drawString("REDUIT" , 30, 435);
		g.drawString("LA VITESSE" , 20, 450);

		
		g.drawString("____________", 10, 640);
		g.drawString("DEV BY KCL" , 15, 660);
		//g.setColor(Color.MAGENTA);
		
		for(Rectangle rect:bonus) {
			g.drawImage(bonusImage, rect.x,rect.y, null);
		}
		
		for(Rectangle rect:shield) {
			g.drawImage(shieldImage, rect.x,rect.y, null);
		}
		
		for(Rectangle rect:ennemies) {
			g.drawImage(ennemie, rect.x, rect.y, null);
			//g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}

		if(isALive == false) {
			g.setColor(Color.red);
			Font myFont = new Font ("Courier New", 1, 24);
			g.setFont (myFont);
			g.drawString("GAME OVER", 240, 100);
			g.drawString("VOTRE SCORE : " + score, 200, 120);
			g.setColor(Color.white);
			Font myFont2 = new Font ("Courier New", 1, 20);
			g.setFont (myFont2);
			g.drawString("Tapez entrer pour recommercer", 130, 160);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Rectangle rect;
		count += 1;
		for(int i=0; i<ennemies.size();i++) {
			rect=ennemies.get(i);
 			rect.y+=speed;
		}
		for(int i=0; i<bonus.size();i++) {
			rect=bonus.get(i);
 			rect.y+=speed;
		}
		
		for(int i=0; i<shield.size();i++) {
			rect=shield.get(i);
			rect.y+=speed;
 			
		}
		
		
		for(Rectangle r:ennemies) {
			if(r.intersects(car)) {	
				isALive = false;
				car.y=r.y+height;	
			}
		}
		
		for(Rectangle r:bonus) {
			if(r.intersects(car)) {
				speed = 3;
			}
		}
		
		for(Rectangle r:shield) {
			if(r.intersects(car)) {
			
				ennemies = new ArrayList<Rectangle>();
				
			}
			
		}
		if(ennemies.isEmpty()) {
			for(int j =0; j<6; j++) {
				addennemies(true);
			}
		}
		
		if(isALive == true ) {
			if(count%1000 == 0) {
				speed =  speed + 2;
				if(move<50) {
					move += 10;
				}
			}
			if(count%20 == 0) {
				score = score + 1;
			}
			
		}
		
		repaint();
		
		
		for(int i=0;i<ennemies.size();i++) {
			rect=ennemies.get(i);
			if(rect.y+rect.height>HEIGHT) {
				ennemies.remove(rect);
				if(isALive == true) {
					for(int j =0; j<6; j++) {
						addennemies(false);
					}
					int num = rand.nextInt(101);
					//System.out.println(num);
					if(num == 0) {
						addbonus();
					
					}
					if(num <= 70) {
		
						addshield();
						
					}
				}
			}
		}
	}

	
	public void moveleft() {
		if(car.x-move<WIDTH/4-105) {
			
		} else {
			car.x-=move;
		}
	}
	
	public void moveright() {
		if(car.x+move>WIDTH/2+5) {
			
		} else {
			car.x+=move;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key=e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_RIGHT:
				moveright();
				break;
			case KeyEvent.VK_LEFT:
				moveleft();
				break;
			default:
				break;
		}
	}

	
	

}