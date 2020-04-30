package game.personnage;

import java.awt.Rectangle;
import java.io.File;

import javax.imageio.ImageIO;

import game.environnement.Shield;

public class Enemy extends Character {
	public int NbLifes;
	public Shield Shield;

	public Enemy(int x, int y) {
		super("src/ennemy.png", x, y);
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

	public void Die() {
	}
	
	public void interact(Player car) {
//		if(drawRectange.intersects(car.drawRectange))
//		{
//			car.Die();
//		}
		
	}

}
