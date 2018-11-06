package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Exame;

public class ExameDAOImpl implements ExameDAO {

	ConnectionSingleton conSing = ConnectionSingleton.getInstancy();
	Connection con = conSing.getcon();
	
	@Override
	public void adicionaExame(Exame e) throws GenericDAOException {
		String sql = "INSERT INTO exame (id, nome_exame) VALUES (?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, 0);
			pstmt.setString(2, e.getExame());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e1) {
			throw new GenericDAOException(e1);
		}
	}

	@Override
	public List<Exame> pesquisarExame(String nomeExame) throws GenericDAOException {
		List<Exame> listaE = new ArrayList<>();
		String sql = "SELECT * FROM exame WHERE nome_exame like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + nomeExame + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Exame e = new Exame();
				e.setId(rs.getLong("id"));
				e.setExame(rs.getString("nome"));
				listaE.add(e);
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		
		return listaE;
	}

}
