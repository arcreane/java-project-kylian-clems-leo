package game.environnement;
import java.io.File;

import javax.imageio.ImageIO;

import game.personnage.Player;

public class ShieldBonus extends Bonus {
	public int NewDuration;
	public ShieldBonus(int x, int y)
	{
		super("src/bonus-more.png", x,y);
	}
	
	@Override
	protected void ApplyEffects(Player car) {
		// TODO Auto-generated method stub
		
	}
}
