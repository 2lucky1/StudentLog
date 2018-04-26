package studentlog.tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public class CustomTreeLabelProvider implements ILabelProvider {

	private Image dir;
	private static String imageLocation = "D:\\Muntian Nikolai\\git\\StudentLog\\icons\\folder.png";

	public CustomTreeLabelProvider() {
		try {
			dir = new Image(null, new FileInputStream(imageLocation));
			
		}catch(FileNotFoundException e) {
			System.out.println("Pictur is not found");
		}
	}
	
	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		if (dir != null)
			dir.dispose();
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
		return dir;
	}

	@Override
	public String getText(Object element) {
		return element.toString();
	}

}
