package studentlog.listeners;

import java.util.List;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import studentlog.model.StudentsEntry;

public class ItemSelectionChangeListener implements ISelectionChangedListener {

	List<StudentsEntry> selectedItems;
	
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		IStructuredSelection selectedLines = (IStructuredSelection) event.getSelection();
		selectedItems = selectedLines.toList();
	}

}
