package data.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginFilter implements Filter {
	
	// 필터 제외할 url
	private List<String> excludeURL;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 필터 필요한 url 클래스 내 정의 
		String excludeURLPattern = filterConfig.getInitParameter("excludeURL");
		excludeURL = Arrays.asList(excludeURLPattern.split(","));
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest http_request = (HttpServletRequest) request;
		HttpServletResponse http_response = (HttpServletResponse) response;
		HttpSession session = http_request.getSession();
		
		// 렌더 요청한 url 가져옴 
		String path = ((HttpServletRequest) request).getServletPath();
		
		// 필터 필요한 url 일 때  
		if(!excludeURL.contains(path) && (!path.contains("home")) && (!path.contains("png")) && (!path.contains("signUp"))) {
			String id = (String) session.getAttribute("userId");
			
			// 세션이 없으면 홈 페이지로 이동 
			if(id == null) {
				response.setContentType("text/html; charset=euc-kr");
				
				PrintWriter out = response.getWriter();
				
				// 로그인 진행 알람 후 로그인 페이지로 이동
				out.println("<script>alert('로그인을 진행해주세요.'); location.href = '/'</script>");
				out.flush();
				
				return ;
			}
		}
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {

	}
}
