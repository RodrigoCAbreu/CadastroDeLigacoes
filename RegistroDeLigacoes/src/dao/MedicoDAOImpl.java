package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Medico;

public class MedicoDAOImpl implements MedicoDAO {

	private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/registrodeligacoes";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "";
	private Connection con;
	
	public MedicoDAOImpl() throws GenericDAOException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (SQLException | ClassNotFoundException e) {
			throw new GenericDAOException( e );
		}
	}
	
	@Override
	public void adicionaMedico(Medico m) throws GenericDAOException {
		String sql = "INSERT INTO medico (id, nome) VALUES (?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, 0);
			pstmt.setString(2, m.getNome());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public List<Medico> pesquisarMedico(String nomeMedico) throws GenericDAOException {
		List<Medico> lista = new ArrayList<>();
		String sql = "SELECT * FROM medico WHERE nome like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + nomeMedico + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Medico m = new Medico();
				m.setId(rs.getLong("id"));
				m.setNome(rs.getString("nome"));
				lista.add(m);
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		
		
		return lista;
	}

}
