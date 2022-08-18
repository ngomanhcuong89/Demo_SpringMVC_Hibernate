package poly.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Records")
public class RecordEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;
	
	@Column(name="Type")
	private boolean type;
	
	@Column(name="Reason")
	private String reason;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/YYYY")
	@Column(name="Date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "StaffId")
	private StaffEntity staff;
	
	public RecordEntity() {}

	public RecordEntity(Integer id, boolean type, String reason, Date date, StaffEntity staff) {
		super();
		this.id = id;
		this.type = type;
		this.reason = reason;
		this.date = date;
		this.staff = staff;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StaffEntity getStaff() {
		return staff;
	}

	public void setStaff(StaffEntity staff) {
		this.staff = staff;
	}
	
	
}
