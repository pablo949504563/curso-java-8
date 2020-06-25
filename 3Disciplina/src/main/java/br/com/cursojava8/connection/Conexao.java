package br.com.cursojava8.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexao {
	
	private static Connection conexao;
	
	private static final String URL_CONEXAO = "jdbc:mysql://localhost/curso-java?useTimezone=true&serverTimezone=UTC";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	
	public static Connection getConexao() {
		if (conexao == null) {
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conexao = (Connection) DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				}

			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		return conexao;
	}
public static void fecharConexao(){
	if(conexao != null){
		try {
			conexao.close();
			conexao = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}	
	
public static void main(String []args) {
	getConexao();
	try {
		conexao.getLog();
		System.out.println("conectou");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	fecharConexao();
	
	
}



}
