package game;

import game.terrain.Map;

import javax.swing.JFrame;

import game.Work;

public class Program {
	
	public static Map map;

	public static void main(String[] args) {
		
		JFrame app= new JFrame();
		Work w = new Work();
		app.add(w);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(600, 700);
		app.setVisible(true);
			
	}
}
