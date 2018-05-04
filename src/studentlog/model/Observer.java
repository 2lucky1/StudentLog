package studentlog.model;

import java.util.List;

public interface Observer {
	void update (List<StudentsGroup> items);
}