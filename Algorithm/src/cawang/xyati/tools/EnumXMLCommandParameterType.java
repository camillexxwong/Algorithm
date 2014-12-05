package cawang.xyati.tools;

public enum EnumXMLCommandParameterType {
	ATTRIBUTE("attr"),
	METRIC("metric");
	private String type;
	private EnumXMLCommandParameterType(String type){  
		this.type=type;  
	}  
}
