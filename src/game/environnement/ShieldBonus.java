package game.environnement;
import game.personnage.Player;

public class ShieldBonus extends Bonus {
	public int NewDuration;
	public void ApplyEffects() {
	}
	@Override
	public void ApplyEffects(Player kevin) {
		if(NbShields != 3) {
			NbShields += 1;
		}
		
	}
	
}
