package game.terrain;

import game.environnement.GameElements;

public class Map {
	
	
	public GameElements elements;
	char brush;
	int height,width;
	
	public Map() {
		
	}
	
	public void draw() {
		
		
		brush = '.';
		height = 50;
		width = 40;
		
		for (int i = 0; i < height; i++) {
			System.out.print(brush);
			for (int k = 1; k < width - 1; k++) {
				
					if(k%10 == 0) {
						if(i == 0 || i == 49) {
							System.out.print(" ");
						} else {
							System.out.print("|");
						}
						
					} else {
						System.out.print(" ");
					}
				
				
				
				if (i == 0 || i == (height - 1)) {
					System.out.print(brush);

				} else {
					System.out.print(" ");

				}
			}
			System.out.print(" ");
			System.out.print(brush);
			System.out.print("\n");
		}
	}
}
