package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidade.Cadastro;

public class CadastroDAOImpl implements CadastroDAO {
		
	ConnectionSingleton conSing = ConnectionSingleton.getInstancy();
	Connection con = conSing.getcon();
	
	@Override
	public void adicionar(Cadastro c) throws GenericDAOException {
		String sql = "INSERT INTO public.cadastro (usuario, data, hora, nome_setor, codigo, prontuario, paciente, nome_exame,"
				+ " nome_medico, motivo, telefone1, contato1, situacao1, telefone2, contato2, situacao2,"
				+ " telefone3, contato3, situacao3, telefone4, contato4, situacao4, obser, externo) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c.getUsuario());
			pstmt.setString(2, c.getData());
			pstmt.setString(3, c.getHora());
			pstmt.setString(4, c.getSetor());
			pstmt.setString(5, c.getCodigo());
			pstmt.setString(6, c.getProntuario());
			pstmt.setString(7, c.getPaciente());
			pstmt.setString(8, c.getConsulta());
			pstmt.setString(9, c.getProfissional());
			pstmt.setString(10, c.getMotivo());
			pstmt.setString(11, c.getTelefone1());
			pstmt.setString(12, c.getContato1());
			pstmt.setString(13, c.getSituacao1());
			pstmt.setString(14, c.getTelefone2());
			pstmt.setString(15, c.getContato2());
			pstmt.setString(16, c.getSituacao2());
			pstmt.setString(17, c.getTelefone3());
			pstmt.setString(18, c.getContato3());
			pstmt.setString(19, c.getSituacao3());
			pstmt.setString(20, c.getTelefone4());
			pstmt.setString(21, c.getContato4());
			pstmt.setString(22, c.getSituacao4());
			pstmt.setString(23, c.getObser());
			pstmt.setString(24, c.getExterno());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public List<Cadastro> pesquisarPorCodigo(String codigo) throws GenericDAOException {
		List<Cadastro> lista = new ArrayList<>();
		String sql = "SELECT * FROM public.cadastro WHERE codigo like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + codigo + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Cadastro c = new Cadastro();
				c.setId(rs.getLong("id"));
				c.setData(rs.getString("data"));
				c.setHora(rs.getString("hora"));
				c.setSetor(rs.getString("nome_setor"));
				c.setCodigo(rs.getString("codigo"));
				c.setProntuario(rs.getString("prontuario"));
				c.setPaciente(rs.getString("paciente"));
				c.setConsulta(rs.getString("nome_exame"));
				c.setProfissional(rs.getString("nome_medico"));
				c.setMotivo(rs.getString("motivo"));
				c.setTelefone1(rs.getString("telefone1"));
				c.setContato1(rs.getString("contato1"));
				c.setSituacao1(rs.getString("situacao1"));
				c.setTelefone2(rs.getString("telefone2"));
				c.setContato2(rs.getString("contato2"));
				c.setSituacao2(rs.getString("situacao2"));
				c.setTelefone3(rs.getString("telefone3"));
				c.setContato3(rs.getString("contato3"));
				c.setSituacao3(rs.getString("situacao3"));
				c.setTelefone4(rs.getString("telefone4"));
				c.setContato4(rs.getString("contato4"));
				c.setSituacao4(rs.getString("situacao4"));
				c.setObser(rs.getString("obser"));
				c.setExterno(rs.getString("externo"));
				lista.add(c);			
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		return lista;
	}
	
	@Override
	public List<Cadastro> pesquisarPorProntuario(String prontuario) {
		List<Cadastro> lista = new ArrayList<>();
		String sql = "SELECT * FROM public.cadastro WHERE prontuario like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + prontuario + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Cadastro c = new Cadastro();
				c.setId(rs.getLong("id"));
				c.setData(rs.getString("data"));
				c.setHora(rs.getString("hora"));
				c.setSetor(rs.getString("nome_setor"));
				c.setCodigo(rs.getString("codigo"));
				c.setProntuario(rs.getString("prontuario"));
				c.setPaciente(rs.getString("paciente"));
				c.setConsulta(rs.getString("nome_exame"));
				c.setProfissional(rs.getString("nome_medico"));
				c.setMotivo(rs.getString("motivo"));
				c.setTelefone1(rs.getString("telefone1"));
				c.setContato1(rs.getString("contato1"));
				c.setSituacao1(rs.getString("situacao1"));
				c.setTelefone2(rs.getString("telefone2"));
				c.setContato2(rs.getString("contato2"));
				c.setSituacao2(rs.getString("situacao2"));
				c.setTelefone3(rs.getString("telefone3"));
				c.setContato3(rs.getString("contato3"));
				c.setSituacao3(rs.getString("situacao3"));
				c.setTelefone4(rs.getString("telefone4"));
				c.setContato4(rs.getString("contato4"));
				c.setSituacao4(rs.getString("situacao4"));
				c.setObser(rs.getString("obser"));
				c.setExterno(rs.getString("externo"));
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public void remover(long id) throws GenericDAOException {
		String sql = "DELETE FROM public.cadastro WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		
	}

	@Override
	public Cadastro pesquisarId(long id) throws GenericDAOException {
		Cadastro c = new Cadastro();
		String sql = "SELECT * FROM public.cadastro WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { 
				c.setId(rs.getLong("id"));
				c.setData(rs.getString("data"));
				c.setHora(rs.getString("hora"));
				c.setSetor(rs.getString("nome_setor"));
				c.setCodigo(rs.getString("codigo"));
				c.setProntuario(rs.getString("prontuario"));
				c.setPaciente(rs.getString("paciente"));
				c.setConsulta(rs.getString("nome_exame"));
				c.setProfissional(rs.getString("nome_medico"));
				c.setMotivo(rs.getString("motivo"));
				c.setTelefone1(rs.getString("telefone1"));
				c.setContato1(rs.getString("contato1"));
				c.setSituacao1(rs.getString("situacao1"));
				c.setTelefone2(rs.getString("telefone2"));
				c.setContato2(rs.getString("contato2"));
				c.setSituacao2(rs.getString("situacao2"));
				c.setTelefone3(rs.getString("telefone3"));
				c.setContato3(rs.getString("contato3"));
				c.setSituacao3(rs.getString("situacao3"));
				c.setTelefone4(rs.getString("telefone4"));
				c.setContato4(rs.getString("contato4"));
				c.setSituacao4(rs.getString("situacao4"));
				c.setObser(rs.getString("obser"));
				c.setExterno(rs.getString("externo"));
			}
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
		return c;
	}

	@Override
	public void salvar(long id, Cadastro c) throws GenericDAOException {
		String sql = "UPDATE public.cadastro SET usuario = ?, data = ?, hora = ?, nome_setor = ?, codigo = ?, prontuario = ?, "
				+ "paciente = ?, nome_exame = ?, nome_medico = ?, motivo = ?, telefone1 = ?, contato1 = ?, situacao1 = ?,"
				+ "telefone2 = ?, contato2 = ?, situacao2 = ?, telefone3 = ?, contato3 = ?, situacao3 = ?, telefone4 = ?,"
				+ "contato4 = ?, situacao4 = ?, obser = ?, externo = ? WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c.getUsuario());
			pstmt.setString(2, c.getData());
			pstmt.setString(3, c.getHora());
			pstmt.setString(4, c.getSetor());
			pstmt.setString(5, c.getCodigo());
			pstmt.setString(6, c.getProntuario());
			pstmt.setString(7, c.getPaciente());
			pstmt.setString(8, c.getConsulta());
			pstmt.setString(9, c.getProfissional());
			pstmt.setString(10, c.getMotivo());
			pstmt.setString(11, c.getTelefone1());
			pstmt.setString(12, c.getContato1());
			pstmt.setString(13, c.getSituacao1());
			pstmt.setString(14, c.getTelefone2());
			pstmt.setString(15, c.getContato2());
			pstmt.setString(16, c.getSituacao2());
			pstmt.setString(17, c.getTelefone3());
			pstmt.setString(18, c.getContato3());
			pstmt.setString(19, c.getSituacao3());
			pstmt.setString(20, c.getTelefone4());
			pstmt.setString(21, c.getContato4());
			pstmt.setString(22, c.getSituacao4());
			pstmt.setString(23, c.getObser());
			pstmt.setString(24, c.getExterno());
			pstmt.setLong(25, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			throw new GenericDAOException( e );
		}
	}
}
