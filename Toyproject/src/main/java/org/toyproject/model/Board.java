package org.toyproject.model;

public class Board {
	
	private long boardNo;
	private Member member;
	private String title;
	private String content;
	private String regDate;
	private String editDate;
	private long hits;
	private String boardType;
	
	public Board() {
		super();
	}

	public Board(long boardNo, Member member, String title, String content, String regDate, String editDate, long hits,
			String boardType) {
		super();
		this.boardNo = boardNo;
		this.member = member;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.editDate = editDate;
		this.hits = hits;
		this.boardType = boardType;
	}

	public long getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(long boardNo) {
		this.boardNo = boardNo;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	public long getHits() {
		return hits;
	}

	public void setHits(long hits) {
		this.hits = hits;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", member=" + member + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", editDate=" + editDate + ", hits=" + hits + ", boardType=" + boardType
				+ "]";
	}
	
	

}
