package org.ffeng.miscellaneous.projects.badminton.bean;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 5503558758167302308L;
	
	private String id;
	private String name;
	
	public User() {
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

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("User: (");
		info.append("id:" + id);
		info.append(", name: " + name);
		info.append(")");
		return info.toString();
	}

}
