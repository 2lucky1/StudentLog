package studentlog.model;

import studentlog.model.Student;
import studentlog.model.StudentsGroup;

public class StudentsEntry extends TreeItem {

	private  String name;

	private  String groupNumber;

	private  String address;

	private  String city;

	private  String result;

	transient private  StudentsGroup parent;
	
	public StudentsEntry(){
		
	}
	
	public StudentsEntry(String name, String groupNumber, String address, String city, String result,
			StudentsGroup group) {
		super();
		this.name = name;
		this.groupNumber = groupNumber;
		this.address = address;
		this.city = city;
		this.result = result;
		this.parent = group;
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
		return parent;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public StudentsGroup getParent() {
		return parent;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setParent(StudentsGroup parent) {
		this.parent = parent;
	}
	
	

}
