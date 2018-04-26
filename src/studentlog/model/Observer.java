package studentlog.model;

import java.util.Map;


public interface Observer {
	void update (Map<String, String[]> items);
}