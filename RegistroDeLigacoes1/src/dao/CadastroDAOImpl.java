package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidade.Cadastro;

public class CadastroDAOImpl implements CadastroDAO {

	private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/registrodeligacoes";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "";
	private Connection con;
	
	public CadastroDAOImpl() throws GenericDAOException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (SQLException | ClassNotFoundException e) {
			throw new GenericDAOException( e );
		}
	}
	
	@Override
	public void adicionar(Cadastro c) throws GenericDAOException {
		String sql = "INSERT INTO cadastro (id, usuario, data, hora, setor, codigo, prontuario, paciente, consulta,"
				+ " profissional, motivo, telefone1, contato1, situacao1, telefone2, contato2, situacao2,"
				+ " telefone3, contato3, situacao3, telefone4, contato4, situacao4, obser) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, 0);
			pstmt.setString(2, c.getUsuario());
			pstmt.setString(3, c.getData());
			pstmt.setString(4, c.getHora());
			pstmt.setString(5, c.getSetor());
			pstmt.setString(6, c.getCodigo());
			pstmt.setString(7, c.getProntuario());
			pstmt.setString(8, c.getPaciente());
			pstmt.setString(9, c.getConsulta());
			pstmt.setString(10, c.getProfissional());
			pstmt.setString(11, c.getMotivo());
			pstmt.setString(12, c.getTelefone1());
			pstmt.setString(13, c.getContato1());
			pstmt.setString(14, c.getSituacao1());
			pstmt.setString(15, c.getTelefone2());
			pstmt.setString(16, c.getContato2());
			pstmt.setString(17, c.getSituacao2());
			pstmt.setString(18, c.getTelefone3());
			pstmt.setString(19, c.getContato3());
			pstmt.setString(20, c.getSituacao3());
			pstmt.setString(21, c.getTelefone4());
			pstmt.setString(22, c.getContato4());
			pstmt.setString(23, c.getSituacao4());
			pstmt.setString(24, c.getObser());
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

}
