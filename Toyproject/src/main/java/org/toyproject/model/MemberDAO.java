package org.toyproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
/*
 * Singleton Design Pattern : 시스템 상에서 단 한번 하나의 객체를 생성해서
 * 								  여러 곳에서 공유해 사용하는 설계 패턴 
 */
public class MemberDAO {
	private static MemberDAO instance=new MemberDAO();
	private DataSource dataSource;
	private MemberDAO() {
		this.dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static MemberDAO getInstance()   {			
		return instance;
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException {
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close(); // connection을 dbcp에 반환한다 
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException {
		if(rs!=null)
			rs.close();
		closeAll(pstmt, con);
	}
	public Member registerMember(Member mem) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		Member member = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "insert into membermember(id, password, name, tel, address, reg_date) values(?,?,?,?,?,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, mem.getId());
			ps.setString(2, mem.getPassword());
			ps.setString(3, mem.getName());
			ps.setString(4, mem.getTel());
			ps.setString(5, mem.getAddress());
			int num =ps.executeUpdate();
			
			if(num != 0) {
				member = mem;
			}
		}finally {
			closeAll(ps, con);
		}
		return member;
	}
	public Member login(String id, String pwd) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select id, password, name, tel, address, to_char(reg_date, 'yy.mm.dd') as reg_date from membermember where id=? and password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				member = new Member(id, pwd, rs.getString("name"), rs.getString("tel"), rs.getString("address"), rs.getString("reg_date"));
			}
		}finally {
			closeAll(rs, ps, con);
		}
		return member;
	}
	
	public Member findMemberById(String id) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select id, password, name, tel, address, to_char(reg_date, 'yy.mm.dd')as reg_date from membermember where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				member = new Member(id, rs.getString("password"), rs.getString("name"), rs.getString("tel"), rs.getString("address"), rs.getString("reg_date"));
			}
		}finally {
			closeAll(rs, ps, con);
		}
		return member;
	}
	
	
}


























