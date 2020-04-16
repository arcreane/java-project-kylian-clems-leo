package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Work extends JPanel implements ActionListener {
	
	private int space;
	private int width=90;
	private int height=110;
	private int speed;
	private int WIDTH=800;
	private int HEIGHT=800;
	private ArrayList <Rectangle> ennemies;
	private ArrayList <Rectangle> bonus;
	private Random rand;
	Timer t;
	private Rectangle car;
	
	public Work() {
		t=new Timer(20, this);
		rand = new Random();
		ennemies = new ArrayList<Rectangle>();
		bonus = new ArrayList<Rectangle>();
		car = new Rectangle(WIDTH/4-100, HEIGHT-100, width, height);
		space = 105;
		speed = 4;
		
		for(int i=0;i<50;i++) {
			addennemies(true);
		}
		for(int i=0;i<10;i++) {
			addBonus(true);
		}
		
		t.start();
	}
	
	public void addennemies(boolean first) {
		int [] positionEnnemies = {105,205,305,405};
		int select=rand.nextInt(4);
		System.out.println("numéro : " + select);
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
			ennemies.add(new Rectangle(x, y-100-(ennemies.size()*space), Width, Height));
		} else {
			ennemies.add(new Rectangle(x, ennemies.get(ennemies.size()-1).x+space, Width, Height));
		}
		
	}
	public void addBonus(boolean first) {
		int [] positionBonus = {105,205,305,405};
		int select=rand.nextInt(4);
		System.out.println("numéro : " + select);
		int positionX = (int)Array.get(positionBonus, select);
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
			bonus.add(new Rectangle(x, y-100-(bonus.size()*space), Width, Height));
		} else {
			bonus.add(new Rectangle(x, bonus.get(bonus.size()-1).x+space, Width, Height));
		}
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.darkGray);
		g.fillRect(100, 0, 400, HEIGHT);
		g.setColor(Color.red);
		g.fillRect(105, HEIGHT-230, 90, 80);
		g.setColor(Color.pink);
		g.drawLine(200, 0, 200, HEIGHT);
		g.setColor(Color.pink);
		g.drawLine(300, 0, 300, HEIGHT);
		g.setColor(Color.pink);
		g.drawLine(400, 0, 400, HEIGHT);
		
		g.setColor(Color.blue);
		
		for(Rectangle rect:ennemies) {
			
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
		
		g.setColor(Color.green);
		for(Rectangle rect:bonus) {
			
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Rectangle rect;
		for(int i=0; i<ennemies.size();i++) {
			rect=ennemies.get(i);
			rect.y+=speed;
		}
		
		for(int i=0; i<bonus.size();i++) {
			rect=bonus.get(i);
			rect.y+=speed;
		}
		repaint();
		
	}
	
}
