package com.example.travel.filter;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/*"})
public class CheckLoginFilter extends HttpFilter{
	
	private static List<String> whitelists = List.of("/login", "/travelrecord/register");
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {		
		
		String servletPath = request.getServletPath();
		if(whitelists.contains(servletPath)) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		if(session == null || session.getAttribute("memberDTO") == null) {
			response.sendRedirect("/login");
			return;
		}
		
		chain.doFilter(request, response);
	}
}
