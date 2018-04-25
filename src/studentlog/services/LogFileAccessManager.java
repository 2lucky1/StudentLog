package studentlog.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import studentlog.model.StudentsEntry;

public class LogFileAccessManager {

	private Type itemsListType = new TypeToken<List<StudentsEntry>>() {
	}.getType();

	public LogFileAccessManager() {
		super();
	}

	public void writeLogItemsToFile(String fileName, List items) {
		Gson gson = new Gson();
		String jsonStr = gson.toJson(ModelTableData.getInstance().getItems());
		System.out.println(jsonStr);
		try (Writer writer = new FileWriter(fileName)) {
			writer.write(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<HomeworkLogItem> readLogItemsFromFile(String fileName) {
		List<HomeworkLogItem> items;
		String jsonStr = "NULL";
		try (Reader reader = new FileReader(fileName)) {
			BufferedReader bufferedReader = new BufferedReader(reader);
			jsonStr = bufferedReader.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		items = new Gson().fromJson(jsonStr, itemsListType);
		return items;
	}
}
