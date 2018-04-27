package studentlog.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ListenerList;

public class StudentsGroup extends Student {
	private List<Student> entries;
	
	private StudentsGroup parent;
	
	private String name;
	
	private ListenerList listeners;
	
//	private String fileName = "students.txt";

	public StudentsGroup(StudentsGroup parent, String name) {
		this.parent = parent;
		this.name = name;
//		initialStudentsGroup(fileName);
	}


	@Override
	public String getName() {
		return name;
	}

	@Override
	public StudentsGroup getParent() {
		return parent;
	}

	public void rename(String newName) {
		this.name = newName;
		fireStudentsChanged(null);
	}

	public void addEntry(Student entry) {
		if (entries == null) {
			entries = new ArrayList(5);
		}
		entries.add(entry);
		fireStudentsChanged(null);
	}

	public void removeEntry(Student entry) {
		if (entries != null) {
			entries.remove(entry);
			if (entries.isEmpty()) {
				entries = null;
			}
		}
		fireStudentsChanged(null);
	}

	public Student[] getEntries() {
		if (entries != null)
			return (Student[]) entries.toArray(new Student[entries.size()]);
		return new Student[0];
	}
	
	public void addStudentsListener(IStudentsListener listener) {
		if (parent != null)
			parent.addStudentsListener(listener);
		else {
			if (listeners == null)
				listeners = new ListenerList();
			listeners.add(listener);
		}
	}
	
	public void removeStudentsListener(IStudentsListener listener) {
		if (parent != null)
			parent.removeStudentsListener(listener);
		else {
			if (listeners != null) {
				listeners.remove(listener);
				if (listeners.isEmpty())
					listeners = null;
			}
		}
	}

	protected void fireStudentsChanged(StudentsEntry entry) {
		if (parent != null) {
			parent.fireStudentsChanged(entry);
		} else {
			if (listeners == null) {
				return;
			}
			Object[] rls = listeners.getListeners();
			for (int i = 0; i < rls.length; i++) {
				IStudentsListener listener = (IStudentsListener) rls[i];
				listener.studentsChanged(this, entry);
			}
		}
	}
//	private void initialStudentsGroup(String fileName) {
//		
//		
//	}
	
//	public void setEntries(List<Student> entries) {
//		this.entries = entries;
//	}
}
