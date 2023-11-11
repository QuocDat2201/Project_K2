package scNotifi;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import screen.JFrameLogin;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entites.Report;
import entites.Role;
import entites.Users;
import models.Report_model;
import models.Role_model;

import javax.swing.border.LineBorder;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import com.toedter.calendar.JDateChooser;

public class JPsendNotifi extends JPanel {
	private  Map<String,Object> dataMap = new HashMap<String, Object>();
	private JPanel panel_list;
	private JTable jtable_Reports_List;
	private JTable jtable_history;
	private JPanel panel_history;
	private JPanel panel_send;
	private JButton jButton_Search_Date;
	private JDateChooser jdateChooser_from;
	private JDateChooser jdateChooser_to;
	private JComboBox jcomboBox_list;
	/**
	 * Create the panel.
	 */
	public JPsendNotifi() {
		setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenuItem jMenuItem_Reports = new JMenuItem("Reports List");
		jMenuItem_Reports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItem_Reports_actionPerformed(e);
			}
		});
		jMenuItem_Reports.setIcon(new ImageIcon(JPsendNotifi.class.getResource("/Small_Icon/report.png")));
		menuBar.add(jMenuItem_Reports);
		
		JMenuItem jMenuItem_Reports_History = new JMenuItem("Reports History");
		jMenuItem_Reports_History.setIcon(new ImageIcon(JPsendNotifi.class.getResource("/Small_Icon/clipboard.png")));
		menuBar.add(jMenuItem_Reports_History);
		
		JMenuItem jMenuItem_send = new JMenuItem("Send Reports");
		jMenuItem_send.setIcon(new ImageIcon(JPsendNotifi.class.getResource("/Small_Icon/send.png")));
		menuBar.add(jMenuItem_send);
		
		JPanel panel_main = new JPanel();
		add(panel_main, BorderLayout.CENTER);
		panel_main.setLayout(new CardLayout(0, 0));
		
		panel_list = new JPanel();
		panel_list.setBorder(new TitledBorder(null, "Reports List", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_main.add(panel_list, "name_1410101594039400");
		panel_list.setLayout(null);
		
		JScrollPane jscrollPane = new JScrollPane();
		jscrollPane.setBounds(10, 162, 595, 228);
		panel_list.add(jscrollPane);
		
		jtable_Reports_List = new JTable();
		jscrollPane.setViewportView(jtable_Reports_List);
		
		JPanel panel_search_date_list = new JPanel();
		panel_search_date_list.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search By Date", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_search_date_list.setBounds(10, 20, 292, 134);
		panel_list.add(panel_search_date_list);
		panel_search_date_list.setLayout(null);
		
		jdateChooser_from = new JDateChooser();
		jdateChooser_from.setDateFormatString("d/MM/y");
		jdateChooser_from.setBounds(54, 23, 228, 28);
		panel_search_date_list.add(jdateChooser_from);
		
		jdateChooser_to = new JDateChooser();
		jdateChooser_to.setDateFormatString("d/MM/y");
		jdateChooser_to.setBounds(54, 61, 228, 28);
		panel_search_date_list.add(jdateChooser_to);
		
		JLabel jLabel_from = new JLabel("From");
		jLabel_from.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel_from.setBounds(10, 23, 34, 28);
		panel_search_date_list.add(jLabel_from);
		
		JLabel jLabel_To = new JLabel("To");
		jLabel_To.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel_To.setBounds(10, 61, 34, 28);
		panel_search_date_list.add(jLabel_To);
		
		jButton_Search_Date = new JButton("Search");
		jButton_Search_Date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_Search_Date_actionPerformed(e);
			}
		});
		jButton_Search_Date.setBounds(106, 99, 85, 21);
		panel_search_date_list.add(jButton_Search_Date);
		
		JPanel panel_sort_role = new JPanel();
		panel_sort_role.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sort By Role", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_sort_role.setBounds(312, 20, 292, 134);
		panel_list.add(panel_sort_role);
		panel_sort_role.setLayout(null);
		
		jcomboBox_list = new JComboBox();
		jcomboBox_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBox_list_actionPerformed(e);
			}
		});
		jcomboBox_list.setBounds(10, 27, 272, 27);
		panel_sort_role.add(jcomboBox_list);
		
		panel_history = new JPanel();
		panel_history.setLayout(null);
		panel_history.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Reports History", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_main.add(panel_history, "name_1410858547499000");
		
		JScrollPane jscrollPane_history = new JScrollPane();
		jscrollPane_history.setBounds(10, 162, 595, 228);
		panel_history.add(jscrollPane_history);
		
		jtable_history = new JTable();
		jscrollPane_history.setViewportView(jtable_history);
		
		JPanel panel_sort_role_history = new JPanel();
		panel_sort_role_history.setLayout(null);
		panel_sort_role_history.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sort By Role", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_sort_role_history.setBounds(312, 20, 292, 134);
		panel_history.add(panel_sort_role_history);
		
		JComboBox comboBox_history = new JComboBox();
		comboBox_history.setBounds(10, 27, 272, 27);
		panel_sort_role_history.add(comboBox_history);
		
		JPanel panel_search_date_history = new JPanel();
		panel_search_date_history.setLayout(null);
		panel_search_date_history.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search By Date", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_search_date_history.setBounds(10, 18, 292, 134);
		panel_history.add(panel_search_date_history);
		
		JDateChooser jdateChooser_from_history = new JDateChooser();
		jdateChooser_from_history.setBounds(54, 23, 228, 28);
		panel_search_date_history.add(jdateChooser_from_history);
		
		JDateChooser jdateChooser_to_history = new JDateChooser();
		jdateChooser_to_history.setBounds(54, 73, 228, 28);
		panel_search_date_history.add(jdateChooser_to_history);
		
		JLabel jLabel_from_history = new JLabel("From");
		jLabel_from_history.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel_from_history.setBounds(10, 23, 34, 28);
		panel_search_date_history.add(jLabel_from_history);
		
		JLabel jLabel_To_history = new JLabel("To");
		jLabel_To_history.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel_To_history.setBounds(10, 73, 34, 28);
		panel_search_date_history.add(jLabel_To_history);
		
		panel_send = new JPanel();
		panel_send.setLayout(null);
		panel_send.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Send Reports", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_main.add(panel_send, "name_1411068521276200");
		
		JScrollPane jscrollPane_send = new JScrollPane();
		jscrollPane_send.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jscrollPane_send.setBounds(10, 20, 292, 370);
		panel_send.add(jscrollPane_send);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		jscrollPane_send.setViewportView(textArea);
		
		JPanel panel_select_role = new JPanel();
		panel_select_role.setLayout(null);
		panel_select_role.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Send To", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_select_role.setBounds(313, 20, 292, 134);
		panel_send.add(panel_select_role);
		
		JComboBox jcomboBox_sendto = new JComboBox();
		jcomboBox_sendto.setBounds(10, 24, 272, 28);
		panel_select_role.add(jcomboBox_sendto);
		
		JButton jButton_Send = new JButton("Send");
		jButton_Send.setBounds(520, 164, 85, 28);
		panel_send.add(jButton_Send);
		
		JButton jButton_Cancel = new JButton("Cancel");
		jButton_Cancel.setBounds(425, 164, 85, 28);
		panel_send.add(jButton_Cancel);

	}
	public JPsendNotifi(Map<String, Object> ob) {
		this();
		this.dataMap = ob;	
		initJFrame();
	}
	
