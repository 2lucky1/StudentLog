package studentlog;

public enum ImageKeys {
	CLOSED_FOLDER("icons/tree/folder.png"),
	OPENED_FOLDER(""),
	STUDENT_ICON("icons/tree/head.png"),
	DEFAULT_STUDENT_IMAGE(""),
	PLUS(""),
	FLLOPPY("icons/menubar/floppy.png"),
	BASKET("");
	
	private String filePath;
	
	private ImageKeys(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}
}
