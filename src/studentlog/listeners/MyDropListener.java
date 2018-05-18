package studentlog.listeners;

import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;

import com.google.gson.Gson;

import studentlog.model.StudentsEntry;
import studentlog.ui.StudentProfileEditorPanel;

public class MyDropListener extends DropTargetAdapter {

	private StudentProfileEditorPanel panel;

	public MyDropListener(StudentProfileEditorPanel panel) {
		this.panel = panel;
	}

	public void drop(DropTargetEvent event) {
		StudentsEntry entry = new Gson().fromJson((String)event.data, StudentsEntry.class);
		panel.fillPanelArea(entry);
	}
}
