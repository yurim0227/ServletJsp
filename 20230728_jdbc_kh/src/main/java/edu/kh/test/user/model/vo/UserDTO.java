package edu.kh.test.user.model.vo;

public class UserDTO {
//	--------- -------- ------------ 
//	USER_NO   NOT NULL NUMBER       
//	USER_ID   NOT NULL VARCHAR2(50) 
//	USER_NAME NOT NULL VARCHAR2(50) 
//	USER_AGE  NOT NULL NUMBER
	
	private Integer userNo;
	private String userId;
	private String userName;
	private Integer userAge;
	
	public UserDTO() {
	}
	public UserDTO(Integer userNo, String userId, String userName, Integer userAge) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
	}
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	
}
