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

import studentlog.model.Student;
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
		} catch (FileNotFoundException e) {
			System.out.println("LogFileAccessor: file doesnt exists");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StudentsGroup root = new Gson().fromJson(jsonStr, rootType);
		return root;

		// List<StudentsGroup> items;
		// String jsonStr = "NULL";
		// try (Reader reader = new FileReader(fileName)) {
		// BufferedReader bufferedReader = new BufferedReader(reader);
		// jsonStr = bufferedReader.readLine();
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// items = new Gson().fromJson(jsonStr, itemsListType);
		// return items;
		// return null;
	}
}
