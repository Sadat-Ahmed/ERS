package ers.model;

public class ErsUsers {
	private int ersUserId;
	private String ersUsername;
	private String ersPassword;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private ErsUserRoles userRoleId;
	public int getErsUserId() {
		return ersUserId;
	}
	public void setErsUserId(int ersUserId) {
		this.ersUserId = ersUserId;
	}
	public String getErsUsername() {
		return ersUsername;
	}
	public void setErsUsername(String ersUsername) {
		this.ersUsername = ersUsername;
	}
	public String getErsPassword() {
		return ersPassword;
	}
	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public ErsUserRoles getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(ErsUserRoles userRoleId) {
		this.userRoleId = userRoleId;
	}
	public ErsUsers(int ersUserId, String ersUsername, String userFirstName, String userLastName,
			String userEmail, ErsUserRoles userRoleId) {
		super();
		this.ersUserId = ersUserId;
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleId = userRoleId;
		
	}
	
//	public ErsUsers(int ersUserId){
//		this.ersUserId=ersUserId;
//	}
	
	public ErsUsers() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ErsUsers [ersUserId=" + ersUserId + ", ersUsername=" + ersUsername + ", ersPassword=" + ersPassword
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail=" + userEmail
				+ ", userRoleId=" + userRoleId + "]";
	}
	
	

}
