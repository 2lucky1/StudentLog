//package studentlog;
//
//import java.net.URL;
//
//import org.eclipse.core.runtime.IAdapterFactory;
//import org.eclipse.core.runtime.Platform;
//import org.eclipse.jface.resource.ImageDescriptor;
//import org.eclipse.ui.model.IWorkbenchAdapter;
//
//public class StudentLogAdapterFactory implements IAdapterFactory {
//
//	private IWorkbenchAdapter groupAdapter = new IWorkbenchAdapter() {
//
//		@Override
//		public String getLabel(Object o) {
//			StudentsGroup group = ((StudentsGroup) o);
//			int available = 0;
//			Student[] entries = group.getEntries();
//			for (int i = 0; i < entries.length; i++) {
//				Student student = entries[i];
//				if (student instanceof StudentsEntry) {
//					if (((StudentsEntry) student).getPresence() != Presence.INVISIBLE) {
//						available++;
//					}
//				}
//			}
//			return group.getName() + " (" + available + "/" + entries.length + ")";
//		}
//
//		public Object[] getChildren(Object o) {
//			return ((StudentsGroup) o).getEntries();
//		}
//
//		public ImageDescriptor getImageDescriptor(Object object) {
//			ImageDescriptor descriptor = createImageDescriptorFor(IImageKeys.GROUP);
//			return descriptor;
//		}
//
//		public Object getParent(Object p) {
//			return ((StudentsGroup) o).getParent();
//		}
//	};
//
//	private IWorkbenchAdapter entryAdapter = new IWorkbenchAdapter() {
//
//		@Override
//		public Object getParent(Object o) {
//			return ((StudentsEntry) o).getParent();
//		}
//
//		@Override
//		public String getLabel(Object o) {
//			StudentsEntry entry = (StudentsEntry) o;
//			return entry.getName() + entry.getLastName();
//		}
//		
//		@Override
//		public ImageDescriptor getImageDescriptor(Object object) {
//			
//			StudentsEntry entry = (StudentsEntry) object;
//			String key = presencToImgPath(entry.getPresence());
//			
//			ImageDescriptor descriptor = createImageDescriptorFor(key);
//			return descriptor;
//		}
//
//		@Override
//		public Object[] getChildren(Object o) {
//			return new Object[0];
//		}
//	};
//	
//	public ImageDescriptor createImageDescriptor(String id) {
//		URL url = Platform.getBundle(Const.Bundle_ID).getEntry(id);
//		return ImageDescriptor.createFromURL(url);
//	}
//	
//	public Object getAdapter(Object adaptableObject, Class adapterType) {
//
//		if(adapterType == IWorkbenchAdapter.class && adaptableObject instanceof StudentsGroup) {
//		return groupAdapter;
//		}
//		
//		if(adapterType == IWorkbenchAdapter.class && adaptableObject instanceof StudentsGroup) {
//			return entryAdapter;
//		}
//		return null;
//	}
//	
//	public Class[] getAdapterList() {
//		return new Class[] { IWorkbenchAdapter.class };
//	}
//	
//	private String presencToImgPath(Presence presence) {
//		if(presence == Presence.ONLINE) {
//			return IImageKeys.OFFICE_GUY;
//		}
//		if(presence == presence.AWAY) {
//			return IImageKeys.AWAY;
//		}
//		if(presence == Presence.DO_NOT_DISTURB) {
//			return IImageKeys.DO_NOT_DISTURB;
//		}
//		if(presence = Presence.INVISIBLE) {
//			return IImageKeys.OFFICE_GUY;
//		}
//		
//		return IImageKeys.VIKING_BERSERKER;
//	}
//}
