package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ConnectionSingleton;
import entidade.Usuario;

@WebServlet("/Authenticator")
public class Authenticator extends HttpServlet {
	private static final long serialVersionUID = -8385221883047250218L;
	ConnectionSingleton conSing = ConnectionSingleton.getInstancy();
	Connection con = conSing.getcon();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		HttpSession session = request.getSession();
		String msg = null;
		
		if("Logar".equals(cmd)) {
			String user = request.getParameter("userName");
			String pass = request.getParameter("password");
			Usuario usuario = new Usuario();
			String sql = "SELECT * FROM funcionario WHERE usuario = ? AND senha = ?";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user);
				pstmt.setString(2, pass);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					usuario.setId(rs.getLong("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setNomeUsuario(rs.getString("usuario")); 
					usuario.setSenha(rs.getString("senha"));
				} 
				
				if (usuario.getId() > 0) {
					session.setAttribute("LOGADO", usuario);
					response.sendRedirect("./RegistroLigacao2.jsp");
				} else if (usuario.getNomeUsuario() == "administrador" && usuario.getSenha() == "admin@123" ){
					session.setAttribute("LOGADO", usuario);
					response.sendRedirect("./Home.jsp");
				} else {
					msg = "Usuário ou senha incorretos";
					session.setAttribute("LOGADO", null); 
					response.sendRedirect("./login.jsp");
				}
			} catch (SQLException e) {
				response.sendRedirect("./index.jsp");
			} 
		} else if ("logout".equals(cmd)) {
			session.setAttribute("LOGADO", null); 
			response.sendRedirect("./index.jsp");
		}
	}

}
