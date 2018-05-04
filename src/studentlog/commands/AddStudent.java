package studentlog.commands;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;

import studentlog.model.StudentsGroup;

public class AddStudent extends AbstractHandler implements ISelectionListener {

	private IStructuredSelection selection;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("Add menu");
		return null;
	}

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
}
