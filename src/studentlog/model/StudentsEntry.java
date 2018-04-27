package studentlog.model;

public class StudentsEntry {
	private final String name;
	private final StudentsGroup group;

	public StudentsEntry(StudentsGroup group, String name, String nickname, String server) {
		this.group = group;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public StudentsGroup getParent() {
		return group;
	}
}
