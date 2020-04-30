package game.environnement;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.personnage.Player;

public class Shield extends GameElements {
	public int MaxDuration;
	public int CurentDuration;
	
	static private String imageSrc; 
	static private BufferedImage image; 
	
	public Shield(int x, int y)
	{
		super("src/shield.png", x, y);
	}
	
	

	public void TakeDamages() {
	}
	public void activate() {
		
	}
	public void ApplyEffects(Player kevin) {
		//Shield.activate();
		
	}
	


}
