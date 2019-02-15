package entidade;

import java.io.Serializable;

public class Exame implements Serializable {

	private static final long serialVersionUID = 8213130664524762908L;

	private long id;
	private String exame = "";
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getExame() {
		return exame;
	}
	public void setExame(String exame) {
		this.exame = exame;
	}
	
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("ID:");
		s.append(this.getId());
		s.append("\tExame:");
		s.append(this.getExame());
		return s.toString();
	}
}
