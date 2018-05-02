package studentlog;

import java.net.URL;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;

import studentlog.model.Student;
import studentlog.model.StudentsGroup;

public class StudentLogAdapterFactory implements IAdapterFactory {

	private IWorkbenchAdapter groupAdapter = new IWorkbenchAdapter() {

		@Override
		public String getLabel(Object o) {
			StudentsGroup group = ((StudentsGroup) o);
			Student[] entries = group.getEntries();
			return group.getName() + " (" + entries.length + ")";
		}

		public Object[] getChildren(Object o) {
			return ((StudentsGroup) o).getEntries();
		}

		public ImageDescriptor getImageDescriptor(Object object) {

			ImageDescriptor descriptor = createImageDescriptorFor(ImageKeys.CLOSED_FOLDER.getFilePath());

			return descriptor;
		}

		public Object getParent(Object o) {
			return ((StudentsGroup) o).getParent();
		}
	};

	private IWorkbenchAdapter entryAdapter = new IWorkbenchAdapter() {

		@Override
		public Object getParent(Object o) {
			return ((Student) o).getParent();
		}

		@Override
		public String getLabel(Object o) {
			Student entry = (Student) o;
			return entry.getName();
		}

		@Override
		public ImageDescriptor getImageDescriptor(Object object) {

			ImageDescriptor descriptor = createImageDescriptorFor(ImageKeys.STUDENT_ICON.getFilePath());

			return descriptor;
		}

		@Override
		public Object[] getChildren(Object o) {
			return new Object[0];
		}
	};

	public ImageDescriptor createImageDescriptorFor(String id) {
		URL url = Platform.getBundle(Const.BUNDLE_ID.getValue()).getEntry(id);
		return ImageDescriptor.createFromURL(url);
	}

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == IWorkbenchAdapter.class && adaptableObject instanceof StudentsGroup) {
			return groupAdapter;
		}
		if (adapterType == IWorkbenchAdapter.class && adaptableObject instanceof Student) {
			return entryAdapter;
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] { IWorkbenchAdapter.class };
	}
}
