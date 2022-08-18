package poly.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Departs")
public class DepartEntity 
{
	@Id
	@Column(name="Id")
	private String id;
	
	@Column(name="Name")
	private String name;

	@OneToMany(mappedBy = "depart", fetch = FetchType.EAGER)
	private Collection<StaffEntity> staffs;

	public DepartEntity() {}
	
	public DepartEntity(String id, String name) 
	{
		this.id = id;
		this.name = name;
	}	

	public DepartEntity(String id, String name, Collection<StaffEntity> staffs) 
	{
		this.id = id;
		this.name = name;
		this.staffs = staffs;
	}

	public void setId(String id) 
	{
		this.id = id;
	}
	public String getId() 
	{
		return this.id;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getName() 
	{
		return this.name;
	}

	public Collection<StaffEntity> getStaffs() {
		return staffs;
	}
	public void setStaffs(Collection<StaffEntity> staffs) {
		this.staffs = staffs;
	}

}
