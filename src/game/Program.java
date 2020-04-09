package game;

import game.terrain.Map;

public class Program {
	public static Map map;

	public static void main(String[] args) {
		var test = 1;
		System.out.println(test);
		
		map = new Map();
		
		map.draw();
	}
}
