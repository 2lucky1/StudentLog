package studentlog.services;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import studentlog.model.StudentsEntry;
import studentlog.model.StudentsGroup;
import studentlog.model.TreeItem;

class MyTypeAdapter<T> extends TypeAdapter<T> {
	public T read(JsonReader reader) throws IOException {
		
		 StudentsGroup root = null;
		 StudentsGroup folder = null;
		 StudentsGroup group1 = null;
		 StudentsGroup group2 = null;
		 
		 reader.beginObject();
		 String key = reader.nextName();
		 String keyValue = reader.nextString();
		
		 if (key.equals("name") && keyValue.equals("root")) {
			 root = new StudentsGroup(null, keyValue);
		 }
		 if(reader.nextName().equals("parent")) {
			 reader.nextString();
//			 root.setParent(null);
		 }
		 if(reader.nextName().equals("children")) {
			reader.nextString();
			root.setChildren(null);
		 }
		 
		 
		 
		//
		//
		// while (reader.hasNext()) {
		// StudentsGroup studentsGroup = new StudentsGroup();
		//
		// switch(reader.nextName()) {
		// case "name":
		// studentsGroup.setName(reader.nextString());
		// break;
		// case "parent":
		// studentsGroup.setParent(reader.nextString());
		// case "children":
		// reader.
		//
		// }
		// }
		// reader.endObject();

		return (T) root;
	}

	private TreeItem readTreeItem(JsonReader reader) {

		return null;

	}

	public void write(JsonWriter writer, T obj) throws IOException {
		if (obj == null) {
			writer.nullValue();
			return;
		}

		studentsGrouptoString(writer, (StudentsGroup) obj);
	}

	private void studentsGrouptoString(JsonWriter writer, StudentsGroup studentsGroup) throws IOException {
		writer.beginObject();
		writer.name("name").value(studentsGroup.getName());
//		writer.name("parent").value(studentsGroup.getParent() == null ? "null" : studentsGroup.getParent().getName());
		if (studentsGroup.getChildren() != null) {
			writer.name("children").beginArray();
			for (final TreeItem item : studentsGroup.getChildren()) {
				if (item instanceof StudentsGroup) {
					studentsGrouptoString(writer, (StudentsGroup) item);
				} else if (item instanceof StudentsEntry) {
					studentsEntrytoString(writer, (StudentsEntry) item);
				}
			}
			writer.endArray();
		}
		writer.endObject();
	}

	private void studentsEntrytoString(JsonWriter writer, StudentsEntry studentsEntry) throws IOException {
		writer.beginObject();
		writer.name("name").value(studentsEntry.getName());
		writer.name("groupNumber").value(studentsEntry.getGroupNumber());
		writer.name("address").value(studentsEntry.getAddress());
		writer.name("city").value(studentsEntry.getCity());
		writer.name("result").value(studentsEntry.getResult());
		writer.name("parent").value(studentsEntry.getParent().getName());
		writer.endObject();
	}
}
