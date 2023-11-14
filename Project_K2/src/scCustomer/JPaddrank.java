package scCustomer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;

public class JPaddrank extends JPanel {
	private JTextField Jrank;
	private JTextField jpoint;
	private JTextField jdiscount;

	/**
	 * Create the panel.
	 */
	public JPaddrank() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Rank");
		panel.add(lblNewLabel);
		
		Jrank = new JTextField();
		panel.add(Jrank);
		Jrank.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Point");
		panel.add(lblNewLabel_1);
		
		jpoint = new JTextField();
		panel.add(jpoint);
		jpoint.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Discount");
		panel.add(lblNewLabel_2);
		
		jdiscount = new JTextField();
		panel.add(jdiscount);
		jdiscount.setColumns(10);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setMargin(new Insets(2, 5, 2, 5));
		panel.add(btnNewButton);

	}

}
