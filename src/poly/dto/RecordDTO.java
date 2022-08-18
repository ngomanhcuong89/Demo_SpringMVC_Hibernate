package poly.dto;

import java.util.Date;

public class RecordDTO 
{
	private Integer id;
	private boolean type;
	private String reason;
	private Date date;
	private String staffId;
	
	public RecordDTO() {
		super();
	}

	public RecordDTO(Integer id, boolean type, String reason, Date date, String staffId) {
		super();
		this.id = id;
		this.type = type;
		this.reason = reason;
		this.date = date;
		this.staffId = staffId;
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

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
}
