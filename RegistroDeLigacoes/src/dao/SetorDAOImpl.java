package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidade.Setor;

public class SetorDAOImpl implements SetorDAO {

	ConnectionSingleton conSing = ConnectionSingleton.getInstancy();
	Connection con = conSing.getcon();
	
	@Override
	public void adicionaSetor(Setor s) throws GenericDAOException {
		String sql = "INSERT INTO setor (id, nome_setor) VALUES (?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, 0);
			pstmt.setString(2, s.getSetor());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public List<Setor> pesquisarSetor(String nomeSetor) throws GenericDAOException {
		List<Setor> listaS = new ArrayList<>();
		String sql = "SELECT * FROM setor WHERE nome_setor like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + nomeSetor + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Setor s = new Setor();
				s.setId(rs.getLong("id"));
				s.setSetor(rs.getString("setor"));
				listaS.add(s);
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		
		return listaS;
	}
}
