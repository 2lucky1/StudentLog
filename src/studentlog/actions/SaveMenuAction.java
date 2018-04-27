package studentlog.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import studentlog.Const;
import studentlog.ImageKeys;

public class SaveMenuAction extends Action implements IWorkbenchAction {

	public final static String SAVE_MENU_ACTION_ID = "studentlog.save";
	private final IWorkbenchWindow window;
	private IStructuredSelection selection;

	public SaveMenuAction(IWorkbenchWindow window) {
		super();
		this.window = window;
		setId(SAVE_MENU_ACTION_ID);
		setText("&Save");
		setToolTipText("Save log");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Const.BUNDLE_ID.getValue(),
				ImageKeys.FLLOPPY.getFilePath()));
	}

	public String getText() {
		return "&Save";
	}

	public void run() {
		System.out.println("Save menu action");
		ActionFactory.SAVE.create(window);
	}

	@Override
	public void dispose() {
	}

}
