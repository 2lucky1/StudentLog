//package studentlog.model;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class TreeModel implements Observable {
//	private List<Observer> observers = new ArrayList<Observer>();
//	private Map<String,String[]> items;
//	private LogFileAccessManager logFileAccessManager;
//	private String fileName = "log.txt";
//	private static ModelTableData instance;
//
//	private TreeModel() {
//		super();
//		initTreeModel(fileName);
//	}
//
//	public static ModelTableData getInstance() {
//		if (instance == null) {
//			instance = new ModelTableData();
//		}
//		return instance;
//	}
//
//	public void addObserver(Observer o) {
//		observers.add(o);
//	}
//
//	public void removeObserver(Observer o) {
//		observers.remove(o);
//	}
//
//	public void notifyObservers(List<Observer> observers) {
//		for (Observer observer : observers) {
//			observer.update(items);
//		}
//	}
//
//	public List<HomeworkLogItem> getItems() {
//		return items;
//	}
//
//	public void setItems(List<HomeworkLogItem> items) {
//		this.items = items;
//		notifyObservers(observers);
//	}
//
//	private void initTableModel(String fileName) {
//		logFileAccessManager = new LogFileAccessManager();
//		items = logFileAccessManager.readLogItemsFromFile(fileName);
//	}
//}
