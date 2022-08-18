package poly.dto;

public class UserDTO 
{
	private String username;
	private String password;
	private String fullname;
	private boolean isadmin;
	private String staffId;
	
	public UserDTO() {
		super();
	}

	public UserDTO(String username, String password, String fullname, boolean isadmin, String staffId) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.isadmin  = isadmin;
		this.staffId  = staffId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public boolean isIsadmin() {
		return isadmin;
	}

	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
}
