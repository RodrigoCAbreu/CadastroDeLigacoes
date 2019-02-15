package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidade.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	ConnectionSingleton conSing = ConnectionSingleton.getInstancy();
	Connection con = conSing.getcon();
	
	@Override
	public void adicionaUsuario(Usuario u) throws GenericDAOException {
		String sql = "INSERT INTO public.funcionario (nome, usuario, senha) VALUES (?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u.getNome());
			pstmt.setString(2, u.getNomeUsuario());
			pstmt.setString(3, u.getSenha());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
		
	}

	@Override
	public List<Usuario> pesquisarUsuario(String nome) throws GenericDAOException {
		List<Usuario> listaU = new ArrayList<>();
		String sql = "SELECT * FROM public.funcionario WHERE nome like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + nome + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getLong("id"));
				u.setNome(rs.getString("nome"));
				u.setNomeUsuario(rs.getString("usuario"));
				u.setSenha(rs.getString("senha"));
				listaU.add(u);
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		
		return listaU;
	}

	@Override
	public void remover(long id) throws GenericDAOException {
		String sql = "DELETE FROM public.funcionario WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		
	}

	@Override
	public Usuario pesquisarPorId(long id) throws GenericDAOException {
		Usuario u = new Usuario();
		String sql = "SELECT * FROM public.funcionario WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { 
				u.setId(rs.getLong("id"));
				u.setNome(rs.getString("nome"));
				u.setNomeUsuario(rs.getString("usuario"));
				u.setSenha(rs.getString("usuario"));
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		return u;
	}

	@Override
	public void salvar(long id, Usuario u) throws GenericDAOException {
		String sql = "UPDATE public.funcionario SET nome = ?, usuario = ?, senha = ? WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u.getNome());
			pstmt.setString(2, u.getNomeUsuario());
			pstmt.setString(3, u.getSenha());
			pstmt.setLong(4, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
	}
}
