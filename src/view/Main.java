package view;

import controller.RedesController;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		int escolha = 0;
		RedesController Rcontrol = new RedesController();
		String so = System.getProperty("os.name");
		while(escolha!=3){
			escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opcao:\n\n1 - Configuracoes de IPv4\n2 - Ping com o Google\n3 - Sair")); 
			switch(escolha){
				case 1: Rcontrol.Ip(so); break;
				case 2: Rcontrol.Ping(so); break;
				case 3: JOptionPane.showMessageDialog(null, "Aplicacao finalizada"); break;
				default: JOptionPane.showMessageDialog(null, "Opcao Invalida"); break;
			}
		}
	}

}
