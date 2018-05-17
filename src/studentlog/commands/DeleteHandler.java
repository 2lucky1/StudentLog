package studentlog.commands;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import studentlog.editors.StudentProfileEditor;
import studentlog.editors.StudentProfileEditorInput;
import studentlog.model.StudentsEntry;
import studentlog.model.StudentsGroup;
import studentlog.views.StudentsView;

public class DeleteHandler extends AbstractHandler implements ISelectionChangedListener {
	private IWorkbenchWindow window;
	private final static String ID = "studentlog.action.student_profile_actoin";
	private IStructuredSelection selection;
	
	
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();
		StudentsView view = (StudentsView) page.findView(StudentsView.ID);
		// Get the selection
		ISelection selection = view.getSite().getSelectionProvider()
				.getSelection();
		
		
		if (selection != null && selection instanceof IStructuredSelection) {
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			if(obj instanceof StudentsEntry) {
				
				StudentsGroup group = ((StudentsEntry) obj).getParent();
				group.getChildren().remove(obj);
				System.out.println(group);
			}
			// If we had a selection lets open the editor
//			if (obj != null) {
//				StudentsEntry entry = (StudentsEntry) obj;
//				StudentProfileEditorInput input = new StudentProfileEditorInput(entry.getName());
//				try {
//					StudentProfileEditor editor = (StudentProfileEditor)page.openEditor(input, StudentProfileEditor.ID);
////					editor.fillEditorArea(entry);
//
//				} catch (PartInitException e) {
//					throw new RuntimeException(e);
//				}
//			}
		}
		return null;
		
//		System.out.println("Delete menu");
//		for(StudentsEntry selectedEntry : selectedItems) {
//			selectedEntry.getParent().getChildren().remove(selectedEntry);
////			System.out.println(selectedEntry.getParent().getChildren().remove(selectedEntry));
//		}
//		return null;
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
//		IStructuredSelection selectedLines = (IStructuredSelection) event.getSelection();
//		selectedItems = selectedLines.toList();
	}

}
