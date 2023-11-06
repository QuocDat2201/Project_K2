package screen;

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
		scrollPane.setViewportView(table);
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
}
