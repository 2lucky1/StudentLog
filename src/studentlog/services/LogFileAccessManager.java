package studentlog.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import studentlog.model.StudentsGroup;

public class LogFileAccessManager {

	// private Type itemsListType = new TypeToken<List<StudentsEntry>>() {
	// }.getType();

	private Type rootType = new TypeToken<StudentsGroup>() {
	}.getType();

	public LogFileAccessManager() {
		super();
	}

	public void writeLogItemsToFile(String logFilePath, StudentsGroup root) {
		Gson gson = new Gson();
		String jsonStr = gson.toJson(root);
		System.out.println("Jason string " + jsonStr);
		try (Writer writer = new FileWriter(logFilePath)) {
			writer.write(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public StudentsGroup readLogItemsFromFile(String logFilePath) {
		String jsonStr = null;
		try (Reader reader = new FileReader(logFilePath)) {
			BufferedReader bufferedReader = new BufferedReader(reader);
			jsonStr = bufferedReader.readLine();
			StudentsGroup root = new Gson().fromJson(jsonStr, StudentsGroup.class);
			return root;
			//////
//			if(root==null) {
//				root = getDefaultLogItems();
//			}
//			return root;
			//////
		} catch (FileNotFoundException e) {
			System.out.println("LogFileAccessor: file doesnt exists");
			return getDefaultLogItems();
		} catch (IOException e) {
			return getDefaultLogItems();
		}
	}
	
	private StudentsGroup getDefaultLogItems() {
		StudentsGroup root = new StudentsGroup(null, "root");
		StudentsGroup folder = new StudentsGroup(root, "Folder");

		StudentsGroup firstGroup = new StudentsGroup(root, "Group1");
		StudentsGroup secondGroup = new StudentsGroup(root, "Group2");
		
		folder.addEntry(firstGroup);
		folder.addEntry(secondGroup);

		root.addEntry(folder);
		return root;
	}
}
