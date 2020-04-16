package game.personnage;

import game.environnement.Laser;
import game.environnement.Shield;

public class Player extends Character {
	public int NbNewBullet;
	public Shield Shield;
	public Laser Laser;
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

	public Laser getLaser() {
		return Laser;
	}

	public void setLaser(Laser laser) {
		Laser = laser;
	}

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
}
