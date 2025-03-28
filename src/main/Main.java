package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JPanel {
	
	
	/**
	 * 
	 */
	int x = 80, y = 80;
	private static final long serialVersionUID = 1L;
	private boolean isFalling = true;
	public Main() {
		Dimension d =new Dimension(640, 480);
		super.setPreferredSize(d);
		
	}
	
	public void gravityAction() throws InterruptedException {
		int heightFloor = getHeight()-30;
		while(y < heightFloor) {
			moveObj(0,1);
			Thread.sleep(3);
		}
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
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Main player = new Main(); //
		JFrame frameScreen = new JFrame(); //frame é a tela
		frameScreen.setContentPane(player);
		frameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameScreen.setLocationRelativeTo(frameScreen);
		frameScreen.pack();
		frameScreen.setLocation(400, 150);
		frameScreen.setVisible(true);
		//o método abaixo é usado para capturar tecla, não considera teclas especiais
		frameScreen.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode(); //pega letras do teclado
				switch (key) {
					case KeyEvent.VK_W:
						player.moveObj(0, -5);
					break;
					case KeyEvent.VK_S:
						player.moveObj(0, 5);
					break;
					case KeyEvent.VK_D:
						player.moveObj(5, 0);
					break;
					case KeyEvent.VK_A:
						player.moveObj(-5, 0);
					break;
					//a parte abaixo fecha o programa
					case KeyEvent.VK_ESCAPE:
						System.exit(0);
					break;
				}
				
			

			}});
		// gravidade
		while(true) {
			if (player.isFalling) {
				player.gravityAction();
			}
			Thread.sleep(30);
		}
						
	}

} 

//https://www.youtube.com/watch?v=Hlrm4n4fnIM&list=PLtchvIBq_CRTAwq_xmHdITro_5vbyOvVw&index=58

