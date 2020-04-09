package game.environnement;

import game.personnage.Player;

public class Life extends Bonus {
	public void ApplyEffects(Player kevin) {
		kevin.addNbLifes();
	}
}
