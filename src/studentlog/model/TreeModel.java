package studentlog.model;

import java.util.ArrayList;
import java.util.List;

import studentlog.services.LogFileAccessManager;
import studentlog.services.ProjectPathFinder;

public class TreeModel implements Observable {

	private static final String DEFAULT_FILE_NAME = "studentlog.json";

	private List<Observer> observers = new ArrayList<Observer>();

	private Root root;
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

	public Root getRoot() {
		return root;
	}

	public void setItems(Root root) {
		this.root = root;
		notifyObservers(observers);
	}

	public String getLogFilePath() {

		
		System.out.println(ProjectPathFinder.getJSONFolderPath() + DEFAULT_FILE_NAME);
	return ProjectPathFinder.getJSONFolderPath() + DEFAULT_FILE_NAME;
	}

	private void initTreeModel() {
		logFileAccessManager = new LogFileAccessManager();
		root = logFileAccessManager.readLogItemsFromFile(getLogFilePath());
		setItems(root);
		
		
//		
//		root = new Root();
//		Folder folder = new Folder(root, "Folder");
//
//		StudentsGroup firstGroup = new StudentsGroup(folder, "Group1");
//		StudentsGroup secondGroup = new StudentsGroup(folder, "Group2");
//
//		StudentsEntry vasya = new StudentsEntry("����", "1", "�������,3", "�����", "5", firstGroup);
//		StudentsEntry petya = new StudentsEntry("����", "1", "������,75", "�����", "3", firstGroup);
//		StudentsEntry vanya = new StudentsEntry("����", "2", "�������,36", "�����", "4", secondGroup);
//		StudentsEntry sasha = new StudentsEntry("����", "2", "�����,8", "�����", "2", secondGroup);
//
//		firstGroup.addEntry(vasya);
//		firstGroup.addEntry(petya);
//
//		secondGroup.addEntry(vanya);
//		secondGroup.addEntry(sasha);
//
//		folder.addEntry(firstGroup);
//		folder.addEntry(secondGroup);
//
//		root.addEntry(folder);
	}
}
