package game.environnement;

import game.personnage.Player;

public class LifeBonus extends Bonus {
	int NbLifeToAdd;
	
	public LifeBonus(int nbLifeToAdd) {
		super();
		NbLifeToAdd = nbLifeToAdd;
	}
	
	public void ApplyEffects(Player kevin) {
	
		kevin.AddNbLifes(NbLifeToAdd);
		
	}
}
