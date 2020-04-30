package game.environnement;

import game.personnage.Player;

public abstract class Bonus extends GameElements   {

	
	protected Bonus()
	{
		super("",0,0);
	}
	protected Bonus(String src, int x, int y) {
		super(src, x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void interact(Player car) {
		if(drawRectange.intersects(car.drawRectange))
		{
			ApplyEffects(car);
		}
		
	}
	protected abstract void ApplyEffects(Player car);
}
