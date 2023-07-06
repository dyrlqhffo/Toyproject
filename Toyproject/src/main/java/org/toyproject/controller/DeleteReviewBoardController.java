package org.toyproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.toyproject.model.BoardDAO;

public class DeleteReviewBoardController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		long no = Long.parseLong(request.getParameter("no"));
		BoardDAO.getInstance().deleteBoard(no);
		
		return "redirect:QA.do";
	}

}
