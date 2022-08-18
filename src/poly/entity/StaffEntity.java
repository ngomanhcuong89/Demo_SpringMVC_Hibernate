package poly.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Staffs")
public class StaffEntity 
{
	@Id
	@Column(name="Id")
	private String id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Gender")
	private boolean gender;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/YYYY")
	@Column(name="Birthday")
	private Date birthday;
	
	@Column(name="Photo")
	private String photo;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="Salary")
	private Float salary;
	
	@Column(name="Notes")
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "DepartId")
	private DepartEntity depart;
	
	@OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
	private Collection<RecordEntity> records;
	
	@OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
	private Collection<UserEntity> users;
	
	public StaffEntity() {}

	public StaffEntity(String id, String name, boolean gender, Date birthday, String photo, String email, String phone,
			Float salary, String note, DepartEntity depart, Collection<RecordEntity> records, Collection<UserEntity> users) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.photo = photo;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.note = note;
		this.depart = depart;
		this.records = records;
		this.users = users;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public DepartEntity getDepart() {
		return depart;
	}

	public void setDepart(DepartEntity depart) {
		this.depart = depart;
	}

	public Collection<RecordEntity> getRecords() {
		return records;
	}

	public void setRecords(Collection<RecordEntity> records) {
		this.records = records;
	}

	public Collection<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserEntity> users) {
		this.users = users;
	}
}
