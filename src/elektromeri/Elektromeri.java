package elektromeri;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;

public class Elektromeri {

	private JFrame frame;
	private JTable table;
	private FilterDialog filterDialog;
	private String currLocationFilter = "";
	private String currDateFilter = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Elektromeri window = new Elektromeri();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Elektromeri() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u0415\u043B\u0435\u043A\u0442\u0440\u043E\u043C\u0435\u0440\u0438");
		frame.setBounds(100, 100, 1280, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		filterDialog = new FilterDialog();
		filterDialog.setLocationRelativeTo(null);

		String[] columnNames = { "First Name", "Last Name", "Sport", "# of Years", "Vegetarian" };

		Object[][] data = { { "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1264, 533);
		frame.getContentPane().add(scrollPane);

		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(1165, 543, 89, 23);
		frame.getContentPane().add(btnDelete);

		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(1066, 543, 89, 23);
		frame.getContentPane().add(btnEdit);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(967, 543, 89, 23);
		frame.getContentPane().add(btnAdd);

		JButton btnFilter = new JButton("Filter");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filterDialog.setVisible(true);
				filterDialog.getTfLocation().setText(currLocationFilter);
				filterDialog.getTfDate().setText(currDateFilter);
			}
		});
		btnFilter.setBounds(10, 544, 89, 23);
		frame.getContentPane().add(btnFilter);

		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(0, 577, 1264, 164);
		frame.getContentPane().add(scrollPane1);

		JTextArea txtrLog = new JTextArea();
		txtrLog.setEditable(false);
		txtrLog.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtrLog.setText("Console output here...\r");
		scrollPane1.setViewportView(txtrLog);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmImport = new JMenuItem("Import");
		mnFile.add(mntmImport);

		JMenuItem mntmExport = new JMenuItem("Export");
		mnFile.add(mntmExport);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);

		filterDialog.getOkButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currLocationFilter = filterDialog.getTfLocation().getText();
				currDateFilter = filterDialog.getTfDate().getText();
				
				txtrLog.setText(txtrLog.getText() + "\nSetting filters: Location: "
						+ currLocationFilter + " Date: " + currDateFilter);
				
				filterDialog.dispose();
			}
		});



	}
}
