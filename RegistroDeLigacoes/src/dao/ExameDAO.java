package dao;

import java.util.List;

import entidade.Exame;

public interface ExameDAO {
	public void adicionaExame(Exame e) throws GenericDAOException; 
	public List<Exame> pesquisarExame(String nomeExame) throws GenericDAOException;
}
