package studentlog;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import studentlog.views.StudentsView;

public class Perspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
//		layout.addView(StudentsView.ID, IPageLayout.LEFT, 1.0f, layout.getEditorArea());
		layout.addStandaloneView(StudentsView.ID, true, IPageLayout.LEFT, 1.0f, layout.getEditorArea());
		layout.setFixed(true);
		
	}

}
