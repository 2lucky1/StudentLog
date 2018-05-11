package studentlog.services;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class ProjectPathFinder {

	public static String getProjectAbsolutePath() {
		Bundle bundle = FrameworkUtil.getBundle(ProjectPathFinder.class);
		URL projectURL = bundle.getEntry("");

		String projectAbsolutePath = null;
		try {
//			filePath = Platform.resolve(pluginInternalURL).getFile(); pre 3.2 eclipse version
			projectAbsolutePath = FileLocator.resolve(projectURL).getFile(); //after 3.2 eclipse version
			System.out.println(projectAbsolutePath);
			if (projectAbsolutePath.charAt(0) == File.separatorChar) { 
				projectAbsolutePath = projectAbsolutePath.substring(1); 
			} 
			System.out.println("Filepath: " + projectAbsolutePath);
			return projectAbsolutePath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projectAbsolutePath;
	}
	
	public static String getResourcesFolderPath() {
		return getProjectAbsolutePath() + "resources" + File.separator;
	}
	
	public static String getIconsFolderPath() {
		return getResourcesFolderPath() + "icons" + File.separator;
	}
	
	public static String getJSONFolderPath() {
		return getResourcesFolderPath() + "json" + File.separator;
	}
	
	public static String getStudentsPictures() {
		return getResourcesFolderPath() + "student_pictures" + File.separator;
	}
	
}
