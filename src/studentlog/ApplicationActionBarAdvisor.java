package studentlog;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.StatusLineContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import studentlog.actions.AddStudentAction;
import studentlog.actions.SaveMenuAction;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {


	private IWorkbenchAction exitAction;
	private IWorkbenchAction aboutAction;
	private IWorkbenchAction saveAction;
	private AddStudentAction addStudentAction;
	private StatusLineContributionItem statusItem;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void makeActions(IWorkbenchWindow window) {
		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);
		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);
//		saveAction = new SaveMenuAction(window);
//		register(saveAction);
		saveAction = ActionFactory.SAVE.create(window);
		register(saveAction);
		addStudentAction = new AddStudentAction(window);
//		register(addContactAction);
	}

	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager fileMenu = new MenuManager("&File", "file");
		// hyperbolaMenu.add(addContactAction);
		fileMenu.add(new Separator());
		fileMenu.add(exitAction);
		fileMenu.add(saveAction);
		
		MenuManager editMenu = new MenuManager("&Edit", "edit");
		editMenu.add(new Separator());
		editMenu.add(aboutAction);
		
		MenuManager helpMenu = new MenuManager("&Help", "help");
		helpMenu.add(new Separator());
		helpMenu.add(aboutAction);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

	}

	protected void fillCoolBar(ICoolBarManager coolBar) {
		IToolBarManager toolbar = new ToolBarManager(coolBar.getStyle());
		coolBar.add(toolbar);
		toolbar.add(ActionFactory.OPEN_PERSPECTIVE_DIALOG.create(window));
		toolbar.add(new Separator());
//		toolbar.add(addContactAction);
	}

	@Override
	protected void fillStatusLine(IStatusLineManager statusLine) {
		statusItem = new StatusLineContributionItem("LoggedInStatus");
		statusItem.setText("Logged in");
		statusLine.add(statusItem);
	}

}
