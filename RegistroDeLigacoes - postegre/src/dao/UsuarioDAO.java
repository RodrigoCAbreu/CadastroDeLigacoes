package dao;

import java.util.List;
import entidade.Usuario;

public interface UsuarioDAO {
	public void adicionaUsuario(Usuario u) throws GenericDAOException; 
	public List<Usuario> pesquisarUsuario(String nome) throws GenericDAOException;
	public void remover(long id) throws GenericDAOException;
	public Usuario pesquisarPorId(long id) throws GenericDAOException;
	public void salvar(long id, Usuario u) throws GenericDAOException;
	
}
