package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConexaoBDFactory;
import model.DNA;

public class MutanteDAO extends ConexaoBDFactory{

	private static MutanteDAO instance;
	
	
	public static MutanteDAO getInstance(){
		if(instance == null)
			instance = new MutanteDAO();
		return instance;
	}
	
	
	public void inserir(DNA dna){
		Connection conexao = null;
		PreparedStatement stm = null;
		
		String sql="insert into dna(dna,mutant) values (?,?)";
		conexao = criarConexao();
		try {
			stm = conexao.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
