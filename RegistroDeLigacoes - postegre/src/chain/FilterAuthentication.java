package chain;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidade.Usuario;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }, urlPatterns = { "*" })
public class FilterAuthentication implements Filter {

    public FilterAuthentication() {
    	
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Usuario user = (Usuario)session.getAttribute("LOGADO");
		HttpServletResponse res = (HttpServletResponse)response;
		String pagina = req.getServletPath();
	
		if ("/index.jsp".equals(pagina) ||
			"/Authenticator".equals(pagina) ||
			"/css/bootstrap.css".equals(pagina) || 
			"/js/jquery-3.3.1.min.js".equals(pagina) ||
			"/js/bootstrap.min.js".equals(pagina) ) { 
			chain.doFilter(request, response);
		}  else if (user != null && user.getId() > 0) { 
			chain.doFilter(request, response);
		} else { 
			session.setAttribute("msg","Você não está logado no sistema!"); 
			res.sendRedirect("./index.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
