package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controle.InteracoesBruxosNoDB;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class JanelaPrincipal {

	private JFrame principalFrame;
	private JTextField escreverNomeDoBruxo;
	private JTextField escreverNomeDoAnimal;
	private static final String FONTE = "Courier New";
	private static final int TAM= 16;
	private static final int COLUNAS= 5;
	private JTextField escreveIdade;
	private JCheckBox genetica;
	private JComboBox animalTipo;
	private JComboBox casas;
	private JTabbedPane tabbedPanePrincipal_1;
	private JTable tabelapesquisa2;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
					window.principalFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public JanelaPrincipal() {
		initialize();
		//escreveNaTelaDeCadastro(null);
		
	}

	
	
	



	private void initialize() {
		manterPrincipalFrame();
		
		JPanel panelPrincipal = manterPanelPrincipal();
		
		JTabbedPane tabbedPanePrincipal = manterTabbedPanePrincipal(panelPrincipal);
		
		manterPanelInserir(tabbedPanePrincipal);
		
		manterPanelPesquisa(tabbedPanePrincipal);
	}



	private void manterPanelPesquisa(JTabbedPane tabbedPanePrincipal) {
		JPanel panelPesquisa = new JPanel();
		tabbedPanePrincipal.addTab("Consultar", null, panelPesquisa, null);
		
		JScrollPane tabelapesquisa = new JScrollPane();
		
		JButton btnEditar = new JButton("Editar");
		
		JButton btnExcluir = new JButton("Excluir");
		GroupLayout gl_panelPesquisa = new GroupLayout(panelPesquisa);
		gl_panelPesquisa.setHorizontalGroup(
			gl_panelPesquisa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesquisa.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPesquisa.createParallelGroup(Alignment.LEADING)
						.addComponent(tabelapesquisa, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
						.addGroup(gl_panelPesquisa.createSequentialGroup()
							.addComponent(btnEditar)
							.addGap(117)
							.addComponent(btnExcluir)))
					.addContainerGap())
		);
		gl_panelPesquisa.setVerticalGroup(
			gl_panelPesquisa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesquisa.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabelapesquisa, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelPesquisa.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnExcluir))
					.addContainerGap())
		);
		
		tabelapesquisa2 = new JTable();
        tabelapesquisa2.addMouseListener(new ControladorDeEventosMouse(this));
		tabelapesquisa2.setFillsViewportHeight(true);
		tabelapesquisa2.setRowSelectionAllowed(false);
		tabelapesquisa2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabelapesquisa2.setRowSelectionAllowed(true);
	
		
		
		
		InteracoesBruxosNoDB tabelaSql;
		tabelaSql = new InteracoesBruxosNoDB();
		
		
		criaTabel(tabelaSql.tabelaDaPesquisa());
		tabelapesquisa.setViewportView(tabelapesquisa2);
		panelPesquisa.setLayout(gl_panelPesquisa);
	}

	

	public void criaTabel(String [][] tabelaSql) {
		tabelapesquisa2.setModel(new DefaultTableModel(
				tabelaSql,
			new String[] {
				"Id", "Nome", "Genetica", "Casa", "Nome do Animal","Raça do Animal"
			}
		))
		;
	}

	public String[] retornarLinhaDaTabela() {
		String [] linhasDaTabela = new String[this.COLUNAS];
		for(int i=0;i<this.COLUNAS;i++) {
			linhasDaTabela[i]=tabelapesquisa2.getValueAt(tabelapesquisa2.getSelectedRow(),i).toString();
			
		}
		
		
		
		return linhasDaTabela;
	}

	private void manterPanelInserir(JTabbedPane tabbedPanePrincipal) {
		
		JPanel panelInserir = new JPanel();
		tabbedPanePrincipal.addTab("Cadastrar", null, panelInserir, null);
		panelInserir.setLayout(new MigLayout("", "[27px][194px,grow][][][][][][grow][][][][][grow]", "[14px][][][][][][][]"));
		{
			JLabel nomeDobruxo = new JLabel("Nome");
			panelInserir.add(nomeDobruxo, "cell 0 0,alignx center,aligny center");
		}
		
		{
			escreverNomeDoBruxo = new JTextField();
			escreverNomeDoBruxo.setFont(new Font(FONTE, Font.PLAIN, TAM));
			panelInserir.add(escreverNomeDoBruxo, "cell 1 0,growx,aligny top");
			escreverNomeDoBruxo.setColumns(10);
		}
		{
			genetica = new JCheckBox("Mesti\u00E7o");
			panelInserir.add(genetica, "cell 4 0");
		}
		{
			casas = new JComboBox();
			casas.setModel(new DefaultComboBoxModel(new String[] {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"}));
			casas.setBackground(new Color(255, 255, 255));
			panelInserir.add(casas, "cell 7 0,growx");
		}
		{
			JLabel apelidoDoAnimal = new JLabel("Apelido do Animal");
			panelInserir.add(apelidoDoAnimal, "cell 0 1,alignx trailing");
		}
		{
			escreverNomeDoAnimal = new JTextField();
			escreverNomeDoAnimal.setFont(new Font(FONTE, Font.PLAIN, TAM));
			panelInserir.add(escreverNomeDoAnimal, "cell 1 1,growx");
			escreverNomeDoAnimal.setColumns(10);
		}
		
		{
			animalTipo = new JComboBox();
			animalTipo.setModel(new DefaultComboBoxModel(new String[] {"Gato", "Fenix", "Coruja", "Aranha", "Coelho ", "Sapo ", "Rato"}));
			panelInserir.add(animalTipo, "cell 4 1,growx");
		}
		{
			JLabel idade = new JLabel("Idade");
			panelInserir.add(idade, "cell 5 1");
		}
		{
			escreveIdade = new JTextField();
			panelInserir.add(escreveIdade, "cell 7 1,alignx right");
			escreveIdade.setColumns(10);
		}
		{
			JButton btnSalvar = new JButton("Salvar");
			btnSalvar.addActionListener(new ControladorDeEventos(this));
			panelInserir.add(btnSalvar, "cell 0 7");
			
		}
		{
			JButton btnCancelar = new JButton("Cancelar");			
			btnCancelar.addActionListener(new ControladorDeEventos(this));
			panelInserir.add(btnCancelar, "cell 4 7");
		}
		
	}



	private JTabbedPane manterTabbedPanePrincipal(JPanel panelPrincipal) {
		tabbedPanePrincipal_1 = new JTabbedPane(JTabbedPane.TOP);
		panelPrincipal.add(tabbedPanePrincipal_1, BorderLayout.CENTER);
		return tabbedPanePrincipal_1;
	}



	private JPanel manterPanelPrincipal() {
		JPanel panelPrincipal = new JPanel();
		principalFrame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		return panelPrincipal;
	}



	private void manterPrincipalFrame() {
		principalFrame = new JFrame();
		principalFrame.setBounds(100, 100, 657, 300);
		principalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	public void escreveNaTelaDeCadastro(String[] inf) {
		//"Nome", "Genetica", "Casa", "Nome do Animal","Raça do Animal"
		
		escreverNomeDoBruxo.setText(inf[1]);
		genetica.setSelected(Boolean.getBoolean(inf[2]));
		casas.setSelectedIndex(retornaPocaoComboBox(inf[3],casas));
		escreverNomeDoAnimal.setText(inf[4]);
		animalTipo.setSelectedIndex(retornaPocaoComboBox(inf[5],animalTipo));;
	    
	
	}
	
	
	private int retornaPocaoComboBox(String nome,JComboBox ComboBox) {
		
		for (int i = 0;i< ComboBox.getItemCount(); i++) {
			animalTipo.setSelectedIndex(i);
			
			if (casas.getSelectedItem()==nome) {
				return i;
			}
		}
		
		
		return 0;
	}
	
	public String getNome() {
		
		return escreverNomeDoBruxo.getText();
	}
	
	public String getNomeAnimal() {
		 return escreverNomeDoAnimal.getText();
	}
	
	public Boolean getGenetica() {
		return  genetica.isSelected();
	} 
	
	public String getAnimalTipo() {
		
		return (String) animalTipo.getSelectedItem();
	}
	
	public String getCasa() {
		return (String)  casas.getSelectedItem();
	}
	
	public int getIdade(){
		return Integer.parseInt(escreveIdade.getText());
	}
}
