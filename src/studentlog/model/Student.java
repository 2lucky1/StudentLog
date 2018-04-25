package studentlog.model;

import org.eclipse.core.runtime.PlatformObject;

public abstract class Student extends PlatformObject {
	public abstract String getName();

	public abstract StudentsGroup getParent();
}
