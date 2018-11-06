package dao;

import java.util.List;

import entidade.Usuario;

public interface UsuarioDAO {
	public void adicionaUsuario(Usuario u) throws GenericDAOException; 
	public List<Usuario> pesquisarUsuario(String nome) throws GenericDAOException;
	
	
}
