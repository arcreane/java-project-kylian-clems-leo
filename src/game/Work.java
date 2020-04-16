package game;

import java.awt.Color;
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
	private int height=110;
	private int speed;
	private int move = 100;
	private int count = 1;
	private int WIDTH=800;
	private int HEIGHT=800;
	private ArrayList <Rectangle> ennemies;
	private Random rand;
	private boolean isALive = true;
	BufferedImage carImage;
	Timer t;
	private Rectangle car;
	
	public Work() {
		try {
			carImage=ImageIO.read(new File("//Users/kylian/Documents/carImage.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t=new Timer(20, this);
		rand = new Random();
		ennemies = new ArrayList<Rectangle>();
		car = new Rectangle(105, HEIGHT-230, 90, 100);
		space = 105;
		speed = 2;
		
		addKeyListener(this);
		setFocusable(true);
		
		for(int i=0;i<6;i++) {
			addennemies(true);
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
			ennemies.add(new Rectangle(x, ennemies.get(ennemies.size()-1).y-500, Width, Height));
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.darkGray);
		g.fillRect(100, 0, 400, HEIGHT);
		
		//g.drawImage(carImage, car.x, car.y, null);
		
		g.setColor(Color.red);
		g.fillRect(car.x, car.y, car.width, car.height);
		
		g.setColor(Color.pink);
		g.drawLine(200, 0, 200, HEIGHT);
		g.setColor(Color.pink);
		g.drawLine(300, 0, 300, HEIGHT);
		g.setColor(Color.pink);
		g.drawLine(400, 0, 400, HEIGHT);
		
		g.setColor(Color.MAGENTA);
		
		for(Rectangle rect:ennemies) {
			
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
		
		if(isALive == false) {
			g.setColor(Color.white);
			g.drawString("PERDU", 250, 100);
		}
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Rectangle rect;
		count++;
		for(int i=0; i<ennemies.size();i++) {
			rect=ennemies.get(i);
			if(count%1000 == 0) {
				speed++;
				if(move<50) {
					move+=10;
				}
			}
			rect.y+=speed;
		}
		
		for(Rectangle r:ennemies) {
			if(r.intersects(car)) {
				isALive = false;
				car.y=r.y+height;
			}
		}
		
		
		for(int i=0;i<ennemies.size();i++) {
			rect=ennemies.get(i);
			if(rect.y+rect.height>HEIGHT) {
				ennemies.remove(rect);
				addennemies(false);
				
				
			}
		}
		
			repaint();
		
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
