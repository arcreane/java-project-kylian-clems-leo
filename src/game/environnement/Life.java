package game.environnement;

import game.personnage.Player;

public class Life extends Bonus {
	int NbLifeToAdd;
	
	public Life(int nbLifeToAdd) {
		super();
		NbLifeToAdd = nbLifeToAdd;
	}
	
	public void ApplyEffects(Player kevin) {
	
		kevin.addNbLifes(NbLifeToAdd);
		
		
		
	}
}
