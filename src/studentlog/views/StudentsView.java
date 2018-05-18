package studentlog.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.google.gson.Gson;

import studentlog.listeners.MyDragListener;
import studentlog.model.Observer;
import studentlog.model.Root;
import studentlog.model.StudentsEntry;
import studentlog.model.TreeModel;
import studentlog.tree.CustomTreeContentProvider;
import studentlog.tree.CustomTreeLabelProvider;

public class StudentsView extends ViewPart implements Observer {

	public static final String ID = "studentlog.views.students";

	private TreeViewer treeViewer;

	private Root root;

	public StudentsView() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		super.getSite().setSelectionProvider(treeViewer);
		treeViewer.setContentProvider(new CustomTreeContentProvider());
		treeViewer.setLabelProvider(new CustomTreeLabelProvider());
		root = TreeModel.getInstance().getRoot();
		treeViewer.setInput(root);

//		 DragSource ds = new DragSource(tree, DND.DROP_MOVE);
//		    ds.setTransfer(new Transfer[] { TextTransfer.getInstance() });
//		    ds.addDragListener(new DragSourceAdapter() {
//		      public void dragSetData(DragSourceEvent event) {
//		        // Set the data to be the first selected item's text
//		        event.data = tree.getSelection()[0].getText();
//		      }
//		    });
		
		DragSource ds = new DragSource(treeViewer.getTree(), DND.DROP_MOVE);

		ds.setTransfer(new Transfer[] {TextTransfer.getInstance()});
		ds.addDragListener(new DragSourceAdapter() {
			public void dragSetData(DragSourceEvent event) {
				IStructuredSelection selection = treeViewer.getStructuredSelection();
				StudentsEntry firstElement = (StudentsEntry)selection.getFirstElement();
				Gson gson = new Gson();
				String jsonStr = gson.toJson(firstElement);
		        event.data = jsonStr;
		      }
		    });
		
		
//		int operations = DND.DROP_MOVE;
//		Transfer[] transferTypes = new Transfer[] { TextTransfer.getInstance() };
//		treeViewer.addDragSupport(operations, transferTypes, new MyDragListener(treeViewer));
//		ds.setTransfer(new Transfer[] { TextTransfer.getInstance() });
//		ds.addDragListener(new MyDragListener(treeViewer));
		
	
	// ISelection selection = this.getSite().getSelectionProvider().getSelection();
	// if (selection != null && selection instanceof IStructuredSelection) {
	// Object obj = ((IStructuredSelection) selection).getFirstElement();
	// if (obj != null) {
	// // StudentsEntry entry = (StudentsEntry) obj;
	// }
	// }

	}

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

	@Override
	public void update(Root root) {
		treeViewer.setInput(root);

	}
}
