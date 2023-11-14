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

public class JPeditrank extends JPanel {
	private JTextField jrank;
	private JTextField jpoint;
	private JTextField jdiscount;
	private int idd;

	/**
	 * Create the panel.
	 */
	public JPeditrank() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Rank");
		panel.add(lblNewLabel);
		
		jrank = new JTextField();
		jrank.setColumns(10);
		panel.add(jrank);
		
		JLabel lblNewLabel_1 = new JLabel("Point");
		panel.add(lblNewLabel_1);
		
		jpoint = new JTextField();
		jpoint.setColumns(10);
		panel.add(jpoint);
		
		JLabel lblNewLabel_2 = new JLabel("Discount");
		panel.add(lblNewLabel_2);
		
		jdiscount = new JTextField();
		jdiscount.setColumns(10);
		panel.add(jdiscount);
		
		JButton jbtUpdate = new JButton("Update");
		jbtUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbtUpdate_actionPerformed(e);
			}
		});
		jbtUpdate.setMargin(new Insets(2, 5, 2, 5));
		panel.add(jbtUpdate);

	}
	public JPeditrank(int id) {
		this();
		idd=id;
		RankModel rankModel=new RankModel();
		for (Rank rank: rankModel.findAll()) {
			System.err.println(rank.getId());
			if (rank.getId()==id) {
				jrank.setText(rank.getRank());
				jdiscount.setText(String.valueOf(rank.getDiscount()) );
				jpoint.setText(String.valueOf(rank.getPoint()));
				break;
			}
		}
	}

	protected void do_jbtUpdate_actionPerformed(ActionEvent e) {
		RankModel rankModel=new RankModel();
		Rank rank = new Rank();
		rank.setRank(jrank.getText());
		rank.setDiscount(Integer.valueOf(jdiscount.getText()) );
		rank.setPoint(Integer.valueOf(jpoint.getText()));
		rank.setId(idd);
		if (rankModel.update(rank)){
			JOptionPane.showMessageDialog(null,"Success");
			JPmenucustomer.mntmNewMenuItem_1.doClick();
		} else {
			JOptionPane.showMessageDialog(null,"Inval");
		}
	}
}
