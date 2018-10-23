package dao;

import java.util.List;

import entidade.Cadastro;

public interface CadastroDAO {
	public void adicionar(Cadastro c) throws GenericDAOException;
	public List<Cadastro> pesquisarPorCodigo(String codigo) throws GenericDAOException;
}
