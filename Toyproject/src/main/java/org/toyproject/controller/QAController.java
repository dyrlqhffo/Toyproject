package org.toyproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.toyproject.model.Board;
import org.toyproject.model.BoardDAO;

public class QAController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Board> list = BoardDAO.getInstance().boardList();
		request.setAttribute("list", list);
		return "qa/board-list.jsp";
	}

}
