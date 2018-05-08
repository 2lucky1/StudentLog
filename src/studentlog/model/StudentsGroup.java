package studentlog.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ListenerList;

public class StudentsGroup extends Student {
	
	private String name;
	
	transient private StudentsGroup parent;
	
	private List<Student> children;
	
	transient private ListenerList listeners;
	
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

	public void addEntry(Student childe) {
		if (children == null) {
			children = new ArrayList<Student>(5);
		}
		children.add(childe);
		fireStudentsChanged(null);
	}

	public void removeEntry(Student childe) {
		if (children != null) {
			children.remove(childe);
			if (children.isEmpty()) {
				children = null;
			}
		}
		fireStudentsChanged(null);
	}

	public List<Student> getChildren() {
		/*if (entries != null) {
			return (Student[]) entries.toArray(new Student[entries.size()]);
		}
		return new Student[0];*/
		return children != null ? children : new ArrayList<Student>();
	}
	
	public void addStudentsListener(IStudentsListener listener) {
		if (parent != null) {
			parent.addStudentsListener(listener);
		}
		else {
			if (listeners == null)
				listeners = new ListenerList();
			listeners.add(listener);
		}
	}
	
	public void removeStudentsListener(IStudentsListener listener) {
		if (parent != null) {
			parent.removeStudentsListener(listener);
		}
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
