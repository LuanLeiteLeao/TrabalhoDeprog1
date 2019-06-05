package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controle.Bruxo;

public class ConexaoPostgres {
	private Connection connection = null;
	private String url = "jdbc:postgresql://localhost:5433/postgres";
	private String loguin =  "postgres";
	private String senha ="123";
	private String sql;
	private PreparedStatement stmt;
	private ResultSet rs;
	private final static String ERRO="Erro Driver Postgrsql";
	
	public List<Bruxo> listBruxos(){

		if(testarDriver()==null)
			return null;
		
		connection =null;
		
		try {
			connection = DriverManager.getConnection(url,loguin,senha);
			stmt = connection.prepareStatement("select id, nome, sangue, casa, animal_nome, animal_tipo from bruxo");
			rs = stmt.executeQuery();
			List<Bruxo> listBruxos = new ArrayList<>();
			while (rs.next()) {
				Bruxo bruxo = new Bruxo();
				bruxo.setId(rs.getInt("id"));
				bruxo.setNome(rs.getString("nome"));
				bruxo.setCasa(rs.getString("casa"));
				bruxo.setSangue(rs.getBoolean("sangue"));
				bruxo.setNome(rs.getString("nome"));
				bruxo.setAnimal_nome(rs.getString("animal_nome"));
				bruxo.setAnimal_tipo(rs.getString("animal_tipo"));
				
				listBruxos.add(bruxo);
			}
			
			
			return listBruxos;
			
		} catch (SQLException e) {
			return null;
		}
		
		
		
		
		
	}
	
	
	
	
	
	public String inserirBruxo(Bruxo classeRefeRencia) {
	 
			
		
		
		
		if(testarDriver()==null)
			return this.ERRO;
		
	
		try {
	
			connection = DriverManager.getConnection(url,loguin,senha);
			 
			
			
			sql = "insert into bruxo(nome, sangue, casa, animal_nome, animal_tipo)values(?,?,?,?,?)";
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1,classeRefeRencia.getNome());
			pstm.setBoolean(2,classeRefeRencia.getSangue());
			pstm.setString(3, classeRefeRencia.getCasa());
			pstm.setString(4, classeRefeRencia.getAnimal_nome());
			pstm.setString(5,classeRefeRencia.getAnimal_tipo());
			
	
			
			
			pstm.execute();
			pstm.close();
	                    return "Salvo";
	
	
		} catch (SQLException e) {
			return "Connection Failed! Check output console";
	
		}
	}


	private Boolean testarDriver() {
		try {
	
			Class.forName("org.postgresql.Driver");
			
			return true;
		} catch (ClassNotFoundException e) {
				        
			return false;
			
	
		}
	}
	
	public String deleta(int id) {
		try {
			
			connection = DriverManager.getConnection(url,loguin,senha);
			 
			
			
			
			stmt = connection.prepareStatement("DELETE FROM bruxo WHERE id= "+id);
			rs = stmt.executeQuery();
	
			
			
		
			
	                    return "Deletado";
	
	
		} catch (SQLException e) {
			return "Connection Failed! Check output console";
	
		}
		
		
	
	}
	
	
}
