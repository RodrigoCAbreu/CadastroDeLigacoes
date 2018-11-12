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
		String sql = "INSERT INTO funcionario (id, nome, usuario, senha) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, 0);
			pstmt.setString(2, u.getNome());
			pstmt.setString(3, u.getNomeUsuario());
			pstmt.setString(4, u.getSenha());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
		
	}

	@Override
	public List<Usuario> pesquisarUsuario(String nome) throws GenericDAOException {
		List<Usuario> listaU = new ArrayList<>();
		String sql = "SELECT * FROM funcionario WHERE nome like ?";
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

}
