package studentlog.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AddStudentDialog extends Dialog {
	private Text nameText;

	private Text groupText;

	private Text addressText;
	
	private Text cityText;
	
	private Text result;

//	private Text serverText;

//	private Text nicknameText;

//	private String userId;

//	private String server;

//	private String nickname;

	public AddStudentDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Add Student"); //$NON-NLS-1$
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);

		Label nameLabel = new Label(composite, SWT.NONE);
		nameLabel.setText("&Name:"); //$NON-NLS-1$
		nameLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER, false, false));

		nameText = new Text(composite, SWT.BORDER);
		nameText.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));

		Label groupLabel = new Label(composite, SWT.NONE);
		groupLabel.setText("&Group:"); //$NON-NLS-1$
		groupLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER, false, false));

		groupText = new Text(composite, SWT.BORDER);
		groupText.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));

		Label adressLabel = new Label(composite, SWT.NONE);
		adressLabel.setText("&Address:"); //$NON-NLS-1$
		adressLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER, false, false));

		addressText = new Text(composite, SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.widthHint = convertHeightInCharsToPixels(20);
		addressText.setLayoutData(gridData);

		return composite;
	}

	@Override
	protected void okPressed() {
		nickname = nicknameText.getText();
		server = serverText.getText();
		userId = userIdText.getText();

		if (nickname.equals("")) { //$NON-NLS-1$
			MessageDialog.openError(getShell(), "Invalid Nickname", //$NON-NLS-1$
					"Nickname field must not be blank."); //$NON-NLS-1$
			return;
		}
		if (server.equals("")) { //$NON-NLS-1$
			MessageDialog.openError(getShell(), "Invalid Server", //$NON-NLS-1$
					"Server field must not be blank."); //$NON-NLS-1$
			return;
		}
		if (userId.equals("")) { //$NON-NLS-1$
			MessageDialog.openError(getShell(), "Invalid User id", //$NON-NLS-1$
					"User id field must not be blank."); //$NON-NLS-1$
			return;
		}

		super.okPressed();
	}

	public String getUserId() {
		return userId;
	}

	public String getServer() {
		return server;
	}

	public String getNickname() {
		return nickname;
	}
}
