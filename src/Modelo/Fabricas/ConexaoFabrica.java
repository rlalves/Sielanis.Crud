package Modelo.Fabricas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFabrica {

	public ConexaoFabrica() {
    }

    public static Connection ObtemConexao(String jdbcURL, String jdbcUsuario, String jdbcSenha) {
   	
    	Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(jdbcURL, jdbcUsuario, jdbcSenha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }
}