package controle;
import controle.Bruxo;
import visao.ControladorDeEventos;
import visao.JanelaPrincipal;

import java.util.List;


import modelo.ConexaoPostgres;

public class InteracoesBruxosNoDB {
	ConexaoPostgres interacao  = new ConexaoPostgres();
	
	
	
	public String savalr(Bruxo classeReferencia) 
	{
		
		return  interacao.inserirBruxo(classeReferencia); 
		
		
	
	}
	
	
	public String[][] tabelaDaPesquisa() {
		List<Bruxo> bruxosList = interacao.listBruxos();
		int lin = bruxosList.size();
		int colu =6;
		String[][] tabelaMatriz = new String[lin][colu];
		

		for(int i=0;i<lin;i++) {
			tabelaMatriz[i][0]= Integer.toString(bruxosList.get(i).getId());
			tabelaMatriz[i][1]=bruxosList.get(i).getNome();
			tabelaMatriz[i][2]=Boolean.toString(bruxosList.get(i).getSangue());
			tabelaMatriz[i][3]=bruxosList.get(i).getCasa();
			tabelaMatriz[i][4]=bruxosList.get(i).getAnimal_nome();
			tabelaMatriz[i][5]=bruxosList.get(i).getAnimal_tipo();
		}
		
		return tabelaMatriz;
			
				
		

		
		
	}
	
	
	
	
}
