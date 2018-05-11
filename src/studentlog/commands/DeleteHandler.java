package studentlog.commands;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import studentlog.model.StudentsEntry;

public class DeleteHandler extends AbstractHandler implements ISelectionChangedListener {
	private List<StudentsEntry> selectedItems;
//	private IStructuredSelection selection;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("Delete menu");
		for(StudentsEntry selectedEntry : selectedItems) {
			selectedEntry.getParent().getChildren().remove(selectedEntry);
//			System.out.println(selectedEntry.getParent().getChildren().remove(selectedEntry));
		}
		return null;
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		IStructuredSelection selectedLines = (IStructuredSelection) event.getSelection();
		selectedItems = selectedLines.toList();
	}

}
