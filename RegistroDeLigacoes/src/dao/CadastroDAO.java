package dao;

import java.util.List;
import entidade.Cadastro;

public interface CadastroDAO {
	public void adicionar(Cadastro c) throws GenericDAOException;
	public List<Cadastro> pesquisarPorCodigo(String codigo) throws GenericDAOException;
	public void remover(long id) throws GenericDAOException;
	public Cadastro pesquisarId(long id) throws GenericDAOException;
	public void salvar(long id, Cadastro c) throws GenericDAOException;
	public List<Cadastro> pesquisarPorProntuario(String prontuario);
}
