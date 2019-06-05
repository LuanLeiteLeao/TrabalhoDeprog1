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

import controle.Bruxo;
import controle.InteracoesBruxosNoDB;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
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
import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class JanelaPrincipal {


	
	
	private JFrame principalFrame;
	private JTabbedPane tabbedPanePrincipal_1;
	private JTable tabelapesquisa2;
	private InsercaoAandEdicaoPanel manterPanelInsercao;
	
	
	
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
		
		manterPanelInsercao = new InsercaoAandEdicaoPanel(tabbedPanePrincipal,this);
		//manterPanelInserir(tabbedPanePrincipal);
		
		manterPanelPesquisa(tabbedPanePrincipal);
	}
 
	
	
	

	private void manterPanelPesquisa(JTabbedPane tabbedPanePrincipal) {
		JPanel panelPesquisa = new JPanel();
		tabbedPanePrincipal.addTab("Consultar", null, panelPesquisa, null);
		
		JScrollPane tabelapesquisa = new JScrollPane();
		
		JButton btnEditar = new JButton("Editar");
		
		JButton btnExcluir = new JButton("Excluir");
		//btnExcluir.addActionListener(new ControladorDeEventos(this));
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
        tabelapesquisa2.addMouseListener(new ControladorDeEventosMouse(this,manterPanelInsercao));
		tabelapesquisa2.setFillsViewportHeight(true);
		tabelapesquisa2.setRowSelectionAllowed(false);
		tabelapesquisa2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabelapesquisa2.setRowSelectionAllowed(true);
	
		
		
		
		pesquisaECriaTabela();
		tabelapesquisa.setViewportView(tabelapesquisa2);
		panelPesquisa.setLayout(gl_panelPesquisa);
	}



	private void pesquisaECriaTabela() {
		InteracoesBruxosNoDB tabelaSql;
		tabelaSql = new InteracoesBruxosNoDB();
		
		
		criaTabel(tabelaSql.tabelaDaPesquisa());
	}

	

	private void criaTabel(String [][] tabelaSql) {
		tabelapesquisa2.setModel(new DefaultTableModel(
				tabelaSql,
			new String[] {
				"Id", "Nome", "Genetica", "Casa", "Nome do Animal","Raça do Animal"
			}
		))
		;
	}

	public void atualizaTabela() {
		
			 pesquisaECriaTabela();
		
	}
	
	public Bruxo retornarLinhaDaTabela() {
		Bruxo classeReferencia = new Bruxo();
		
		classeReferencia.setId(Integer.getInteger(tabelapesquisa2.getValueAt(tabelapesquisa2.getSelectedRow(),0).toString()));
		classeReferencia.setNome((tabelapesquisa2.getValueAt(tabelapesquisa2.getSelectedRow(),1).toString()));
		classeReferencia.setSangue(Boolean.parseBoolean((tabelapesquisa2.getValueAt(tabelapesquisa2.getSelectedRow(),2).toString())));
		classeReferencia.setCasa((tabelapesquisa2.getValueAt(tabelapesquisa2.getSelectedRow(),3).toString()));
		classeReferencia.setAnimal_nome((tabelapesquisa2.getValueAt(tabelapesquisa2.getSelectedRow(),4).toString()));
		classeReferencia.setAnimal_tipo((tabelapesquisa2.getValueAt(tabelapesquisa2.getSelectedRow(),5).toString()));
		
		
		
		return classeReferencia;
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

	
	


}
