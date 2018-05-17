package studentlog.dnd;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import org.eclipse.swt.dnd.ByteArrayTransfer;

import studentlog.model.StudentsEntry;

public class StudentTransfer extends ByteArrayTransfer {
	private static StudentTransfer instance = new StudentTransfer();
	private static final String TYPE_NAME = "student-transfer-format";
	private static final int TYPE_ID = registerType(TYPE_NAME);

	public static StudentTransfer getInstance() {
		return instance;
	}

	private StudentTransfer() {

	}

	protected StudentsEntry[] fromByteArray(byte[] bytes) {
//		DataInputStream in = new DataInputStream(new ByteArrayInputStream(bytes));
////		try {
////			int n = in.readInt();
////			StudentsEntry[] studentsEntry = new StudentsEntry[n];
////			for(int = 0; i < n; i++) {
//////				StudentsEntry studentsEntry = readStu
////			}
//		}
		return null;
		
	}

	@Override
	protected int[] getTypeIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getTypeNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
