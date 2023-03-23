package in.ac.dayalbagh;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


public class Hideetage implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain  filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
HttpServletRequest req = (HttpServletRequest)request;
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
//        httpResponse.setHeader("Content-Security-Policy", "default-src 'self';style-src 'unsafe-inline'"
//        		+ "  https://admission.dei.ac.in:8443;img-src http://* 'self' data: ;"
//        		+ "font-src 'self' data:");
		
     httpResponse.setHeader("Content-Security-Policy", "default-src 'unsafe-inline' 'self';style-src "
		+ "  'unsafe-inline' https://admission.dei.ac.in:8443;img-src http://* 'self' data: ;"
		+ "font-src 'self' data:");	
		
		
	 System.out.println(req.getHeader("User-Agent"));
		
	 filterChain.doFilter(request, new HttpServletResponseWrapper((HttpServletResponse) httpResponse) {
			 public void setHeader(String name, String value) {
		          if (!"etag".equalsIgnoreCase(name)) {
		              super.setHeader(name, value);
		          }
		      }
			
		});
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
