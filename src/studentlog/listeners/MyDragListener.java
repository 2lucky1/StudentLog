package studentlog.listeners;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;

import com.google.gson.Gson;

import studentlog.model.StudentsEntry;

public class MyDragListener implements DragSourceListener {

	private final TreeViewer viewer;
	
	public MyDragListener(TreeViewer viewer) {
		this.viewer = viewer;
	}
	
	@Override
	public void dragStart(DragSourceEvent event) {
		System.out.println("Start Drag");
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		IStructuredSelection selection = viewer.getStructuredSelection();
		StudentsEntry firstElement = (StudentsEntry)selection.getFirstElement();
		Gson gson = new Gson();
		String jsonStr = gson.toJson(firstElement);
		if(TextTransfer.getInstance().isSupportedType(event.dataType)) {
			event.data = jsonStr;
		}
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
		System.out.println("Finished Drag");
	}
}
