package org.toyproject.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.toyproject.model.Member;
import org.toyproject.model.MemberDAO;



public class RegisterMemberController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path = null;
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("address");
	
		Member member = new Member(id, pwd, name, tel, addr, null);
		Member insertMember = MemberDAO.getInstance().registerMember(member);
		
		if(insertMember != null) {
			path = "index.jsp"; 
		}

		return path;
	}

}
