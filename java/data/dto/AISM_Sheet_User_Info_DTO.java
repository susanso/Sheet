package data.dto;



public class AISM_Sheet_User_Info_DTO {
	private String userId;
	private String userName;
	private String userPwd;
	
	public AISM_Sheet_User_Info_DTO() {
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
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
}