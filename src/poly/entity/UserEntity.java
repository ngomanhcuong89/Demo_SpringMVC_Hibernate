package poly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class UserEntity 
{
	@Id
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Fullname")
	private String fullname;
	
	@Column(name="IsAdmin")
	private boolean isadmin;
	
	@ManyToOne
	@JoinColumn(name = "StaffId")
	private StaffEntity staff;
	
	public UserEntity() {}
	public UserEntity(String username, String password, String fullname, boolean isadmin, StaffEntity staff) 
	{
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.isadmin  = isadmin;
		this.staff	  = staff;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getUsername() 
	{
		return this.username;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getPassword() 
	{
		return this.password;
	}
	
	public void setFullname(String fullname) 
	{
		this.fullname = fullname;
	}
	public String getFullname() 
	{
		return this.fullname;
	}
	
	public boolean isIsadmin() {
		return isadmin;
	}
	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}
	
	public StaffEntity getStaff() {
		return staff;
	}
	public void setStaff(StaffEntity staff) {
		this.staff = staff;
	}
	
	
}
