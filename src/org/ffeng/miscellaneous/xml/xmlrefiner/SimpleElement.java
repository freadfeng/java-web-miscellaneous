package org.ffeng.miscellaneous.xml.xmlrefiner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleElement {
	private String name;
	private Map<String, String> attributeMap;
	private String text;
	private List<SimpleElement> children;
	
	public SimpleElement() {
		this.attributeMap = new HashMap<String, String>();
		this.children = new ArrayList<SimpleElement>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getAttributeMap() {
		return attributeMap;
	}
	public void setAttributeMap(Map<String, String> attributeMap) {
		this.attributeMap = attributeMap;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<SimpleElement> getChildren() {
		return children;
	}
	public void setChildren(List<SimpleElement> children) {
		this.children = children;
	}
	
	
}
