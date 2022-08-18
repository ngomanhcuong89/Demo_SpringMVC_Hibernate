package poly.dto;

public class AdminDTO 
{
	private String 	name;
	private boolean result;
	
	public AdminDTO() {}
	public AdminDTO(String name, boolean result) 
	{
		this.name = name;
		this.result = result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	
}
