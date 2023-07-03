package org.toyproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.toyproject.model.Member;
import org.toyproject.model.MemberDAO;

public class LoginAjaxController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		Member member = MemberDAO.getInstance().login(id, pwd);
 		JSONObject json = new JSONObject();
		if(member != null) { //로그인이 됨.
			json.put("jsonResult", "ok");//존재하는 계정
			json.put("jsonMember", new JSONObject(member));
		}else{//존재하지 않는 회원 or 비밀번호 틀림.
			json.put("jsonResult", "no");
		}
		
		request.setAttribute("responsebody", json);
		
		return "AjaxView";
	}
}
