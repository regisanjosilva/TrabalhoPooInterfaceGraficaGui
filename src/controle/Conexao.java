package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

private static Conexao instancia;
private static String DRIVE ="org.mysql.JDBC";
private static String BD = "jdbc:mysql:resources/cadastro_matrículas";
private static Connection conexao;
private Conexao() {
	
	
}

public static Conexao getInstancia() {
	if(instancia == null) {
		instancia = new Conexao();
	}
	 
	return instancia;
}

public Connection abrirconexao() {
	try {
		Class.forName(DRIVE);
		conexao = DriverManager.getConnection(BD);
		conexao.setAutoCommit(false);
	}catch (SQLException | ClassNotFoundException e) {
		System.out.println("Erro ao conectar como o banco de dados" + e.getMessage());
		
	}
	
	return conexao;
}

public void  fecharConexao() {
	try {
		if(conexao != null && conexao.isClosed()) {
			conexao.close();
		}
	} catch (SQLException e) {
		System.out.println("Erro ao fechar a conexão");
	}finally {
		conexao = null;
	}
}



}

