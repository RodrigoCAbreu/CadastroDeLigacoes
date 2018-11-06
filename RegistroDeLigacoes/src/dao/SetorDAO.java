package dao;

import java.util.List;

import entidade.Setor;

public interface SetorDAO {

	public void adicionaSetor(Setor s) throws GenericDAOException; 
	public List<Setor> pesquisarSetor(String nomeSetor) throws GenericDAOException;
	
}
