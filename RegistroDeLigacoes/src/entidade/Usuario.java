package entidade;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = -1152991980224655646L;

	private long id;
	private String nome;
	private String nomeUsuario;
	private String senha;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("ID:");
		s.append(this.getId());
		s.append("\tNome:");
		s.append(this.getNome());
		s.append("\tUsuário:");
		s.append(this.getNomeUsuario());
		return s.toString();
	}
}
