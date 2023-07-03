package org.toyproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.toyproject.model.Member;
import org.toyproject.model.MemberDAO;

public class RegisterAjaxController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		Member member = MemberDAO.getInstance().findMemberById(id);
		JSONObject json = new JSONObject();
		if(member != null) {
			json.put("jsonResult", "ok");
		}
		
		request.setAttribute("responsebody", json);
		return "AjaxView";
	}
	
}
