package dao;

import java.util.List;

import entidade.Exame;

public interface ExameDAO {
	public void adicionaExame(Exame e) throws GenericDAOException; 
	public List<Exame> pesquisarExame(String nomeExame) throws GenericDAOException;
	public void remover(long id) throws GenericDAOException;
	public Exame pesquisarPorId(long id) throws GenericDAOException;
	public void salvar(long id, Exame e) throws GenericDAOException;
}
