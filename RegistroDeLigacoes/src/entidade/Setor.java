package entidade;

import java.io.Serializable;

public class Setor implements Serializable {

	private static final long serialVersionUID = 3768220525372583763L;

	private long id;
	private String setor = "";
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("ID:");
		s.append(this.getId());
		s.append("\tSetor:");
		s.append(this.getSetor());
		return s.toString();
	}
	
	
}
