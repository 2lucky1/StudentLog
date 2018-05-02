package studentlog.tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import studentlog.Const;
import studentlog.ImageKeys;
import studentlog.model.StudentsEntry;

public class CustomTreeLabelProvider implements ILabelProvider {

	private Image folderImg;
	private Image studentIconImg;

	public CustomTreeLabelProvider() {
		folderImg = AbstractUIPlugin.imageDescriptorFromPlugin(Const.BUNDLE_ID.getValue(), ImageKeys.CLOSED_FOLDER.getFilePath()).createImage();
		studentIconImg = AbstractUIPlugin.imageDescriptorFromPlugin(Const.BUNDLE_ID.getValue(), ImageKeys.STUDENT_ICON.getFilePath()).createImage();
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		if (folderImg != null) {
			folderImg.dispose();
		}
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object element) {
		if (element.getClass()==StudentsEntry.class) {
			System.out.println("instanceof StudentGroup");
			return folderImg;
		}
		System.out.println("group image is used");
		return folderImg;
	}

	@Override
	public String getText(Object element) {
		return element.toString();
	}

}
