package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
       
    public CadastroController() {
        super();
        
    }

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
			}
		} catch (GenericDAOException e) {
			
			e.printStackTrace();
		}
	}

}
