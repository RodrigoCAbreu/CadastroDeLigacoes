package dao;

import java.util.List;
import entidade.Medico;

public interface MedicoDAO {
	public void adicionaMedico(Medico m) throws GenericDAOException; 
	public List<Medico> pesquisarMedico(String nomeMedico) throws GenericDAOException;
	public void remover(long id) throws GenericDAOException;
	public Medico pesquisarPorId(long id) throws GenericDAOException;
	public void salvar(long id, Medico m) throws GenericDAOException;
}
