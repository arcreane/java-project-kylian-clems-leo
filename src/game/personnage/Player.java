package game.personnage;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.imageio.ImageIO;

import game.Work;
import game.environnement.Shield;

public class Player extends Character implements ActionListener, KeyListener{
	public int NbNewBullet;
	public Shield NbShields;
	public Shield Shield;
	private int WIDTH = 800;
	//public Laser Laser;
	private int move = 100;
	
	public Player(int X, int Y)
	{
		super( "src/car.png", X, Y);

		
	}
	public void Shoot() {
	}
	
	public int getNbLifes() {
		return NbLifes;
	}

	public void setNbLifes(int nbLifes) {
		NbLifes = nbLifes;
	}

	public Shield getShield() {
		return Shield;
	}

	public void setShield(Shield shield) {
		Shield = shield;
	}

//	public Laser getLaser() {
//		return Laser;
//	}
//
//	public void setLaser(Laser laser) {
//		Laser = laser;
//	}

	public void Die() {
	}
	
	public void AddNbLifes(int LifePoint) {
		if(NbLifes != 3) {
			NbLifes += 1;
		}else {
			NbLifes += 0;
		}
	}
	
	public void AddNbLaser(int LaserNumber) {
		if(NbNewBullet == 3) {
			//NewBiglaser += 1;
		}else {
			NbNewBullet += 0;
		}
	}


	@Override
	public void Move() {}
	
	public void moveleft() {
		
		if (m_iX + move < WIDTH / 2 + 5) {
		} else {
			m_iX -= move;
		}
	}

	public void moveright() {
		if (m_iX + move > WIDTH / 2 + 5) {
		} else {
			m_iX += move;
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
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_RIGHT:
			moveright();
			break;
		case KeyEvent.VK_LEFT:
			moveleft();
			break;
		case KeyEvent.VK_ENTER:
			new Work();
			break;
		default:
			break;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
