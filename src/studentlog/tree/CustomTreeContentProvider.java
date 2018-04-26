package studentlog.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.ITreeContentProvider;

public class CustomTreeContentProvider implements ITreeContentProvider {

	private Map<String, String[]> contentMap = new HashMap<>();

	public CustomTreeContentProvider() {
		initMap();
	}

	private void initMap() {
		String[] roots = { "Group1", "Group2" };

		contentMap.put("roots", roots);

		contentMap.put("Group1", new String[] { "Ivan Ivanov", "Petr Petrov" });
		contentMap.put("Group2", new String[] { "Alex Alexeev", "Nikolai Nikolaev" });
		
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return contentMap.get("roots");
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return contentMap.get(parentElement);
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return getParentOfEle(element);
	}

	@Override
	public boolean hasChildren(Object element) {
		return contentMap.containsKey(element);
	}

	private String getParentOfEle(Object element) {
		Set<String> keys = contentMap.keySet();

		for (String key : keys) {
			String[] values = contentMap.get(key);

			for (String val : values) {
				if (val.equals(element)) {
					return key;
				}
			}
		}
		return null;
	}

}
