package studentlog.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.EditorPart;

import com.google.gson.Gson;

import studentlog.listeners.MyDropListener;
import studentlog.model.Root;
import studentlog.model.StudentsEntry;
import studentlog.ui.StudentProfileEditorPanel;

public class StudentProfileEditor extends EditorPart {
	public static String ID = "studentlog.editors.studentprofile";
	
	private StudentProfileEditorPanel panel;

	public StudentProfileEditor() {

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
		setPartName(getUser());

	}

//	DropTarget dt = new DropTarget(button, DND.DROP_MOVE);
//    dt.setTransfer(new Transfer[] { TextTransfer.getInstance() });
//    dt.addDropListener(new DropTargetAdapter() {
//      public void drop(DropTargetEvent event) {
//        // Set the buttons text to be the text being dropped
//        button.setText((String) event.data);
//      }
//    });
	
	@Override
	public void createPartControl(Composite parent) {
		panel = new StudentProfileEditorPanel(parent, SWT.NONE);
		
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		Shell shell = window.getShell();
		
		
		DropTarget dt = new DropTarget(panel, DND.DROP_MOVE);
	    dt.setTransfer(new Transfer[] { TextTransfer.getInstance() });
	    dt.addDropListener(new DropTargetAdapter() {
	      public void drop(DropTargetEvent event) {
	    	 StudentsEntry entry = new Gson().fromJson((String)event.data, StudentsEntry.class);
	        panel.fillPanelArea(entry);
	      }
	    });
	}
	
	public void fillEditorArea(StudentsEntry entry) {
		panel.fillPanelArea(entry);
		
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getUser() {
		return ((StudentProfileEditorInput) getEditorInput()).getName();
	}

}
