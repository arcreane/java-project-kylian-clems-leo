package game.environnement;

import game.personnage.Player;

public class LaserBonus extends Bonus {
	int NbNewBullet;
	
	public LaserBonus(int nbLaserToAdd) {
		super();
		NbNewBullet = nbLaserToAdd;
	}
	
	public void ApplyEffects(Player kevin) {
		kevin.AddNbLaser(NbNewBullet);
	}
	
}
