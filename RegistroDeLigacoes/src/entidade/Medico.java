package entidade;

import java.io.Serializable;

public class Medico implements Serializable {
	
	private static final long serialVersionUID = -2008891168299065280L;
	
	private long id;
	private String nome = "";
	
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
	
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("ID:");
		s.append(this.getId());
		s.append("\tUsuario:");
		s.append(this.getNome());
		return s.toString();
	}
}
