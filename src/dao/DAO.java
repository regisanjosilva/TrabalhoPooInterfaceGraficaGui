package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import controle.Conexao;
import modelo.Estudante;
import modelo.Usuario;

public class DAO {

	
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	
	private static String CADASTRO_ESTUDANTE = "INSERT INTO ESTUDANTE" 
	+ "(ID, nomeCompleto, idadeNaMatrcula, email, endereco, cep,"
	+ " telefone, curso, observacoes, ativo)"
	+ " value (null, ?, ?, ?, ?, ?, ?, ?, ?)";
	

	private static String CONSULTA_ESTUDANTE = "SELECT * FROM ESTUDANTE"
	+ "WHERE ID = ?";
	
	private static String ALTERAR_ESTUDANTE = "UPDATE ESTUDANTE SET"
			+"nomeCompleto = ?, idadeNaMatrcula = ? , email = ?, endereco = ?,"
			+"cep = ?, telefone =?, curso =?, observacoes =?, ativo =?,"
			+ " WHERE ID = ? ";


	private static String EXCLUIR_ESTUDANTE = " DELETE FROM ESTUDANTE "
			+ " WHERE ID = ?";
	
	private static String LISTAR_ESTUDANTE = "SELECT * FROM ESTUDANTE "
			+ "WHERE 1 = 1 ";
	
	
	private static final String CONSULTAR_USUARIO = "SELECT USUARIO, SENHA"
			+ "FROM USUARIO"
			+ "WHERE USUARIO = ?"
			+ "AND SENHA = ?";;
	
	
	
				
	public DAO() {
		
	}
	
	public void cadastrarEstudante(Estudante estudante) {
		Connection connection = Conexao.getInstancia().abrirconexao();
		
		String query = CADASTRO_ESTUDANTE;
		try {
		preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setString(i++, estudante.getNomeCompleto());
		preparedStatement.setInt(i++, estudante.getIdadeNaMatricula());
        preparedStatement.setString(i++, estudante.getEmail());
        preparedStatement.setString(i++, estudante.getEndereco());
        preparedStatement.setString(i++, estudante.getCep());
        preparedStatement.setString(i++, estudante.getTelefone());
        preparedStatement.setString(i++, estudante.getCurso());
        preparedStatement.setString(i++, estudante.getObservacoes());
		preparedStatement.setBoolean(i++, estudante.isAtivo());
		
		preparedStatement.execute();
		connection.commit();
		JOptionPane.showMessageDialog(null,"Estudante cadastrado com sucesso ");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			fechaConexao();
		}
	}
	
	private void fechaConexao() {
		try {
		if(resultSet!=null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
		preparedStatement.close();	
		}
		Conexao.getInstancia().fecharConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Estudante ConsultarEstudante(int id) throws Exception  {
		Connection connection = Conexao.getInstancia().abrirconexao();
		Estudante estudante = null;
		String query = CONSULTA_ESTUDANTE;
		try {
		preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setInt(i++, id);
		
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			estudante = new Estudante( resultSet.getInt(id),
					                  resultSet.getString("NOME COMPLETO"),
					                  resultSet.getInt("IDADE MATRICULA"),
					                  resultSet.getString("EMAIL"),
					                  resultSet.getString("ENDERECO"),
					                  resultSet.getString("CEP"),
					                  resultSet.getString("TELEFONE"),
					                  resultSet.getString("CURSO"),
					                  resultSet.getString("OBSERVACOES"),
					                  resultSet.getBoolean("ATIVO"));
					
		}	
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			fechaConexao();
		}
		if(estudante == null) {
			JOptionPane.showMessageDialog(null,"Estudante selecionado não encontrado", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("Estudante não encontrado");
		}
		return estudante;
	}
	public void excluirEstudante(int id ) {
		Connection connection = Conexao.getInstancia().abrirconexao();
		
		String query = EXCLUIR_ESTUDANTE;
		try {
		preparedStatement = connection.prepareStatement(query);
		int i = 1;
		
		preparedStatement.setInt(i++, id);
		
		preparedStatement.execute();
		connection.commit();
		JOptionPane.showMessageDialog(null,"Estudante excluido com sucesso ");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			fechaConexao();
		}
	}
	
	public void alterarEstudante(int id, Estudante estudante) {
		Connection connection = Conexao.getInstancia().abrirconexao();
		
		String query = ALTERAR_ESTUDANTE;
		try {
		preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setString(i++, estudante.getNomeCompleto());
		preparedStatement.setInt(i++, estudante.getIdadeNaMatricula());
        preparedStatement.setString(i++, estudante.getEmail());
        preparedStatement.setString(i++, estudante.getEndereco());
        preparedStatement.setString(i++, estudante.getCep());
        preparedStatement.setString(i++, estudante.getTelefone());
        preparedStatement.setString(i++, estudante.getCurso());
        preparedStatement.setString(i++, estudante.getObservacoes());
		preparedStatement.setBoolean(i++, estudante.isAtivo());
		preparedStatement.setInt(i++, id);
		
		preparedStatement.execute();
		connection.commit();
		JOptionPane.showMessageDialog(null,"Estudante alterado com sucesso ");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			fechaConexao();
		}
	}

	public ArrayList<Estudante> listarEstudante() throws Exception  {
		Connection connection = Conexao.getInstancia().abrirconexao();
		ArrayList<Estudante> estudante =new ArrayList<>();
		String query = LISTAR_ESTUDANTE;
		try {
		preparedStatement = connection.prepareStatement(query);
				
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			estudante.add(new Estudante( resultSet.getInt("ID"),
					                  resultSet.getString("NOMECOMPLETO"),
					                  resultSet.getInt("IDADEMATRICULA"),
					                  resultSet.getString("EMAIL"),
					                  resultSet.getString("ENDERECO"),
					                  resultSet.getString("CEP"),
					                  resultSet.getString("TELEFONE"),
					                  resultSet.getString("CURSO"),
					                  resultSet.getString("OBSERVACOES"),
					                  resultSet.getBoolean("ATIVO")));
					
		}	
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			fechaConexao();
		}
		if(estudante.size() < 0) {
			JOptionPane.showMessageDialog(null,"Não a estudante cadastrado", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não a estudante cadastrado");
		}
		return estudante;
	}
	

	public Usuario consultarUsuario(String nomeUsuario, String senhaCriptografada) throws Exception  {
		Connection connection = Conexao.getInstancia().abrirconexao();
		Usuario usuario = null;
		String query = CONSULTAR_USUARIO;
		try {
		preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setString(i++, nomeUsuario);
		preparedStatement.setString(i++, senhaCriptografada);
		
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			usuario = new Usuario( resultSet.getInt("id"),
					               resultSet.getString("Usuario"),
					               resultSet.getString("Senha"));
					             
					
		}	
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			fechaConexao();
		}
		if(usuario == null) {
			JOptionPane.showMessageDialog(null,"Não foi possivel localizar Usuario selecionado", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não foi possivel localizar Usuario selecionado");
		}
		return usuario;
	
	
	
	
	
	}

	@Override
	public String toString() {
				return super.toString();
	}

	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
