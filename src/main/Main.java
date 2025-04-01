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
	
	private static final long serialVersionUID = 1L;
	
	
	
	
	
		
	public static void main(String[] args) throws InterruptedException {
		
		Player player = new Player(); //
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
					case KeyEvent.VK_D:
						player.moveToRight();
					break;
					case KeyEvent.VK_A:
						player.moveToLeft();
					break;
					//a parte abaixo fecha o programa
					case KeyEvent.VK_ESCAPE:
						System.exit(0);
					break;
				}
				
			

			}});
		// gravidade
		while(true) {
			if (player.isFalling()) {
				player.gravityAction();
			}
			player.sleepToMove(30);
		}
						
	}

} 

//https://www.youtube.com/watch?v=Hlrm4n4fnIM&list=PLtchvIBq_CRTAwq_xmHdITro_5vbyOvVw&index=58

