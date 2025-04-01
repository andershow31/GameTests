package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Player extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x = 80, y = 80;
	private boolean isFalling = true;
	
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isFalling() {
		return isFalling;
	}
	public void setFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}
	public Player() {
		Dimension d =new Dimension(640, 480);
		super.setPreferredSize(d);		
	}
	public void gravityAction(){
		int heightFloor = getHeight()-30;
		while(y < heightFloor) {
			moveObj(0,1);
			sleepToMove(3);
		}
	}
	
	public void sleepToMove(int time){
		try {
			Thread.sleep(time);
		}catch(InterruptedException e) {
			System.out.println("Error on Thread.sleep: " + e.getMessage());
		}
		
	}
	public void moveToRight() { 
		moveObj(5,0);
		sleepToMove(3);
	}
	
	public void moveToLeft() { 
		moveObj(-5,0);
		sleepToMove(3);
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int widthScreen = getWidth();
		int heightScreen = getHeight();
		int heightFloor = heightScreen - 10;
		
		g.setColor(Color.BLACK);
        g.fillOval(x, y, 20, 20);
        ArrayList<Integer> objPosition = new ArrayList<>();
        objPosition.add(0);
        objPosition.add(heightFloor);
        objPosition.add(widthScreen);
        objPosition.add(heightFloor);
        g.drawLine(objPosition.get(0), objPosition.get(1), objPosition.get(2), objPosition.get(3));
	}
	//para o obj andar devemos usar o método repaint
	public void moveObj(int dx, int dy) {
		x += dx;
		y += dy;
		repaint();
	}
	
}
