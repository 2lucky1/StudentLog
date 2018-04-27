package studentlog.tree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import studentlog.Const;
import studentlog.ImageKeys;
import studentlog.model.StudentsGroup;

public class CustomTreeLabelProvider implements ILabelProvider {

	private Image folderImg;
	private Image studentIconImg;
	// private static String fileName = "folder.png";
	// private static String workingDirectory = System.getProperty("icons");
	// private static String imageLocation = workingDirectory + File.separator +
	// fileName + "";
	private static String imageLocation = "D:\\Muntian Nikolai\\git\\StudentLog\\icons\\folder.png";
	private static String studentImgLocation = "D:\\Muntian Nikolai\\git\\StudentLog\\icons\\head.png";

	public CustomTreeLabelProvider() {
		try {
//			folderImg = new Image(null, new FileInputStream(ImageKeys.CLOSED_FOLDER.getFilePath()));
			System.out.println(Const.BUNDLE_ID.getValue());
			System.out.println(ImageKeys.CLOSED_FOLDER.getFilePath());
			folderImg = AbstractUIPlugin.imageDescriptorFromPlugin(Const.BUNDLE_ID.getValue(), ImageKeys.CLOSED_FOLDER.getFilePath()).createImage();
			studentIconImg = new Image(null, new FileInputStream(studentImgLocation));
		} catch (FileNotFoundException e) {
			System.out.println("Pictur is not found");
		}
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
		if (element instanceof StudentsGroup) {
			System.out.println("instanceof StudentGroup");
			return studentIconImg;
		}
		System.out.println("group image is used");
		return folderImg;
	}

	@Override
	public String getText(Object element) {
		return element.toString();
	}

}
