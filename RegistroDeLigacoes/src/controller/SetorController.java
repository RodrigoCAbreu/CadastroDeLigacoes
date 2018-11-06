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
			}
		} catch (GenericDAOException e) {
			e.printStackTrace();
			msgS = "Erro ao adicionar este cadastro";
		}
		
		session.setAttribute("MENSAGEM", msgS);
		response.sendRedirect("./administracao.jsp");
		
	}

}
