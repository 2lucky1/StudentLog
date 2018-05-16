package studentlog.views;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import studentlog.model.Observer;
import studentlog.model.Root;
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
