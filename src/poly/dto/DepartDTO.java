package poly.dto;

public class DepartDTO 
{
	private String id;
	private String name;
	
	public DepartDTO() {
		super();
	}
	
	public DepartDTO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
}
