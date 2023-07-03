package org.toyproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.toyproject.model.Member;
import org.toyproject.model.MemberDAO;

public class LoginController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String path = null;
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		
		Member member = MemberDAO.getInstance().login(id,pwd);
		if(member != null) {
			session.setAttribute("member", member);
			path = "redirect:index.jsp";
		}
		
		
		return path;
	}

}
