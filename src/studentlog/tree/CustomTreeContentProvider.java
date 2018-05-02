package studentlog.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.ITreeContentProvider;

import studentlog.model.ModelTreeData;
import studentlog.model.Observer;
import studentlog.model.Student;
import studentlog.model.StudentsGroup;

public class CustomTreeContentProvider implements ITreeContentProvider {

	private List<StudentsGroup> items = new ArrayList();
	private Map<String, String[]> contentMap = new HashMap<>();

	public CustomTreeContentProvider() {
//		initMap();
		initList();
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof List) {
			return ((List) inputElement).toArray();
		} else if (inputElement instanceof StudentsGroup) {
			return ((StudentsGroup) inputElement).getEntries();
		}
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return items.get(items.indexOf(parentElement)).getEntries();
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof Student) {
			return ((Student) element).getParent();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof StudentsGroup) {
			return ((StudentsGroup) element).getEntries().length > 0;
		}
		return false;
	}

	private String getParentOfEle(Object element) {
		for (StudentsGroup studentsGroup : items) {
			if (studentsGroup.getName().equals(element)) {
				return studentsGroup.getName();
			}
		}
		return null;
	}

	private void initList() {
		items = ModelTreeData.getInstance().getItems();
	}
	
//	private void initMap() {
//		String[] roots = { "Group1", "Group2" };
//
//		contentMap.put("roots", roots);
//
//		contentMap.put("Group1", new String[] { "Ivan Ivanov", "Petr Petrov" });
//		contentMap.put("Group2", new String[] { "Alex Alexeev", "Nikolai Nikolaev" });
//
//	}
}
