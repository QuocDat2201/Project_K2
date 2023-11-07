package scCustomer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entites.Customer;
import entites.Rank;
import models.CustomerModel;
import models.RankModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPrank extends JPanel {
	private JTable table;
	private JPanel panel_1;

	/**
	 * Create the panel.
	 */
	public JPrank() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("add rank");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(JPrank.class.getResource("/Icon/7007523_rate_ranking_rank_finance_business_icon.png")));
		panel_1.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 0, 0));
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);
		
		JMenuItem jedit = new JMenuItem("Edit");
		jedit.setIcon(new ImageIcon(JPrank.class.getResource("/Small_Icon/edit.png")));
		popupMenu.add(jedit);
		
		JMenuItem jdelete = new JMenuItem("Delete");
		jdelete.setIcon(new ImageIcon(JPrank.class.getResource("/Small_Icon/bin (1).png")));
		popupMenu.add(jdelete);

		table = new JTable();
		table.setComponentPopupMenu(popupMenu);
		scrollPane.setViewportView(table);
		iniJFrame();
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private void iniJFrame() {
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		model.addColumn("Point");
		model.addColumn("RankName");
		model.addColumn("Discount");
		RankModel rankModel = new RankModel();try {
			for (Rank rank : rankModel.findAll()) {
				model.addRow(new Object[] {rank.getPoint() ,rank.getRank(),rank.getDiscount()});

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		table.setModel(model);
		int rowHeight = 25; // Đặt chiều cao hàng tùy ý
		table.setRowHeight(rowHeight);
		table.getTableHeader().setReorderingAllowed(false);

	}
}
