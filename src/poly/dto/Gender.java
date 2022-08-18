package poly.dto;

public class Gender 
{
	private String name;
	private boolean gendervalue;
	
	public Gender() {}
	public Gender(String name, boolean gendervalue) 
	{
		this.name = name;
		this.gendervalue = gendervalue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGendervalue() {
		return gendervalue;
	}
	public void setGendervalue(boolean gendervalue) {
		this.gendervalue = gendervalue;
	}	
	
}
