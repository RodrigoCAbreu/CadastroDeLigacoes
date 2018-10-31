package dao;

import java.util.List;

import entidade.Medico;

public interface MedicoDAO {
	public void adicionaMedico(Medico m) throws GenericDAOException; 
	public List<Medico> pesquisarMedico(String nomeMedico) throws GenericDAOException;
}
