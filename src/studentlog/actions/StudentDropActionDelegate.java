package studentlog.actions;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IDropActionDelegate;

import studentlog.dnd.StudentTransfer;
import studentlog.editors.StudentProfileEditor;
import studentlog.editors.StudentProfileEditorInput;
import studentlog.model.StudentsEntry;

public class StudentDropActionDelegate implements IDropActionDelegate {
	public static final String ID = "studentlog.actions.dropStudent";
	
	@Override
	public boolean run(Object source, Object target) {
//		Object item = selection.getFirstElement();
//		StudentsEntry entry = (StudentsEntry) item;
//		IWorkbenchPage page = window.getActivePage();
//		StudentProfileEditorInput input = new StudentProfileEditorInput(entry.getName());
//		try {
//			page.openEditor(input, StudentProfileEditor.ID);
//		} catch (PartInitException e) {
//			// Handle error.
//		}
		return false;
	}

}
