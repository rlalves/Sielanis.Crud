package Modelo.Entidades;

public class Usuario {
	private int Id;
	private String Nome;
	private String Descricao;
	
	public Usuario(int Id, String Nome, String Descricao)
	{
		this.Id = Id;
		this.Nome = Nome;
		this.Descricao = Descricao;
	}
	
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
}
