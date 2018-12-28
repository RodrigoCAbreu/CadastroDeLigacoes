package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.CadastroDAO;
import dao.CadastroDAOImpl;
import dao.GenericDAOException;
import entidade.Cadastro;

@WebServlet("/CadastroController")
public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String msg = null;
		HttpSession session = request.getSession();
		try {
			CadastroDAO cDao = new CadastroDAOImpl();
			if ("adicionar".equals(cmd)) {
				Cadastro c = new Cadastro();
				c.setUsuario(request.getParameter("usuario"));
				c.setData(request.getParameter("data"));
				c.setHora(request.getParameter("hora"));
				c.setSetor(request.getParameter("setor"));
				c.setCodigo(request.getParameter("codigo"));
				c.setProntuario(request.getParameter("prontuario"));
				c.setPaciente(request.getParameter("paciente"));
				c.setConsulta(request.getParameter("consulta"));
				c.setProfissional(request.getParameter("profissional"));
				c.setMotivo(request.getParameter("motivo"));
				c.setTelefone1(request.getParameter("telefone1"));
				c.setContato1(request.getParameter("contato1"));
				c.setSituacao1(request.getParameter("situacao1"));
				c.setTelefone2(request.getParameter("telefone2"));
				c.setContato2(request.getParameter("contato2"));
				c.setSituacao2(request.getParameter("situacao2"));
				c.setTelefone3(request.getParameter("telefone3"));
				c.setContato3(request.getParameter("contato3"));
				c.setSituacao3(request.getParameter("situacao3"));
				c.setTelefone4(request.getParameter("telefone4"));
				c.setContato4(request.getParameter("contato4"));
				c.setSituacao4(request.getParameter("situacao4"));
				c.setObser(request.getParameter("obser"));
				c.setExterno(request.getParameter("externo"));
				cDao.adicionar(c);
				msg = "Cadastro adicionado com sucesso";
			} else if ("pesquisarC".equals(cmd)) {
				List<Cadastro> lista = cDao.pesquisarPorCodigo(request.getParameter("codigo"));
				session.setAttribute("LISTA", lista);
				msg = "Foi encontrado " + lista.size() + " cadastro";
			} else if ("pesquisarP".equals(cmd)) {
				List<Cadastro> lista = cDao.pesquisarPorProntuario(request.getParameter("prontuario"));
				session.setAttribute("LISTA", lista);
				msg = "Foi encontrado " + lista.size() + " cadastro";
			} else if ("remover".equals(cmd)) {
				long id = Long.parseLong(request.getParameter("id"));
				cDao.remover(id);
				msg = "Cadastro removido com sucesso";
				List<Cadastro> lista = cDao.pesquisarPorCodigo("");
				session.setAttribute("LISTA", lista);
			} else if ("editar".equals(cmd)) {
				long id = Long.parseLong(request.getParameter("id"));
				Cadastro c = cDao.pesquisarId(id);
				session.setAttribute("CADASTRO_ATUAL", c);
				msg = "Detalhes do Cadastro, edite as informações necessárias";
			} else if ("salvar".equals(cmd)) {
				Cadastro c = new Cadastro();
				long id = Long.parseLong(request.getParameter("id"));
				c.setUsuario(request.getParameter("usuario"));
				c.setData(request.getParameter("data"));
				c.setHora(request.getParameter("hora"));
				c.setSetor(request.getParameter("setor"));
				c.setCodigo(request.getParameter("codigo"));
				c.setProntuario(request.getParameter("prontuario"));
				c.setPaciente(request.getParameter("paciente"));
				c.setConsulta(request.getParameter("consulta"));
				c.setProfissional(request.getParameter("profissional"));
				c.setMotivo(request.getParameter("motivo"));
				c.setTelefone1(request.getParameter("telefone1"));
				c.setContato1(request.getParameter("contato1"));
				c.setSituacao1(request.getParameter("situacao1"));
				c.setTelefone2(request.getParameter("telefone2"));
				c.setContato2(request.getParameter("contato2"));
				c.setSituacao2(request.getParameter("situacao2"));
				c.setTelefone3(request.getParameter("telefone3"));
				c.setContato3(request.getParameter("contato3"));
				c.setSituacao3(request.getParameter("situacao3"));
				c.setTelefone4(request.getParameter("telefone4"));
				c.setContato4(request.getParameter("contato4"));
				c.setSituacao4(request.getParameter("situacao4"));
				c.setObser(request.getParameter("obser"));
				c.setExterno(request.getParameter("externo"));
				cDao.salvar(id, c);
				List<Cadastro> lista = cDao.pesquisarPorCodigo("");
				session.setAttribute("LISTA", lista);				
				msg = "Cadastro foi atualizado com sucesso";
				} 
			} catch (GenericDAOException e) {
			e.printStackTrace();
			msg = "Erro ao adicionar este cadastro";
			}
		
		session.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./RegistroLigacao.jsp");
	}

}
