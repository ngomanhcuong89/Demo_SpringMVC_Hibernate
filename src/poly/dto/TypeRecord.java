package poly.dto;

public class TypeRecord 
{
	private String name;
	private boolean typevalue;
	
	public TypeRecord() {}
	public TypeRecord(String name, boolean typevalue) 
	{
		this.name = name;
		this.typevalue = typevalue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isTypevalue() {
		return typevalue;
	}
	public void setTypevalue(boolean typevalue) {
		this.typevalue = typevalue;
	}
}
