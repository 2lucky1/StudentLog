package studentlog.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import studentlog.services.LogFileAccessManager;

public class TreeModel implements Observable {
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	private List<StudentsGroup> items;
//	private Map<String,String[]> items;
	private LogFileAccessManager logFileAccessManager;
	private String fileName = "log.txt";
	private static TreeModel instance;

	private TreeModel() {
		super();
		initTreeModel(fileName);
	}

	public static TreeModel getInstance() {
		if (instance == null) {
			instance = new TreeModel();
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
		logFileAccessManager = new LogFileAccessManager();
		items = logFileAccessManager.readLogItemsFromFile(fileName);
	}
}
