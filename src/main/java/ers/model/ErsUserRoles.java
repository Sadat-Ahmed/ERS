package ers.model;

public class ErsUserRoles {
	
	private int userRoleId;
	private String userRole;
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public ErsUserRoles(int userRoleId, String userRole) {
		super();
		this.userRoleId = userRoleId;
		this.userRole = userRole;
	}
	public ErsUserRoles() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ErsUserRoles [userRoleId=" + userRoleId + ", userRole=" + userRole + "]";
	}
	
	
	

}
