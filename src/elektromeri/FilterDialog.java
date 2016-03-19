package elektromeri;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FilterDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfLocation;
	private JTextField tfDate;
	private JButton okButton;

	/**
	 * Create the dialog.
	 */
	public FilterDialog() {
		setTitle("Filters");
		setModal(true);
		setBounds(100, 100, 325, 298);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocation.setBounds(16, 36, 67, 14);
		contentPanel.add(lblLocation);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(16, 88, 46, 14);
		contentPanel.add(lblDate);

		tfLocation = new JTextField();
		tfLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfLocation.setBounds(114, 33, 129, 20);
		contentPanel.add(tfLocation);
		tfLocation.setColumns(10);

		tfDate = new JTextField();
		tfDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDate.setBounds(114, 85, 129, 20);
		contentPanel.add(tfDate);
		tfDate.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JTextField getTfLocation() {
		return tfLocation;
	}
	
	public JTextField getTfDate() {
		return tfDate;
	}

}
