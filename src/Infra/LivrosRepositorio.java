package Infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import Modelo.Entidades.Usuario;
import Modelo.Fabricas.*;

public class LivrosRepositorio {
	private ConexaoFabrica conexao;
	
    private static final String ScriptInsert = "INSERT INTO Autores (Id, Nome, Descricao) VALUES (?, ?, ?)";
    private static final String ScriptSelect = "SELECT * FROM Autores";
    private static final String ScriptDelete = "DELETE FROM Autores WHERE id = ?";
    private static final String ScriptUpdate = "UPDATE Autores SET Nome = ?, Descricao = ? WHERE id = ?";
	private static final String ScriptCreate = "CREATE TABLE Autores(ID INT PRIMARY KEY, Nome VARCHAR(255), Descricao VARCHAR(255));";
    
	public LivrosRepositorio()
	{
		this.conexao = new ConexaoFabrica();
	}
	
	public void CriaTabelaAutores()
	{
		try (Connection conexao = obtemConexao();
	        PreparedStatement preparedStatement = conexao.prepareStatement(ScriptCreate)) {
			preparedStatement.executeUpdate();
			conexao.close();
		}
		catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
    public void InsereAutor(Integer Id,  String Nome, String Descricao) {
        try (Connection conexao = obtemConexao();
            PreparedStatement preparedStatement = conexao.prepareStatement(ScriptInsert)) {
            preparedStatement.setInt(1, Id);
            preparedStatement.setString(2, Nome);
            preparedStatement.setString(3, Descricao);
            preparedStatement.executeUpdate();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	

    public List<Usuario> ConsultaUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conexao = obtemConexao();
             PreparedStatement preparedStatement = conexao.prepareStatement(ScriptSelect)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String nome = rs.getString("Nome");
                String descricao = rs.getString("Descricao");
                usuarios.add(new Usuario(id, nome, descricao));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
    public void ExcluirUsuario(int id) {
        try (Connection conexao = obtemConexao();
             PreparedStatement preparedStatement = conexao.prepareStatement(ScriptDelete)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AlteraUsuario(Usuario usuario) {
        try (Connection conexao = obtemConexao();
             PreparedStatement preparedStatement = conexao.prepareStatement(ScriptUpdate)) {
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getDescricao());
            preparedStatement.setInt(3, usuario.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    protected Connection obtemConexao() {
        return ConexaoFabrica.ObtemConexao("jdbc:h2:~/livros", "sa", "");
    }
}
