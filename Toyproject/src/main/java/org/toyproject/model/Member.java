package org.toyproject.model;

import java.io.Serializable;
/**
 *  WAS는 reloading시에 ( java code 수정시 ) 
 *  session 정보를 파일에 직렬화하여 저장한 후 다시 load가 되면
 *  역직렬화해서 session 정보를 복원한다.
 *  만약 session의 attribute에 MemberVO와 같은 인증 정보가 존재하면
 *  해당 클래스도 직렬화 되기 위해 implements Serializable 해서 함께 외부 전송될 수 있도록 
 *  한다. => 개발 단계에서 자바코드가 수정되어 WAS reload 되어도 로그인 해제되지 않고
 *  계속 유지되는 상태로 개발을 계속 진행할 수 있다.
 *  
 *  운영시에는 서버 프로그램 수정 후 리로드 시에 사용자 정보를 유지할 수 있다.
 */
public class Member implements Serializable {
	private static final long serialVersionUID = -3972768952288329070L;
	private String id;
	private String password;
	private String name;
	private String tel;
	private String address;
	private String reg_date;
	
	public Member() {
		super();
	}

	public Member(String id, String password, String name, String tel, String address, String reg_date) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.reg_date = reg_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", tel=" + tel + ", address="
				+ address + ", reg_date=" + reg_date + "]";
	}

	
	
	
	
	
}
