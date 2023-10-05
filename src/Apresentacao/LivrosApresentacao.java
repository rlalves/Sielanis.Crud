package Apresentacao;

import Infra.LivrosRepositorio;
import Modelo.Entidades.Usuario;

public class LivrosApresentacao {

	public static void main(String[] args) {
		LivrosRepositorio livros = new LivrosRepositorio(); 

		//livros.CriaTabelaAutores();
		//livros.InsereAutor(2, "Rodrigo LA 2", "Teste de insert 2");
		livros.ConsultaUsuarios();
		livros.ExcluirUsuario(1);
		livros.ConsultaUsuarios();
		livros.AlteraUsuario(new Usuario(2, "RLA", "Descricao RLA"));
		livros.ConsultaUsuarios();
	}
}
