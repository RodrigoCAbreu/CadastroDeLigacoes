package dao;

import entidade.Cadastro;

public interface CadastroDAO {
	public void adicionar(Cadastro c) throws GenericDAOException;
}
