package studentlog.views;

import java.util.List;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import studentlog.model.Observer;
import studentlog.model.StudentsGroup;
import studentlog.tree.CustomTreeContentProvider;
import studentlog.tree.CustomTreeLabelProvider;

public class StudentsView extends ViewPart implements Observer {

	public static final String ID = "studentlog.views.students";
	
	private TreeViewer treeViewer;
//	private IAdapterFactory adapterFactory = new StudentLogAdapterFactory();
	
	public StudentsView() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		super.getSite().setSelectionProvider(treeViewer);
		treeViewer.setContentProvider(new CustomTreeContentProvider());
		treeViewer.setLabelProvider(new CustomTreeLabelProvider());
		treeViewer.setInput("root");

	}

	
//	public void dispose() {
//		Platform.getAdapterManager().unregisterAdapters(adapterFactory);
//	}
	
	
	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

	@Override
	public void update(List<StudentsGroup> items) {
		treeViewer.setInput(items);
	}

}
