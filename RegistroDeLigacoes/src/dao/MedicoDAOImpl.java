package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Medico;

public class MedicoDAOImpl implements MedicoDAO {

	ConnectionSingleton conSing = ConnectionSingleton.getInstancy();
	Connection con = conSing.getcon();
	
	@Override
	public void adicionaMedico(Medico m) throws GenericDAOException {
		String sql = "INSERT INTO medico (id, nome_medico) VALUES (?, ?)";
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
		String sql = "SELECT * FROM medico WHERE nome_medico like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + nomeMedico + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Medico m = new Medico();
				m.setId(rs.getLong("id"));
				m.setNome(rs.getString("nome_medico"));
				lista.add(m);
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		
		return lista;
	}

}
