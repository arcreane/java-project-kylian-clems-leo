package game.personnage;

import game.environnement.GameElements;
import game.environnement.Shield;

public abstract class Character extends GameElements {
public int NbLifes;
	public Shield Shield;
	
	public void Moove() {
		
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
	public void MooveLeft() {
		
	}
	public void MooveRight() {
		
	}
	public abstract void Die();
	
}
