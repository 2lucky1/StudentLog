package studentlog.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import studentlog.services.LogFileAccessManager;

public class TreeModel implements Observable {

	private static final String DEFAULT_FILE_NAME = "studentlog.json";

	private List<Observer> observers = new ArrayList<Observer>();

	// private List<StudentsGroup> items;
	// private Map<String,String[]> items;

	private StudentsGroup root;
	private LogFileAccessManager logFileAccessManager;
	private static TreeModel instance;

	private TreeModel() {
		super();
		initTreeModel();
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
			observer.update(root);
		}
	}

	// public List<StudentsGroup> getItems() {
	// return items;
	// }

	public StudentsGroup getRoot() {
		return root;
	}

	public void setItems(StudentsGroup root) {
		this.root = root;
		notifyObservers(observers);
	}

	public String getLogFilePath() {
		return (System.getProperty("user.dir") + "/" + DEFAULT_FILE_NAME);
	}

	private void initTreeModel() {
		
//		 logFileAccessManager = new LogFileAccessManager();
//		 root = logFileAccessManager.readLogItemsFromFile(getLogFilePath());

		 root = new StudentsGroup(null, "root");
		 StudentsGroup folder = new StudentsGroup(root, "Folder");
		
		 StudentsGroup firstGroup = new StudentsGroup(root, "Group1");
		 StudentsGroup secondGroup = new StudentsGroup(root, "Group2");
		
		 StudentsEntry vasya = new StudentsEntry("Вася", "1", "Красная,3", "Днепр",
		 "5", firstGroup);
		 StudentsEntry petya = new StudentsEntry("Петя", "1", "Желтая,75", "Днепр",
		 "3", firstGroup);
		 StudentsEntry vanya = new StudentsEntry("Ваня", "2", "Зеленая,36", "Днепр",
		 "4", secondGroup);
		 StudentsEntry sasha = new StudentsEntry("Саша", "2", "Синяя,8", "Днепр", "2",
		 secondGroup);
		
		 firstGroup.addEntry(vasya);
		 firstGroup.addEntry(petya);
		
		 secondGroup.addEntry(vanya);
		 secondGroup.addEntry(sasha);
		
		 folder.addEntry(firstGroup);
		 folder.addEntry(secondGroup);
		
		 root.addEntry(folder);
	}
}
