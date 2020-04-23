package game;

import game.terrain.Map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import game.Work;

public class Program implements KeyListener {
	
	public static Map map;
	
	

	public static void main(String[] args) {
		JFrame app= new JFrame();
		start();
			
	}
	
	public static void start() {
		JFrame app= new JFrame();
		Work w = new Work();
		app.add(w);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(600, 700);
		app.setVisible(true);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key=e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_ENTER:
				start();
				break;
			default:
				break;
		}
	}
}
