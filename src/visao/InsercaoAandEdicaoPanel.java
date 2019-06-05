package visao;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import controle.Bruxo;
import net.miginfocom.swing.*;

public class InsercaoAandEdicaoPanel extends JPanel{
	
	
	private static final String FONTE = "Courier New";
	private static final int TAM= 16;
	
	private JTextField escreverNomeDoAnimal;
	private JComboBox casas;
	private JCheckBox genetica;
	private JTextField escreverNomeDoBruxo ;
	private JLabel nomeDobruxo;
	private JButton btnCancelar;
	private JButton btnSalvar;
	private JTextField escreveIdade;
	private JLabel idade;
	private JComboBox animalTipo;
	private JLabel apelidoDoAnimal;
	private JanelaPrincipal janelaPrincipal;
	
	public InsercaoAandEdicaoPanel(JTabbedPane tabbedPanePrincipal,JanelaPrincipal janela) {
		
		
		tabbedPanePrincipal.addTab("Cadastrar", null, this, null);
		setLayout(new MigLayout("", "[27px][194px,grow][][][][][][grow][][][][][grow]", "[14px][][][][][][][]"));
		
		this.janelaPrincipal =janela;
		
		
			inicializa();
			
			 
		
	}


	
	private void inicializa() {
		nomeDoBruxo(this);
	
	
	
		escreverNomeDoBruxo(this);
	
	
		genetica(this);
	
	
		casa(this);
	
	
		apelidoAnimal(this);
	
	
		excreverNomrAnimal(this);
	
	
	
		animalTipo(this);
	
	
		idade(this);
	
	
		escreverIdade(this);
	
	
		salvar(this);
		
	
	
		cancelar(this);
	}
	
	
	private void cancelar(JPanel panelInserir) {
		btnCancelar = new JButton("Cancelar");			
		//btnCancelar.addActionListener(new ControladorDeEventos(getBruxo()));
		panelInserir.add(btnCancelar, "cell 4 7");
	}
	
	
	private void salvar(JPanel panelInserir) {
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ControladorDeEventos(this));
		panelInserir.add(btnSalvar, "cell 0 7");
	}
	
	
	private void escreverIdade(JPanel panelInserir) {
		escreveIdade = new JTextField();
		panelInserir.add(escreveIdade, "cell 7 1,alignx right");
		escreveIdade.setColumns(10);
	}
	
	
	private void idade(JPanel panelInserir) {
		idade = new JLabel("Idade");
		panelInserir.add(idade, "cell 5 1");
	}
	
	
	private void animalTipo(JPanel panelInserir) {
        animalTipo = new JComboBox();
		animalTipo.setModel(new DefaultComboBoxModel(new String[] {"Gato", "Fenix", "Coruja", "Aranha", "Coelho ", "Sapo ", "Rato"}));
		panelInserir.add(animalTipo, "cell 4 1,growx");
	}
	
	
	private void excreverNomrAnimal(JPanel panelInserir) {
		escreverNomeDoAnimal = new JTextField();
		escreverNomeDoAnimal.setFont(new Font(FONTE, Font.PLAIN, TAM));
		panelInserir.add(escreverNomeDoAnimal, "cell 1 1,growx");
		escreverNomeDoAnimal.setColumns(10);
	}
	
	
	private void apelidoAnimal(JPanel panelInserir) {
		apelidoDoAnimal = new JLabel("Apelido do Animal");
		panelInserir.add(apelidoDoAnimal, "cell 0 1,alignx trailing");
	}
	
	
	private void casa(JPanel panelInserir) {
		casas = new JComboBox();
		casas.setModel(new DefaultComboBoxModel(new String[] {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"}));
		casas.setBackground(new Color(255, 255, 255));
		panelInserir.add(casas, "cell 7 0,growx");
	}
	
	
	private void genetica(JPanel panelInserir) {
		genetica = new JCheckBox("Mesti\u00E7o");
		panelInserir.add(genetica, "cell 4 0");
	}
	
	
	private void escreverNomeDoBruxo(JPanel panelInserir) {
		escreverNomeDoBruxo = new JTextField();
		escreverNomeDoBruxo.setFont(new Font(FONTE, Font.PLAIN, TAM));
		panelInserir.add(escreverNomeDoBruxo, "cell 1 0,growx,aligny top");
		escreverNomeDoBruxo.setColumns(10);
	}
	
	
	private void nomeDoBruxo(JPanel panelInserir) {
		nomeDobruxo = new JLabel("Nome");
		panelInserir.add(nomeDobruxo, "cell 0 0,alignx center,aligny center");
	}	
	
	

	public void escreveNaTelaDeCadastro(Bruxo classeRefeRencia) {
		//"Nome", "Genetica", "Casa", "Nome do Animal","Raça do Animal"
		
		escreverNomeDoBruxo.setText(classeRefeRencia.getNome());
		genetica.setSelected(classeRefeRencia.getSangue());
		casas.setSelectedIndex(retornaPocaoComboBox(classeRefeRencia.getCasa(),casas));
		escreverNomeDoAnimal.setText(classeRefeRencia.getAnimal_nome());
		animalTipo.setSelectedIndex(retornaPocaoComboBox(classeRefeRencia.getAnimal_tipo(),animalTipo));
	    
	
	}
	
	
	private int retornaPocaoComboBox(String nome,JComboBox comboBox) {
		
		ComboBoxModel model = comboBox.getModel();
		
		
		
		for (int i = 0;i<model.getSize(); i++) {
				

			if (model.getElementAt(i).equals(nome)) {
				return i;
			}
		}
		
		
		return 0;
	}
	
	public Bruxo getBruxo() {
		Bruxo classeReferencia = new Bruxo();
		
		classeReferencia.setId(null);
		classeReferencia.setNome(escreverNomeDoBruxo.getText());
		classeReferencia.setSangue(genetica.isSelected());
		classeReferencia.setCasa((String)  casas.getSelectedItem());
		classeReferencia.setAnimal_nome(escreverNomeDoAnimal.getText());
		classeReferencia.setAnimal_tipo((String) animalTipo.getSelectedItem()); 
		
		
		
		return classeReferencia;
	}
	
	public void AtualizaTabela() {
		janelaPrincipal.atualizaTabela();
	}
	
}
