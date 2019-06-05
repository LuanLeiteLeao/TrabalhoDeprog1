package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.invoke.SwitchPoint;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controle.Bruxo;
import controle.InteracoesBruxosNoDB;

public class ControladorDeEventos implements ActionListener {
	private InteracoesBruxosNoDB bancoDeDados = new InteracoesBruxosNoDB();
	private Bruxo modeloDeClasse;
	private InsercaoAandEdicaoPanel jan;
	public ControladorDeEventos(InsercaoAandEdicaoPanel panelInserir) {
		
		
		this.jan=panelInserir ;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bt =(JButton) e.getSource();
		
		
		
		if(bt.getText().equalsIgnoreCase("Salvar")) {
			
			Bruxo B = jan.getBruxo();
	
			String mesangem =bancoDeDados.savalr(B);
			JOptionPane.showMessageDialog(null, mesangem);
			jan.AtualizaTabela();		

				
			
		}
		

		if(bt.getText().equalsIgnoreCase("Excluir")) {
			
			//String[] id = janela.retornarLinhaDaTabela();
			
	
			//String mesangem =bancoDeDados.dedetar(Integer.parseInt(id[0]));
					
			//JOptionPane.showMessageDialog(null, mesangem);
				
			
		}
	}

	
	

	
	
	
}
