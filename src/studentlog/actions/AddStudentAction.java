package studentlog.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import studentlog.Const;
import studentlog.ImageKeys;
import studentlog.model.StudentsEntry;
import studentlog.dialogs.AddStudentDialog;
import studentlog.model.StudentsGroup;

public class AddStudentAction extends Action implements ISelectionListener,  ActionFactory.IWorkbenchAction {

	public final static String  ID = "org.eclipsercp.hyperbola.addContact";
	private final IWorkbenchWindow window;
	private IStructuredSelection selection;
	
	public AddStudentAction(IWorkbenchWindow window) {
		this.window = window;
		setId(ID);
		setText("&Add Student");
		setToolTipText("Add a student");
//		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Const.BUNDLE_ID.getValue(), ImageKeys.PLUS.getFilePath()));
		window.getSelectionService().addSelectionListener(this);
	}
	
	@Override
	public void dispose() {
		window.getSelectionService().removeSelectionListener(this);
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection incoming) {
		// selection containing elements
		if (incoming instanceof IStructuredSelection) {
			this.selection = (IStructuredSelection) incoming;
			super.setEnabled(selection.size() == 1 && selection.getFirstElement() instanceof StudentsGroup);
			
		} else {
			// other selections (e.g., containing text or of other kinds)
			super.setEnabled(false);
		}
		
	}

	@Override
	public void run() {

		AddStudentDialog d = new AddStudentDialog(window.getShell());
		int code = d.open();
		if (code == Window.OK) {
			Object item = selection.getFirstElement();
			StudentsGroup group = (StudentsGroup) item;
			StudentsEntry entry = new StudentsEntry(d.getName(),group.getName(), d.getAddress(), 
													d.getCity(), d.getResult(),group);
			group.addEntry(entry);
		}
	}
	
	
}
