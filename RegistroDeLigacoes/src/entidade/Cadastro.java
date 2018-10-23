package entidade;

import java.io.Serializable;


public class Cadastro implements Serializable {

	private static final long serialVersionUID = 3763954342128886445L;

	private long id;
	private String usuario;
	private String data;
	private String hora;
	private String setor;
	private String codigo;
	private String prontuario;
	private String paciente;
	private String consulta;
	private String profissional;
	private String motivo;
	private String telefone1;
	private String contato1;
	private String situacao1;
	private String telefone2;
	private String contato2;
	private String situacao2;
	private String telefone3;
	private String contato3;
	private String situacao3;
	private String telefone4;
	private String contato4;
	private String situacao4;
	private String obser;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getProntuario() {
		return prontuario;
	}
	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public String getConsulta() {
		return consulta;
	}
	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
	public String getProfissional() {
		return profissional;
	}
	public void setProfissional(String profissional) {
		this.profissional = profissional;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getContato1() {
		return contato1;
	}
	public void setContato1(String contato1) {
		this.contato1 = contato1;
	}
	public String getSituacao1() {
		return situacao1;
	}
	public void setSituacao1(String situacao1) {
		this.situacao1 = situacao1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getContato2() {
		return contato2;
	}
	public void setContato2(String contato2) {
		this.contato2 = contato2;
	}
	public String getSituacao2() {
		return situacao2;
	}
	public void setSituacao2(String situacao2) {
		this.situacao2 = situacao2;
	}
	public String getTelefone3() {
		return telefone3;
	}
	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}
	public String getContato3() {
		return contato3;
	}
	public void setContato3(String contato3) {
		this.contato3 = contato3;
	}
	public String getSituacao3() {
		return situacao3;
	}
	public void setSituacao3(String situacao3) {
		this.situacao3 = situacao3;
	}
	public String getTelefone4() {
		return telefone4;
	}
	public void setTelefone4(String telefone4) {
		this.telefone4 = telefone4;
	}
	public String getContato4() {
		return contato4;
	}
	public void setContato4(String contato4) {
		this.contato4 = contato4;
	}
	public String getSituacao4() {
		return situacao4;
	}
	public void setSituacao4(String situacao4) {
		this.situacao4 = situacao4;
	}
	public String getObser() {
		return obser;
	}
	public void setObser(String obser) {
		this.obser = obser;
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("ID:");
		s.append(this.getId());
		s.append("\tUsuario:");
		s.append(this.getUsuario());
		s.append("\tData:");
		s.append(this.getData());
		s.append("\tHora:");
		s.append(this.getHora());
		s.append("\tSetor:");
		s.append(this.getSetor());
		s.append("\tCodigo:");
		s.append(this.getCodigo());
		s.append("\tProntuario:");
		s.append(this.getProntuario());
		s.append("\tPaciente:");
		s.append(this.getPaciente());
		s.append("\tConsulta:");
		s.append(this.getConsulta());
		s.append("\tProfissional:");
		s.append(this.getProfissional());
		s.append("\tMotivo:");
		s.append(this.getMotivo());
		s.append("\tTelefone:");
		s.append(this.getTelefone1());
		s.append("\tContato:");
		s.append(this.getContato1());
		s.append("\tSituação:");
		s.append(this.getSituacao1());
		s.append("\tTelefone:");
		s.append(this.getTelefone2());
		s.append("\tContato:");
		s.append(this.getContato2());
		s.append("\tSituação:");
		s.append(this.getSituacao2());
		s.append("\tTelefone:");
		s.append(this.getTelefone3());
		s.append("\tContato:");
		s.append(this.getContato3());
		s.append("\tSituação:");
		s.append(this.getSituacao3());
		s.append("\tTelefone:");
		s.append(this.getTelefone4());
		s.append("\tContato:");
		s.append(this.getContato4());
		s.append("\tSituação:");
		s.append(this.getSituacao4());
		s.append("\tObservação:");
		s.append(this.getObser());
		return s.toString();
	}
}