/**************************panel list****************************/
	private void initJFrame() {
		Users users = (Users) dataMap.get("user");
		Role_model role_model = new Role_model();
		int role_to = users.getRoleID();
		Report_model report_model = new Report_model();
		FillDataToJTableList(report_model.find(role_to));
		
		DefaultComboBoxModel<Role> model = new DefaultComboBoxModel<Role>();
		for (Role role : role_model.findExcept(users.getRoleID())) {
			model.addElement(role);
		}
		jcomboBox_list.setModel(model);
		jcomboBox_list.setRenderer(new ListCellRender());
	}
	
	protected void jMenuItem_Reports_actionPerformed(ActionEvent e) {
		panel_list.setVisible(true);
		panel_history.setVisible(false);
		panel_send.setVisible(false);
	}
	
	public void FillDataToJTableList(List<Report> reports) {
		Report_model report_model = new Report_model();
		DefaultTableModel models = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		models.addColumn("Report's ID");
		models.addColumn("Content");
		models.addColumn("From");
		models.addColumn("Created");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (Report report : reports) {
			String role = null;
			if (report.getRole_sent() == 1) {
				role = "Admin";
			} else if (report.getRole_sent() == 2) {
				role = "Storage Manager";
			} else if (report.getRole_sent() == 3) {
				role = "Saler";
			} else if (report.getRole_sent() == 4) {
				role = "Sale Manager";
			}
			
			models.addRow(new Object[] {
				report.getId(),
				report.getContent(),
				role,
				simpleDateFormat.format(report.getCreate())
			});
		}
		
		jtable_Reports_List.setModel(models);
		jtable_Reports_List.getTableHeader().setReorderingAllowed(false);
	}
	protected void jButton_Search_Date_actionPerformed(ActionEvent e) {
		try {
			Report_model report_model = new Report_model();
			Date from = jdateChooser_from.getDate();
			Date to = jdateChooser_to.getDate();
			Users users = (Users) dataMap.get("user");
			FillDataToJTableList(report_model.SearchDate(from, to, users.getRoleID()));
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Cannot find !");
		}
	}
	
	private class ListCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Role role = (Role) value;
			return super.getListCellRendererComponent(list, role.getRole_Name(), index, isSelected, cellHasFocus);
		}
		
	}
	
	protected void jcomboBox_list_actionPerformed(ActionEvent e) {
		try {
			Users users = (Users) dataMap.get("user");
			Report_model report_model = new Report_model();
			Role role = (Role) jcomboBox_list.getSelectedItem();
			FillDataToJTableList(report_model.SearchRole(role.getRole_id(), users.getRoleID()));
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Cannot Find!");
		}
	}
}
