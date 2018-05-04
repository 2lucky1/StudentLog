package studentlog.model;

import studentlog.model.Student;
import studentlog.model.StudentsGroup;

public class StudentsEntry extends Student {

	private final String name;

	private final String groupNumber;

	private final String address;

	private final String city;

	private final String result;

	private final StudentsGroup group;
	
	public StudentsEntry(String name, String groupNumber, String address, String city, String result,
			StudentsGroup group) {
		super();
		this.name = name;
		this.groupNumber = groupNumber;
		this.address = address;
		this.city = city;
		this.result = result;
		this.group = group;
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

	public StudentsGroup getGroup() {
		return group;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public StudentsGroup getParent() {
		return group;
	}

}
