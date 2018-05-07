package studentlog.tree;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;

import org.eclipse.jface.viewers.ITreeContentProvider;

import studentlog.model.Student;
import studentlog.model.StudentsGroup;

public class CustomTreeContentProvider implements ITreeContentProvider {

//	private Map<String, String[]> contentMap = new HashMap<>();
//	private List<StudentsGroup> contentList = new ArrayList();

	// public CustomTreeContentProvider() {
	//// initMap();
	// }

	// private void initMap() {
	// String[] roots = { "Group1", "Group2" };
	//
	// contentMap.put("roots", roots);
	//
	// contentMap.put("Group1", new String[] { "Ivan Ivanov", "Petr Petrov" });
	// contentMap.put("Group2", new String[] { "Alex Alexeev", "Nikolai Nikolaev"
	// });
	//
	// }

	@Override
	public Object[] getElements(Object inputElement) {
		return (Object[])((StudentsGroup) inputElement).getEntries();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof StudentsGroup) {
			return ((StudentsGroup) parentElement).getEntries();
		}
		System.out.println("Elment has no children");
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// // TODO Auto-generated method stub
		// return getParentOfEle(element);
		if (element instanceof Student) {
			return ((Student) element).getParent();
		}
		System.out.println("Element has no parent (CustomTreeContentProvider)");
		return null;

	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof StudentsGroup) {
			return ((StudentsGroup) element).getEntries().length > 0;
		}
		return false;
	}

	// private String getParentOfEle(Object element) {
	// Set<String> keys = contentMap.keySet();
	//
	// for (String key : keys) {
	// String[] values = contentMap.get(key);
	//
	// for (String val : values) {
	// if (val.equals(element)) {
	// return key;
	// }
	// }
	// }
	// return null;
	// }

}
