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

import studentlog.services.InputVerifier;

public class AddStudentDialog extends Dialog {
	private Text nameText;

	private Text groupText;

	private Text addressText;
	
	private Text cityText;
	
	private Text resultText;
	
	private String name;
	private String group;
	private String address;
	private String city;
	private String result;

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
		
		Label resultLabel = new Label(composite, SWT.NONE);
		resultLabel.setText("&Result:");
		resultLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER, true, false));

		resultText = new Text(composite, SWT.BORDER);
		resultText.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
		
		return composite;
	}

	@Override
	protected void okPressed() {
		name = nameText.getText();
		group = groupText.getText();
		address = addressText.getText();
		city = cityText.getText();
		result = resultText.getText();

		if(InputVerifier.verifyName(name)) {
			MessageDialog.openError(getShell(), "Invalid name", //$NON-NLS-1$
					"Name field must contains first and last name, "
					+ "begins with capital letter, must not contains digits"); //$NON-NLS-1$
			return;
		}
		
		if(InputVerifier.verifyGroupNumber(group)) {
			MessageDialog.openError(getShell(), "Invalid group number", //$NON-NLS-1$
					"Group field must contains an integer number."); //$NON-NLS-1$
			return;
		}
		
		if(InputVerifier.verifyAddress(address)) {
			MessageDialog.openError(getShell(), "Invalid address", //$NON-NLS-1$
					"Address field must contain street name, comma and address number,"
					+ " street name must begins with capital letter."); //$NON-NLS-1$
			return;
		}
		
		if(InputVerifier.verifyCity(city)) {
			MessageDialog.openError(getShell(), "Invalid city name", //$NON-NLS-1$
					"City field must contains a city name, which begins with a capital letter"); //$NON-NLS-1$
			return;
		}
		
		if(InputVerifier.verifyResultByFivePointSystem(result)) {
			MessageDialog.openError(getShell(), "Invalid result", //$NON-NLS-1$
					"Result field must contains a mark from 1 to 5 point, only integers are allowed."); //$NON-NLS-1$
			return;
		}
		super.okPressed();
	}

	public String getName() {
		return name;
	}

	public String getGroup() {
		return group;
	}


	public String getAddress() {
		return address;
	}


	public String getCity() {
		return city;
	}


	public String getResult() {
		return result;
	}
	
}
