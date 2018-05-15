package studentlog.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ListenerList;

public class StudentsGroup extends TreeItem {
	
	private String name;
	
	private StudentsGroup parent;
	
	private List<TreeItem> children;
	
	transient private ListenerList listeners;
	
//	private String fileName = "students.txt";
	
	public StudentsGroup() {};

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

	
	
	public ListenerList getListeners() {
		return listeners;
	}

	public void setListeners(ListenerList listeners) {
		this.listeners = listeners;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(StudentsGroup parent) {
		this.parent = parent;
	}

	public void setChildren(List<TreeItem> children) {
		this.children = children;
	}

	public void rename(String newName) {
		this.name = newName;
		fireStudentsChanged(null);
	}

	public void addEntry(TreeItem childe) {
		if (children == null) {
			children = new ArrayList<TreeItem>(5);
		}
		children.add(childe);
		fireStudentsChanged(null);
	}

	public void removeEntry(TreeItem childe) {
		if (children != null) {
			children.remove(childe);
			if (children.isEmpty()) {
				children = null;
			}
		}
		fireStudentsChanged(null);
	}

	public List<TreeItem> getChildren() {
		/*if (entries != null) {
			return (Student[]) entries.toArray(new Student[entries.size()]);
		}
		return new Student[0];*/
		return children != null ? children : new ArrayList<TreeItem>();
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
	
	
//	public void initParent() {
//		if(this.getChildren().size()>0) {
//			StudentsGroup parent = this;
//			for(TreeItem treeItem:parent.getChildren()) {
//				if(treeItem instanceof StudentsGroup) {
//					((StudentsGroup) treeItem).initParent();
//				}
//				treeItem.setParent(parent);
//			}
//		}
//	}
//	private void initialStudentsGroup(String fileName) {
//		
//		
//	}
	
//	public void setEntries(List<Student> entries) {
//		this.entries = entries;
//	}
}
