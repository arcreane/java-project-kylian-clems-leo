package game.environnement;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.personnage.Player;

public class GameElements /*extends Rectangle*/{
	//public Rectangle Shape;

	public int m_iX, m_iY;

	public Object DisplayManagement;
	protected BufferedImage displayImage;
	protected Rectangle drawRectange;
	protected int width = 90, height = 100;
	protected GameElements(String src, int x, int y)
	{
		try {
			displayImage=ImageIO.read(new File(src));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drawRectange = new Rectangle(x, y, width, height);
		m_iX = x;
		m_iY = y;
	}
	
	public void Draw(Graphics g)
	{
		g.drawImage(displayImage, m_iX, m_iY, null);
	}
	

	public BufferedImage getImage() {
		return displayImage;
	}
	
	public void Move()
	{
		m_iY++;
	}

	public void interact(Player car) {
		// TODO Auto-generated method stub
		
	}
}
 