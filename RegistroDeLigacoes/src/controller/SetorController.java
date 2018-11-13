package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.GenericDAOException;
import dao.SetorDAO;
import dao.SetorDAOImpl;
import entidade.Setor;

@WebServlet("/SetorController")
public class SetorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmdS");
		String msgS = null;
		HttpSession session = request.getSession();
		try {
			SetorDAO sDao = new SetorDAOImpl();
			if ("adicionar".equals(cmd)){
				Setor s = new Setor();
				s.setSetor(request.getParameter("nomeSetor"));
				sDao.adicionaSetor(s);
				msgS = "Cadastro adicionado com sucesso";
			} else if ("pesquisar".equals(cmd)) {
				List<Setor> listaS = sDao.pesquisarSetor(request.getParameter("nomeSetor"));
				session.setAttribute("LISTA", listaS);
				msgS = "Foi encontrado " + listaS.size() + " cadastro";
			} else if ("remover".equals(cmd)) {
				String id = request.getParameter("idSetor");
				sDao.remover(Long.parseLong(id));
				msgS = "Setor com o Id " + id + " foi removido";
				List<Setor> listaS = sDao.pesquisarSetor("");
				session.setAttribute("LISTA", listaS);				
			} else if ("editar".equals(cmd)) {
				String id = request.getParameter("idSetor");
				Setor s = sDao.pesquisarPorId(Long.parseLong(id));
				session.setAttribute("SETOR_ATUAL", s);
				msgS = "Detalhes do Setor com o Id " + id;
			} else if ("salvar".equals(cmd)) {
				Setor s = new Setor();
				String id = request.getParameter("idSetor");
				s.setSetor(request.getParameter("nomeSetor"));
				sDao.salvar( Long.parseLong(id), s );
				List<Setor> listaS = sDao.pesquisarSetor("");
				session.setAttribute("LISTA", listaS);				
				msgS = "Setor atualizado com sucesso";
			} 
		} catch (GenericDAOException e) {
			e.printStackTrace();
			msgS = "Erro ao adicionar este cadastro";
		}
		
		session.setAttribute("MENSAGEM", msgS);
		response.sendRedirect("./CadastroSetor.jsp");
		
	}

}
