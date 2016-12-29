package main.java.portfolio.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (isAuthorized(request)) {
			return true;			
		} else {
			response.setStatus(403);
			return false;
		}
	}
	
	boolean isAuthorized(HttpServletRequest request) {
		return request.getMethod().equals("OPTIONS") || 
				((request.getHeader("portfolio-authorization") != null) && 
				(request.getHeader("portfolio-authorization").equals(System.getenv("PORTFOLIO_AUTHORIZATION_SECRET"))));
	}
}