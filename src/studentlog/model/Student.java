package studentlog.model;

import org.eclipse.core.runtime.PlatformObject;

public class Student extends PlatformObject {
	private String name;
	private String group;
	private String address;
	private String city;
	private String result;
	private StudentsGroup parent;
	
	public Student(String name, StudentsGroup parent, String address, String city, String result) {
		super();
		this.name = name;
		this.group = parent.getName();
		this.parent = parent;
		this.address = address;
		this.city = city;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return parent.getName();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public StudentsGroup getParent() {
		return parent;
	}
	
}
