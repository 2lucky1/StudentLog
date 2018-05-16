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
			 root = new StudentsGroup("1", null, keyValue);
		 }
		 key = reader.nextName();
		 System.out.println("key 1 : " + key);
		 if(key.equals("parent")) {
			 reader.nextString();
			 root.setParent(null);
		 }
		 key = reader.nextName();
		 System.out.println("key 2 : " + key);
		 if(key.equals("children")) {
			 reader.beginObject();
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
		writer.name("id").value(studentsGroup.getId());
		if (studentsGroup.getParent() != null) {
			writer.name("type").value("group");
		}
		writer.name("name").value(studentsGroup.getName());
		writer.name("parent").value(studentsGroup.getParent() == null ? "null" : studentsGroup.getParent().getId());
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
		writer.name("id").value(studentsEntry.getId());
		writer.name("type").value("entry");
		writer.name("name").value(studentsEntry.getName());
		writer.name("groupNumber").value(studentsEntry.getGroupNumber());
		writer.name("address").value(studentsEntry.getAddress());
		writer.name("city").value(studentsEntry.getCity());
		writer.name("result").value(studentsEntry.getResult());
		writer.name("parent").value(studentsEntry.getParent().getId());
		writer.endObject();
	}
}
