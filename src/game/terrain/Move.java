package game.terrain;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.event.*;
import javax.swing.*;

public class Move implements Runnable {

JFrame frame;
int myX = 230;
int myY = 750;
Canvas canvas;
BufferStrategy bufferStrategy;
boolean running = true;

public Move() {
	frame = new JFrame("Pussy Runner");
	JPanel panel = (JPanel) frame.getContentPane();
	panel.setPreferredSize(new Dimension(500, 800));
	panel.setLayout(null);
	canvas = new Canvas();
	canvas.setBounds(0, 0, 500, 800);
	canvas.setIgnoreRepaint(true);
	panel.add(canvas);
	canvas.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent evt) {
			moveIt(evt);
		}
	});
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	frame.setResizable(false);
	frame.setVisible(true);
	canvas.createBufferStrategy(2);
	bufferStrategy = canvas.getBufferStrategy();
	canvas.requestFocus();
}
	public void run() {
		while (running = true) {
			Paint();
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
			}
		}
	}
	public static void main(String[] args) {
		Move ex = new Move();
		new Thread(ex).start();
	}
	public void Paint() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, 500, 800);
		Paint(g);
		bufferStrategy.show();
	}

	protected void Paint(Graphics2D g) {
		g.fillRect(myX, myY, 60, 30);
	}
	public void moveIt(KeyEvent evt) {
		switch (evt.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		if(myX == 10) {
			myX += 0;
		} else {
		myX -= 20;
		}
		break;
		case KeyEvent.VK_RIGHT:
		if(myX == 430) {
			myX += 0;
		} else {	
		myX += 20;
			}
		break;
	}
	
	
	
	}
}