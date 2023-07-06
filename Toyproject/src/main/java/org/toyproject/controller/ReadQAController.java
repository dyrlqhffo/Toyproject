package org.toyproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.toyproject.model.Board;
import org.toyproject.model.BoardDAO;

public class ReadQAController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path = null;
		long no = Long.parseLong(request.getParameter("no"));
		Board board = BoardDAO.getInstance().findBoardByNo(no);
		if(board != null) {
			request.setAttribute("board", board);
			path = "qa/read-board.jsp";
		}else {
			path = "error.jsp";
		}
		
		return path;
	}

}
