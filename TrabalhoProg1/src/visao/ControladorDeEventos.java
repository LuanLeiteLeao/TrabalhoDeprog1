package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.lang.invoke.SwitchPoint;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controle.InteracoesBruxosNoDB;

public class ControladorDeEventos implements ActionListener {
	private JanelaPrincipal janela;
	private InteracoesBruxosNoDB bancoDeDados;
	public ControladorDeEventos(JanelaPrincipal jan) {
		this.janela = jan;
		 bancoDeDados = new InteracoesBruxosNoDB();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bt =(JButton) e.getSource();
		
		
		
		if(bt.getText().equalsIgnoreCase("Salvar")) {
			

	
			String mesangem =bancoDeDados.savalr(janela.getNome(), janela.getGenetica(),
			janela.getCasa(),janela.getNomeAnimal(), janela.getAnimalTipo());				
			janela.criaTabel(bancoDeDados.tabelaDaPesquisa());
			
			janela.escreveNaTelaDeCadastro(null);
			JOptionPane.showMessageDialog(null, mesangem);
					

				
			
		}
	}

	
	
	
	
	
	
}
