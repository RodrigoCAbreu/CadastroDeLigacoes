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
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.Usuario;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmdU");
		String msgU = null;
		HttpSession session = request.getSession();
		try {
			UsuarioDAO uDao = new UsuarioDAOImpl();
			if ("adicionar".equals(cmd)){
				Usuario u = new Usuario();
				u.setNome(request.getParameter("nome"));
				u.setNomeUsuario(request.getParameter("nomeUsuario"));
				u.setSenha(request.getParameter("password"));
				uDao.adicionaUsuario(u);
				msgU = "Cadastro adicionado com sucesso";
			} else if ("pesquisar".equals(cmd)) {
				List<Usuario> listaU = uDao.pesquisarUsuario(request.getParameter("nome"));
				session.setAttribute("LISTA", listaU);
				msgU = "Foi encontrado " + listaU.size() + " cadastro";
			}
		} catch (GenericDAOException e) {
			e.printStackTrace();
			msgU = "Erro ao adicionar este cadastro";
		}
		
		session.setAttribute("MENSAGEM", msgU);
		response.sendRedirect("./administracao.jsp");
	}

}
