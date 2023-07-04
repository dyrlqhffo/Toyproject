package org.toyproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BoardDAO {
	private static BoardDAO instance=new BoardDAO();
	private DataSource dataSource;
	private BoardDAO() {
		this.dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static BoardDAO getInstance()   {			
		return instance;
	}
	public void closeAll(PreparedStatement ps,Connection con) throws SQLException {
		if(ps!=null)
			ps.close();
		if(con!=null)
			con.close(); // connection을 dbcp에 반환한다 
	}
	public void closeAll(ResultSet rs,PreparedStatement ps,Connection con) throws SQLException {
		if(rs!=null)
			rs.close();
		closeAll(ps, con);
	}
	public List<Board> boardList() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<>();
		
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT B.BOARD_NO, M.ID, B.TITLE, B.CONTENT, TO_CHAR(B.REG_DATE, 'YY.MM.DD HH24:MI') ");
			sb.append("AS REG_DATE, TO_CHAR(B.EDIT_DATE, 'YY.MM.DD HH24:MI')AS EDIT_DATE, B.HITS, B.BOARD_TYPE ");
			sb.append("FROM BOARDBOARD B INNER JOIN MEMBERMEMBER M ON B.ID = M.ID ORDER BY B.BOARD_NO DESC");
			ps = con.prepareStatement(sb.toString());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getLong("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getString("reg_date"));
				board.setEditDate(rs.getString("edit_date"));
				board.setHits(rs.getLong("hits"));
				board.setBoardType(rs.getString("board_type"));
				Member member = new Member();
				member.setId(rs.getString("id"));
				board.setMember(member);
				list.add(board);
			}
		}finally {
			closeAll(rs, ps, con);
		}
		
		return list;
	}
	
	

}
