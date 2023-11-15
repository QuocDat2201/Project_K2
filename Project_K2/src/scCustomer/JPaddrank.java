package scCustomer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entites.Rank;
import models.RankModel;

import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setMargin(new Insets(2, 5, 2, 5));
		panel.add(btnNewButton);

	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		Rank  rank = new Rank();
		rank.setRank(Jrank.getText());
		rank.setPoint( Integer.valueOf(jpoint.getText()));
		rank.setDiscount(Integer.valueOf(jdiscount.getText()));
		RankModel rankModel= new RankModel();
		System.out.println(rank.getPoint());
		if (rankModel.create(rank)) {
			JOptionPane.showMessageDialog(null,"Ok" );
			JPmenucustomer.mntmNewMenuItem_1.doClick();
		} else {
			JOptionPane.showMessageDialog(null,"Faill" );
		}
		
	}
}
