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
		String sql = "INSERT INTO public.setor (nome_setor) VALUES (?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getSetor());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public List<Setor> pesquisarSetor(String nomeSetor) throws GenericDAOException {
		List<Setor> listaS = new ArrayList<>();
		String sql = "SELECT * FROM public.setor WHERE nome_setor like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + nomeSetor + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Setor s = new Setor();
				s.setId(rs.getLong("id"));
				s.setSetor(rs.getString("nome_setor"));
				listaS.add(s);
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		
		return listaS;
	}

	@Override
	public void remover(long id) throws GenericDAOException {
		String sql = "DELETE FROM public.setor WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
	}

	@Override
	public Setor pesquisarPorId(long id) throws GenericDAOException {
		Setor s = new Setor();
		String sql = "SELECT * FROM public.setor WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { 
				s.setId(rs.getLong("id"));
				s.setSetor(rs.getString("nome_setor"));
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		return s;
	}

	@Override
	public void salvar(long id, Setor s) throws GenericDAOException {
		String sql = "UPDATE public.setor SET nome_setor = ? WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getSetor());
			pstmt.setLong(2, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e1) {
			throw new GenericDAOException( e1 );
		}
	}	
}
