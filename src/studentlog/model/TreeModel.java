package studentlog.model;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import studentlog.services.LogFileAccessManager;

public class TreeModel implements Observable {

	private static final String RESOURCES_FOLDER = "resources";
	private static final String DEFAULT_FILE_NAME = "studentlog.json";
	private static final String DEFAULT_DIRECTORY_TO_SAVE = "resources/";

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

		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		URL pluginInternalURL = bundle.getEntry(RESOURCES_FOLDER);

		String filePath = null;
		try {
//			filePath = Platform.resolve(pluginInternalURL).getFile(); pre 3.2 eclipse version
			filePath = FileLocator.resolve(pluginInternalURL).getFile(); //after 3.2 eclipse version
			if (filePath.charAt(0) == '\\' || filePath.charAt(0) == '/') { 
				filePath = filePath.substring(1) + DEFAULT_FILE_NAME; 
				} 
			System.out.println("Filepath: " + filePath);
			return filePath;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;

		// System.out.println(System.getProperty("user.home") + "\\" + DEFAULT_FILE_NAME);
		// return (System.getProperty("user.home") + "\\" + DEFAULT_FILE_NAME);
	}

	private void initTreeModel() {

		 logFileAccessManager = new LogFileAccessManager();
		 root = logFileAccessManager.readLogItemsFromFile(getLogFilePath());

//		root = new StudentsGroup(null, "root");
//		StudentsGroup folder = new StudentsGroup(root, "Folder");
//
//		StudentsGroup firstGroup = new StudentsGroup(root, "Group1");
//		StudentsGroup secondGroup = new StudentsGroup(root, "Group2");
//
//		StudentsEntry vasya = new StudentsEntry("Вася", "1", "Красная,3", "Днепр", "5", firstGroup);
//		StudentsEntry petya = new StudentsEntry("Петя", "1", "Желтая,75", "Днепр", "3", firstGroup);
//		StudentsEntry vanya = new StudentsEntry("Ваня", "2", "Зеленая,36", "Днепр", "4", secondGroup);
//		StudentsEntry sasha = new StudentsEntry("Саша", "2", "Синяя,8", "Днепр", "2", secondGroup);
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
