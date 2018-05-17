//package studentlog.dnd;
//
//import org.eclipse.jface.util.LocalSelectionTransfer;
//import org.eclipse.swt.dnd.DND;
//import org.eclipse.swt.dnd.DropTargetAdapter;
//import org.eclipse.swt.dnd.DropTargetEvent;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.ui.IWorkbenchWindow;
//
//public class EditorAreaDropAdapter extends DropTargetAdapter {
//	private IWorkbenchWindow window;
//
//	public EditorAreaDropAdapter(IWorkbenchWindow window) {
//		this.window = window;
//	}
//
//	public void dragOperationChanged(DropTargetEvent event) {
//		event.detail = DND.DROP_COPY;
//	}
//
//	public void drop(final DropTargetEvent event) {
//		Display d = window.getShell().getDisplay();
//		final IWorkbenchPage page = window.getActivePage();
//		if (page != null) {
//			d.asyncExec(new Runnable() {
//
//				@Override
//				public void run() {
//					asyncDrop(event,page);
//				}
//			});
//		}
//	}
//	
//	private void asyncDrop(DropTargetEvent event, IWorkbenchPage page) {
//		if(LocalSelectionTransfer.getIn)
//	}
//}
