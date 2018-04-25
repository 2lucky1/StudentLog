package studentlog.views;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.ViewPart;

public class StudentsView extends ViewPart {

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
		treeViewer.setLabelProvider(new WorkbenchLabelProvider());
		treeViewer.setContentProvider(new BaseWorkbenchContentProvider());
//		treeViewer.setInput(session.getRoot());

	}

	
//	public void dispose() {
//		Platform.getAdapterManager().unregisterAdapters(adapterFactory);
//	}
	
	
	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

}
