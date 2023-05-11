package Jogo_da_Velha;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Jogo_da_Velha extends JPanel implements MouseListener {
	
	Font minhaFont = new Font("Arial", Font.BOLD, 80);
	int matriz[][];
	int jogador;
	int ganhador;
	
	public Jogo_da_Velha() {
		matriz = new int[3][3];
		jogador = 1;
		ganhador = 0;
		
		for(int linha = 0; linha < 3; linha++) {
			
			for (int coluna = 0; coluna < 3; coluna++) {
				System.out.print(matriz[linha][coluna]);
			}
				System.out.println();
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		
		for(int linha = 0; linha < 3; linha++) {
			
			System.out.println();
			for (int coluna = 0; coluna < 3; coluna++) {
				System.out.print(matriz[linha][coluna]);
			}
				System.out.println();
		}
		g.setFont(minhaFont);
		
		g.setColor(Color.gray);
		g.fillRect(0, 0, 600, 600);
		
		g.setColor(Color.black);
		g.drawLine(0, 200, 600, 200);
		g.drawLine(0, 400, 600, 400);
		g.drawLine(200, 0, 200, 600);
		g.drawLine(400, 0, 400, 600);
		
		for(int linha = 0; linha < 3; linha++) {
			
			for (int coluna = 0; coluna < 3; coluna++) {
				
				if (matriz[linha][coluna] == 1) {
					g.drawString("o", 75 + coluna*200, 125 + linha*200);
				} else if (matriz[linha][coluna] == 2) {
					g.drawString("x", 75 + coluna*200, 125 + linha*200);
				}
				
			}
			if (ganhador != 0) {
				g.setColor(Color.red);
				g.setFont(minhaFont);
				g.drawString("jogador " + ganhador + " win", 40, 300);
			}
			
			
			}
			
}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println(e.getX() + ", " + e.getY());
		int linha = e.getY()/200;
		int coluna = e.getX()/200;
		System.out.println("Clicou na linha: " + linha);
		System.out.println("Clicou na coluna: " + coluna);
		
		if (jogador == 1 && matriz[linha][coluna] == 0) {
			matriz[linha][coluna] = 1;
			jogador = 2;
		}else if (jogador == 2 && matriz[linha][coluna] == 0){
			matriz[linha][coluna] = 2;
			jogador = 1;
		}
		
		verificaGanhador();
		
		
		repaint();
	}
	
	private void verificaGanhador() {
		
		for(int linha = 0; linha < 3; linha++) {
				if(matriz[linha][0] == matriz[linha][1] && matriz[linha][0] == matriz[linha][2] && matriz[linha][0] != 0) {
					System.out.println("Houve ganhador!");
					ganhador = matriz[linha][0];
					break;
			}
			}

		for(int coluna = 0; coluna < 3; coluna++) {
				if(matriz[0][coluna] == matriz[1][coluna] && matriz[0][coluna] == matriz[2][coluna] && matriz[0][coluna] != 0) {
					System.out.println("Houve ganhador!");
					ganhador = matriz[0][coluna];
					break;
			}
			}
		
			if (matriz[0][0] == matriz [1][1] && matriz[0][0] == matriz [2][2] && matriz[0][0] != 0) {
				System.out.println("Houve ganhador!");
				ganhador = matriz[0][0];
			}
			if (matriz[0][2] == matriz [1][1] && matriz[0][2] == matriz [2][0] && matriz[0][2] != 0) {
				System.out.println("Houve ganhador!");
				ganhador = matriz[0][2];
			}
		}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
