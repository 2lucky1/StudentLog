package studentlog.tree;

import java.util.List;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;

import org.eclipse.jface.viewers.ITreeContentProvider;

import studentlog.model.ITreeItem;

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
		List<?> list = ((ITreeItem) inputElement).getChildren();
		if (list != null) {
			return list.toArray();
		}
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		List<?> list = ((ITreeItem) parentElement).getChildren();
		if (list != null) {
			return list.toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		return ((ITreeItem) element).getParent();
	}

	@Override
	public boolean hasChildren(Object element) {
		return ((ITreeItem) element).hasChildren();
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
