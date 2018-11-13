package dao;

import java.util.List;
import entidade.Setor;

public interface SetorDAO {
	public void adicionaSetor(Setor s) throws GenericDAOException; 
	public List<Setor> pesquisarSetor(String nomeSetor) throws GenericDAOException;
	public void remover(long id) throws GenericDAOException;
	public Setor pesquisarPorId(long id) throws GenericDAOException;
	public void salvar(long id, Setor s) throws GenericDAOException;
}
