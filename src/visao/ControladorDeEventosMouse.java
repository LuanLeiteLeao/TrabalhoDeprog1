package visao;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class ControladorDeEventosMouse implements MouseListener {
	private JanelaPrincipal janela;
	public ControladorDeEventosMouse(JanelaPrincipal jan) {
		this.janela = jan;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		//String[] retorno = janela.retornarLinhaDaTabela(); 
		janela.escreveNaTelaDeCadastro(janela.retornarLinhaDaTabela());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
