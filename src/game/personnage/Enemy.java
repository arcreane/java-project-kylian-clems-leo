package game.personnage;

import game.environnement.Shield;

public class Enemy extends Character {
	public int NbLifes;
	public Shield Shield;
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
	
}
