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
import dao.MedicoDAO;
import dao.MedicoDAOImpl;
import entidade.Medico;


@WebServlet("/MedicoController")
public class MedicoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmdM");
		String msg = null;
		HttpSession session = request.getSession();
		try {
			MedicoDAO mDao = new MedicoDAOImpl();
			if ("adicionar".equals(cmd)){
				Medico m = new Medico();
				m.setNome(request.getParameter("nomeMedico"));
				mDao.adicionaMedico(m);
				msg = "Cadastro adicionado com sucesso";
			} else if ("pesquisar".equals(cmd)) {
				List<Medico> lista = mDao.pesquisarMedico(request.getParameter("nomeMedico"));
				session.setAttribute("LISTA", lista);
				msg = "Foi encontrado " + lista.size() + " cadastro";
			} else if ("remover".equals(cmd)) {
				String id = request.getParameter("idMedico");
				mDao.remover(Long.parseLong(id));
				msg = "Médico com o Id " + id + " foi removido";
				List<Medico> lista = mDao.pesquisarMedico("");
				session.setAttribute("LISTA", lista);				
			} else if ("editar".equals(cmd)) {
				String id = request.getParameter("idMedico");
				Medico m = mDao.pesquisarPorId(Long.parseLong(id));
				session.setAttribute("MEDICO_ATUAL", m);
				msg = "Detalhes do médico com o Id " + id;
			} else if ("salvar".equals(cmd)) {
				Medico m = new Medico();
				String id = request.getParameter("idMedico");
				m.setNome(request.getParameter("nomeMedico"));
				mDao.salvar( Long.parseLong(id), m );
				List<Medico> lista = mDao.pesquisarMedico("");
				session.setAttribute("LISTA", lista);				
				msg = "O Cadastro do médico foi atualizado com sucesso";
			} 
		} catch (GenericDAOException e) {
			e.printStackTrace();
			msg = "Erro ao adicionar este cadastro";
		}
		
		session.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./CadastroMedico.jsp");
		
	}

}
