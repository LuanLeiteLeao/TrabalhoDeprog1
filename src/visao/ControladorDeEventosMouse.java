package visao;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class ControladorDeEventosMouse implements MouseListener {
	private JanelaPrincipal janela;
	private InsercaoAandEdicaoPanel janela2;
	
	public ControladorDeEventosMouse(JanelaPrincipal jan,InsercaoAandEdicaoPanel jan2) {
		janela = jan;
		janela2=jan2;
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
		janela2.escreveNaTelaDeCadastro(janela.retornarLinhaDaTabela());
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
