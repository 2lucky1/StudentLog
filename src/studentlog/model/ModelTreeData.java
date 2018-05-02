package studentlog.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ModelTreeData implements Observable {
	private List<Observer> observers = new ArrayList<Observer>();
	private List<StudentsGroup> items;
//	private LogFileAccessManager logFileAccessManager;
	private String fileName = "log.txt";
	private static ModelTreeData instance;

	private ModelTreeData() {
		super();
		initTreeModel(fileName);
	}

	public static ModelTreeData getInstance() {
		if (instance == null) {
			instance = new ModelTreeData();
		}
		return instance;
	}

	public void addObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	public void notifyObservers(List<Observer> observers) {
		for (Observer observer : observers) {
			observer.update(items);
		}
	}

	public List<StudentsGroup> getItems() {
		return items;
	}

	public void setItems(List<StudentsGroup> items) {
		this.items = items;
		notifyObservers(observers);
	}

	private void initTreeModel(String fileName) {
		StudentsGroup group1 = new StudentsGroup(null, "Group1");
		group1.addEntry(new Student("Ivan Ivanov", group1, "Gogolya street, 25", "Dnepr", "5"));
		group1.addEntry(new Student("Petr Petrov", group1, "Gogolya street, 10", "Dnepr", "4"));
		
		StudentsGroup group2 = new StudentsGroup(null, "Group2");
		group2.addEntry(new Student("Alex Alexeev", group2, "Gogolya street, 8", "Dnepr", "3"));
		group2.addEntry(new Student("Nikolay Nikolayev", group2, "Gogolya street, 5", "Dnepr", "2"));

		items = new ArrayList();
		items.add(group1);
		items.add(group2);
//		contentMap.put("roots", roots);

//		contentMap.put("Group1", new String[] { "Ivan Ivanov", "Petr Petrov" });
//		contentMap.put("Group2", new String[] { "Alex Alexeev", "Nikolai Nikolaev" });
//		logFileAccessManager = new LogFileAccessManager();
//		items = logFileAccessManager.readLogItemsFromFile(fileName);
	}
}
