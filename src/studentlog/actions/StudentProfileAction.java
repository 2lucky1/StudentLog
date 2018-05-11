package studentlog.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import studentlog.Application;
import studentlog.ImageKeys;
import studentlog.editors.StudentProfileEditor;
import studentlog.editors.StudentProfileEditorInput;
import studentlog.model.StudentsEntry;

public class StudentProfileAction extends Action implements ISelectionListener, IWorkbenchWindow {

	private final IWorkbenchWindow window;
	private final static String ID = "studentlog.action.student_profile_actoin";
	private IStructuredSelection selection;

	public StudentProfileAction(IWorkbenchWindow window) {
		this.window = window;
		setId(ID);
		setText("&Chat");
		setToolTipText("Profile of the selected student");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID,
				ImageKeys.STUDENT_ICON.getFilePath()));
		window.getSelectionService().addSelectionListener(this);
	}

	public void dispose() {
		window.getSelectionService().removeSelectionListener(this);
	}

	@Override
	public void addPageListener(IPageListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPerspectiveListener(IPerspectiveListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePageListener(IPageListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePerspectiveListener(IPerspectiveListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T getService(Class<T> api) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasService(Class<?> api) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean close() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IWorkbenchPage getActivePage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWorkbenchPage[] getPages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPartService getPartService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISelectionService getSelectionService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shell getShell() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWorkbench getWorkbench() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isApplicationMenu(String menuId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IWorkbenchPage openPage(String perspectiveId, IAdaptable input) throws WorkbenchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWorkbenchPage openPage(IAdaptable input) throws WorkbenchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run(boolean fork, boolean cancelable, IRunnableWithProgress runnable)
			throws InvocationTargetException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setActivePage(IWorkbenchPage page) {
		// TODO Auto-generated method stub

	}

	@Override
	public IExtensionTracker getExtensionTracker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection incoming) {
		if (incoming instanceof IStructuredSelection) {
			selection = (IStructuredSelection) incoming;
			setEnabled(selection.size() == 1 && selection.getFirstElement() instanceof StudentsEntry);
		} else {
			// other selections(e.g., containing text or of other kinds)
			setEnabled(false);
		}

	}

	public void run() {
		Object item = selection.getFirstElement();
		StudentsEntry entry = (StudentsEntry) item;
		IWorkbenchPage page = window.getActivePage();
		StudentProfileEditorInput input = new StudentProfileEditorInput(entry.getName());
		try {
			page.openEditor(input, StudentProfileEditor.ID);
		} catch (PartInitException e) {
			// Handle error.
		}
	}
}
