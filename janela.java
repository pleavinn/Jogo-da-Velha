package Jogo_da_Velha;

import javax.swing.JFrame;

public class janela {
 
	public static void main(String[] args) {
		
		JFrame janela = new JFrame("Jogo da Velha");
		janela.setSize(600, 630);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		Jogo_da_Velha velha = new Jogo_da_Velha();
		velha.setBounds(0, 0, 600, 600);
		janela.add(velha);
		
		janela.addMouseListener(velha);
	}
}