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
import studentlog.services.ProjectPathFinder;

public class TreeModel implements Observable {

	private static final String RESOURCES_FOLDER = "resources";
	private static final String DEFAULT_FILE_NAME = "studentlog.json";
	private static final String STORAGE_DIRECTORY = "resources/";

	private List<Observer> observers = new ArrayList<Observer>();

	// private List<StudentsGroup> items;
	// private Map<String,String[]> items;

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

	// public List<StudentsGroup> getItems() {
	// return items;
	// }

	public Root getRoot() {
		return root;
	}

	public void setItems(Root root) {
		this.root = root;
		notifyObservers(observers);
	}

	public String getLogFilePath() {

//		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
//		
//		System.out.println("bundle getLocation path: " + bundle.getLocation());
//		System.out.println("bundle getEntry path: " + bundle.getEntry(""));
//		System.out.println("bundle getBundleId: " + bundle.getBundleId());
//		System.out.println("bundle getSymbolicName: " + bundle.getSymbolicName());
//
//		
//		URL pluginInternalURL = bundle.getEntry("");
//
//		String filePath = null;
//		try {
////			filePath = Platform.resolve(pluginInternalURL).getFile(); pre 3.2 eclipse version
//			filePath = FileLocator.resolve(pluginInternalURL).getFile(); //after 3.2 eclipse version
//			if (filePath.charAt(0) == '\\' || filePath.charAt(0) == '/') { 
//				filePath = filePath.substring(1) + DEFAULT_FILE_NAME; 
//				} 
//			System.out.println("Filepath: " + filePath);
//			return filePath;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return filePath;
		System.out.println(ProjectPathFinder.getJSONFolderPath() + DEFAULT_FILE_NAME);
	return ProjectPathFinder.getJSONFolderPath() + DEFAULT_FILE_NAME;
	}

	private void initTreeModel() {
//		
//		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
//
//		System.out.println("bundle getLocation path: " + bundle.getLocation());
//		System.out.println("bundle getEntry path: " + bundle.getEntry(""));
//		System.out.println("bundle getBundleId: " + bundle.getBundleId());
//		System.out.println("bundle getSymbolicName: " + bundle.getSymbolicName());
//		System.out.println("bundle getResource: " + bundle.getResource("icons/logo.png"));
		
		
		logFileAccessManager = new LogFileAccessManager();
		root = logFileAccessManager.readLogItemsFromFile(getLogFilePath());
		setItems(root);
		
		
		
//		root = new Root();
//		Folder folder = new Folder(root, "Folder");
//
//		StudentsGroup firstGroup = new StudentsGroup(folder, "Group1");
//		StudentsGroup secondGroup = new StudentsGroup(folder, "Group2");
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
