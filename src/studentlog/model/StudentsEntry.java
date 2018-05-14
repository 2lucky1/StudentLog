package studentlog.model;

import studentlog.model.Student;
import studentlog.model.StudentsGroup;

public class StudentsEntry extends TreeItem {

	private final String name;

	private final String groupNumber;

	private final String address;

	private final String city;

	private final String result;

	private final String  parent;
	
	public StudentsEntry(String parent, String name, String address, String city, String result) {
		super();
		this.name = name;
		this.groupNumber = parent;
		this.address = address;
		this.city = city;
		this.result = result;
		this.parent = parent;
	}

	
	public String getGroupNumber() {
		return groupNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getResult() {
		return result;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getParent() {
		return parent;
	}

}
