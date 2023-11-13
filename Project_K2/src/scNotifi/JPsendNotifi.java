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
import javax.swing.table.JTableHeader;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;

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
	private JButton jButton_searchHistory;
	private JDateChooser jdateChooser_from_history;
	private JDateChooser jdateChooser_to_history;
	private JButton jButton_Send;
	private JButton jButton_Cancel;
	private JComboBox jcomboBox_sendto;
	private JTextArea jtextArea_send;
	private JDateChooser jdateChooser_sendDate;
	private Report reports;
	private JPopupMenu jpopupMenu_List;
	private JMenuItem jMenuItem_Detail;
	private JPanel panel_details;
	private JScrollPane jscrollPane_reportdetails;
	private JPanel panel_RoleReportDetails;
	private JPanel jpanel_DateReportDetails;
	private JDateChooser jdateChooser_ReportDetails;
	private JTextArea jtextArea_reportdetails;
	private JTextField jtextField_RoleReportDetails;
	private JPopupMenu jpopupMenu_History;
	private JMenuItem jMenuItem_DetailsHistory;
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
		jMenuItem_Reports_History.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItem_Reports_History_actionPerformed(e);
			}
		});
		jMenuItem_Reports_History.setIcon(new ImageIcon(JPsendNotifi.class.getResource("/Small_Icon/clipboard.png")));
		menuBar.add(jMenuItem_Reports_History);
		
		JMenuItem jMenuItem_send = new JMenuItem("Send Reports");
		jMenuItem_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItem_send_actionPerformed(e);
			}
		});
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
		jtable_Reports_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtable_Reports_List.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtable_Reports_List_mouseClicked(e);
			}
		});
		
		jpopupMenu_List = new JPopupMenu();
		addPopup(jscrollPane, jpopupMenu_List);
		
		jMenuItem_Detail = new JMenuItem("More Details");
		jMenuItem_Detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItem_Detail_actionPerformed(e);
			}
		});
		jMenuItem_Detail.setIcon(new ImageIcon(JPsendNotifi.class.getResource("/Small_Icon/file.png")));
		jpopupMenu_List.add(jMenuItem_Detail);
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
		jtable_history.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtable_history.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtable_history_mouseClicked(e);
			}
		});
		
		jpopupMenu_History = new JPopupMenu();
		addPopup(jscrollPane_history, jpopupMenu_History);
		
		jMenuItem_DetailsHistory = new JMenuItem("Details");
		jMenuItem_DetailsHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItem_DetailsHistory_actionPerformed(e);
			}
		});
		jMenuItem_DetailsHistory.setIcon(new ImageIcon(JPsendNotifi.class.getResource("/Small_Icon/file.png")));
		jpopupMenu_History.add(jMenuItem_DetailsHistory);
		jscrollPane_history.setViewportView(jtable_history);
		
		JPanel panel_search_date_history = new JPanel();
		panel_search_date_history.setLayout(null);
		panel_search_date_history.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search By Date", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_search_date_history.setBounds(162, 18, 292, 134);
		panel_history.add(panel_search_date_history);
		
		jdateChooser_from_history = new JDateChooser();
		jdateChooser_from_history.setDateFormatString("d/MM/y");
		jdateChooser_from_history.setBounds(54, 23, 228, 28);
		panel_search_date_history.add(jdateChooser_from_history);
		
		jdateChooser_to_history = new JDateChooser();
		jdateChooser_to_history.setDateFormatString("d/MM/y");
		jdateChooser_to_history.setBounds(54, 61, 228, 28);
		panel_search_date_history.add(jdateChooser_to_history);
		
		JLabel jLabel_from_history = new JLabel("From");
		jLabel_from_history.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel_from_history.setBounds(10, 23, 34, 28);
		panel_search_date_history.add(jLabel_from_history);
		
		JLabel jLabel_To_history = new JLabel("To");
		jLabel_To_history.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel_To_history.setBounds(10, 61, 34, 28);
		panel_search_date_history.add(jLabel_To_history);
		
		jButton_searchHistory = new JButton("Search");
		jButton_searchHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_searchHistory_actionPerformed(e);
			}
		});
		jButton_searchHistory.setBounds(107, 99, 85, 21);
		panel_search_date_history.add(jButton_searchHistory);
		
		panel_send = new JPanel();
		panel_send.setLayout(null);
		panel_send.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Send Reports", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_main.add(panel_send, "name_1411068521276200");
		
		JScrollPane jscrollPane_send = new JScrollPane();
		jscrollPane_send.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jscrollPane_send.setBounds(10, 20, 293, 370);
		panel_send.add(jscrollPane_send);
		
		jtextArea_send = new JTextArea();
		jtextArea_send.setLineWrap(true);
		jscrollPane_send.setViewportView(jtextArea_send);
		
		JPanel panel_select_role = new JPanel();
		panel_select_role.setLayout(null);
		panel_select_role.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Send To", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_select_role.setBounds(313, 20, 292, 65);
		panel_send.add(panel_select_role);
		
		jcomboBox_sendto = new JComboBox();
		jcomboBox_sendto.setBounds(10, 24, 272, 28);
		panel_select_role.add(jcomboBox_sendto);
		
		jButton_Send = new JButton("Send");
		jButton_Send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_Send_actionPerformed(e);
			}
		});
		jButton_Send.setBounds(520, 164, 85, 28);
		panel_send.add(jButton_Send);
		
		jButton_Cancel = new JButton("Cancel");
		jButton_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_Cancel_actionPerformed(e);
			}
		});
		jButton_Cancel.setBounds(425, 164, 85, 28);
		panel_send.add(jButton_Cancel);
		
		JPanel panel_date = new JPanel();
		panel_date.setLayout(null);
		panel_date.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Send Date", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_date.setBounds(313, 95, 292, 65);
		panel_send.add(panel_date);
		
		jdateChooser_sendDate = new JDateChooser();
		jdateChooser_sendDate.setEnabled(false);
		jdateChooser_sendDate.setDateFormatString("d/MM/y");
		jdateChooser_sendDate.setBounds(10, 27, 272, 28);
		panel_date.add(jdateChooser_sendDate);
		
		panel_details = new JPanel();
		panel_details.setLayout(null);
		panel_details.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Report Detail", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_main.add(panel_details, "name_10196213263200");
		
		jscrollPane_reportdetails = new JScrollPane();
		jscrollPane_reportdetails.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jscrollPane_reportdetails.setBounds(10, 20, 293, 370);
		panel_details.add(jscrollPane_reportdetails);
		
		jtextArea_reportdetails = new JTextArea();
		jtextArea_reportdetails.setLineWrap(true);
		jtextArea_reportdetails.setEditable(false);
		jscrollPane_reportdetails.setViewportView(jtextArea_reportdetails);
		
		panel_RoleReportDetails = new JPanel();
		panel_RoleReportDetails.setLayout(null);
		panel_RoleReportDetails.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Send From", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_RoleReportDetails.setBounds(313, 20, 292, 65);
		panel_details.add(panel_RoleReportDetails);
		
		jtextField_RoleReportDetails = new JTextField();
		jtextField_RoleReportDetails.setEditable(false);
		jtextField_RoleReportDetails.setBounds(10, 27, 272, 28);
		panel_RoleReportDetails.add(jtextField_RoleReportDetails);
		jtextField_RoleReportDetails.setColumns(10);
		
		jpanel_DateReportDetails = new JPanel();
		jpanel_DateReportDetails.setLayout(null);
		jpanel_DateReportDetails.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Send Date", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jpanel_DateReportDetails.setBounds(313, 95, 292, 65);
		panel_details.add(jpanel_DateReportDetails);
		
		jdateChooser_ReportDetails = new JDateChooser();
		jdateChooser_ReportDetails.setEnabled(false);
		jdateChooser_ReportDetails.setDateFormatString("d/MM/y");
		jdateChooser_ReportDetails.setBounds(10, 27, 272, 28);
		jpanel_DateReportDetails.add(jdateChooser_ReportDetails);

	}
	public JPsendNotifi(Map<String, Object> ob) {
		this();
		this.dataMap = ob;	
		initJFrame();
	}
	
/**************************Start of Panel List****************************/
	private void initJFrame() {
		Users users = (Users) dataMap.get("user");
		Role_model role_model = new Role_model();
		int role_to = users.getRoleID();
		Report_model report_model = new Report_model();
			
		DefaultComboBoxModel<Role> model = new DefaultComboBoxModel<Role>();
		for (Role role : role_model.findExcept(users.getRoleID())) {
			model.addElement(role);
		}
		jcomboBox_list.setModel(model);
		jcomboBox_list.setRenderer(new ListCellRender());
		jtable_Reports_List.setComponentPopupMenu(jpopupMenu_List);
		
		/********Role Admin*******/
		if (users.getRoleID() == 1) {
			FillDataToJTableList(report_model.findall());
		} else {
			FillDataToJTableList(report_model.find(role_to));
		}
	}
	
	protected void jMenuItem_Reports_actionPerformed(ActionEvent e) {
		panel_list.setVisible(true);
		panel_history.setVisible(false);
		panel_send.setVisible(false);
		panel_details.setVisible(false);
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
			
			/************Role Admin*************/
			if (users.getRoleID() == 1) {
				FillDataToJTableList(report_model.SearchDateListAdmin(from, to));
			} else {
				FillDataToJTableList(report_model.SearchDateList(from, to, users.getRoleID()));
			}
			
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
			
			/******Role Admin******/
			if (users.getRoleID() == 1) {
				FillDataToJTableList(report_model.SearchRoleListAdmin(role.getRole_id()));
			} else {
				FillDataToJTableList(report_model.SearchRoleList(role.getRole_id(), users.getRoleID()));
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Cannot Find!");
		}
	}
	
	protected void jtable_Reports_List_mouseClicked(MouseEvent e) {
		Users users = (Users) dataMap.get("user");
		Report_model report_model = new Report_model();
		JTableHeader header = (JTableHeader) e.getSource();
		int column = header.columnAtPoint(e.getPoint());
		
		if (users.getRoleID() == 1) {
			switch (column) {
			case 0:
				if (e.getClickCount() % 2 ==0) {
					FillDataToJTableList(report_model.AdminSort_ID_desc());
				} else {
					FillDataToJTableList(report_model.AdminSort_ID_asc());
				}
				break;
			case 2:
				if (e.getClickCount() % 2 ==0) {
					FillDataToJTableList(report_model.AdminSort_Role_desc());
				} else {
					FillDataToJTableList(report_model.AdminSort_Role_asc());
				}
				break;
			case 3:
				if (e.getClickCount() % 2 ==0) {
					FillDataToJTableList(report_model.AdminSort_Date_desc());
				} else {
					FillDataToJTableList(report_model.AdminSort_Date_asc());
				}
				break;
			default:
				break;
			}
		} else {
			switch (column) {
			case 0:
				if (e.getClickCount() % 2 ==0) {
					FillDataToJTableList(report_model.Sort_ID_desc(users.getRoleID()));
				} else {
					FillDataToJTableList(report_model.Sort_ID_asc(users.getRoleID()));
				}
				break;
			case 2:
				if (e.getClickCount() % 2 ==0) {
					FillDataToJTableList(report_model.Sort_Role_desc(users.getRoleID()));
				} else {
					FillDataToJTableList(report_model.Sort_Role_asc(users.getRoleID()));
				}
				break;
			case 3:
				if (e.getClickCount() % 2 ==0) {
					FillDataToJTableList(report_model.Sort_Date_desc(users.getRoleID()));
				} else {
					FillDataToJTableList(report_model.Sort_Date_asc(users.getRoleID()));
				}
				break;
			default:
				break;
			}
		}
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
	/**************************End of Panel List****************************/
	
	/**************************Start of Panel History****************************/
	
	protected void jMenuItem_Reports_History_actionPerformed(ActionEvent e) {
		panel_history.setVisible(true);
		panel_list.setVisible(false);
		panel_send.setVisible(false);
		panel_details.setVisible(false);
		
		Users users = (Users) dataMap.get("user");
		Role_model role_model = new Role_model();
		Report_model report_model = new Report_model();
		Report report = new Report();
		int role_from = users.getRoleID();

		FillDataToJTableHistory(report_model.findhistory(role_from));
		jtable_history.setComponentPopupMenu(jpopupMenu_History);
	}
	
	public void FillDataToJTableHistory(List<Report> reports) {
		Report_model report_model = new Report_model();
		DefaultTableModel models = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		models.addColumn("Report's ID");
		models.addColumn("Content");
		models.addColumn("To");
		models.addColumn("Created");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (Report report : reports) {
			String role = null;
			if (report.getRole_report() == 1) {
				role = "Admin";
			} else if (report.getRole_report() == 2) {
				role = "Storage Manager";
			} else if (report.getRole_report() == 3) {
				role = "Saler";
			} else if (report.getRole_report() == 4) {
				role = "Sale Manager";
			}
			
			models.addRow(new Object[] {
				report.getId(),
				report.getContent(),
				role,
				simpleDateFormat.format(report.getCreate())
			});
		}
		
		jtable_history.setModel(models);
		jtable_history.getTableHeader().setReorderingAllowed(false);
	}
	
	protected void jButton_searchHistory_actionPerformed(ActionEvent e) {
		try {
			Users users = (Users) dataMap.get("user");
			Report_model report_model = new Report_model();
			
			Date from = jdateChooser_from_history.getDate();
			Date to = jdateChooser_to_history.getDate();
			FillDataToJTableHistory(report_model.SearchDateHistory(from, to ,users.getRoleID()));
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	
	
	protected void jtable_history_mouseClicked(MouseEvent e) {
		Users users = (Users) dataMap.get("user");
		Report_model report_model = new Report_model();
		JTableHeader header = (JTableHeader) e.getSource();
		int column = header.columnAtPoint(e.getPoint());
		/**************Admin Role*************/
		if (users.getRoleID() == 1) {
			switch (column) {
			case 0:
				if (e.getClickCount() % 2 ==0) {
					FillDataToJTableHistory(report_model.AdminSort_ID_desc());
				} else {
					FillDataToJTableHistory(report_model.AdminSort_ID_asc());
				}
				break;
			case 3:
				if (e.getClickCount() % 2 ==0) {
					FillDataToJTableHistory(report_model.AdminSort_Date_desc());
				} else {
					FillDataToJTableHistory(report_model.AdminSort_Date_asc());
				}
				break;
			default:
				break;
			}
		} else {
			switch (column) {
			case 0:
				if (e.getClickCount() % 2 ==0) {
					FillDataToJTableHistory(report_model.Sort_IDhistory_desc(users.getRoleID()));
				} else {
					FillDataToJTableHistory(report_model.Sort_IDhistory_asc(users.getRoleID()));
				}
				break;
			case 3:
				if (e.getClickCount() % 2 ==0) {
					FillDataToJTableHistory(report_model.Sort_Datehistoy_desc(users.getRoleID()));
				} else {
					FillDataToJTableHistory(report_model.Sort_Datehistory_asc(users.getRoleID()));
				}
				break;
			default:
				break;
			}
		}
	}
	
	/**************************End of Panel History****************************/
	
	/**************************Start of Panel Send****************************/
	protected void jMenuItem_send_actionPerformed(ActionEvent e) {
		panel_send.setVisible(true);	
		panel_list.setVisible(false);
		panel_history.setVisible(false);
		panel_details.setVisible(false);
		
		Users users = (Users) dataMap.get("user");
		Role_model role_model = new Role_model();
		DefaultComboBoxModel<Role> model = new DefaultComboBoxModel<Role>();
		for (Role role : role_model.findExcept(users.getRoleID())) {
			model.addElement(role);
		}
		jcomboBox_sendto.setModel(model);
		jcomboBox_sendto.setRenderer(new SendListCellRender());
		
		jdateChooser_sendDate.setDate(new Date());
		
	}
	
	private class SendListCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Role role = (Role) value;
			return super.getListCellRendererComponent(list, role.getRole_Name(), index, isSelected, cellHasFocus);
		}
		
	}
	protected void jButton_Send_actionPerformed(ActionEvent e) {
		Report report = new Report();
		Users users = (Users) dataMap.get("user");
		Report_model report_model = new Report_model();
		Role role = (Role) jcomboBox_sendto.getSelectedItem();
		
		String Text = jtextArea_send.getText();
		report.setRole_sent(users.getRoleID());
		report.setRole_report(role.getRole_id());
		report.setCreate(jdateChooser_sendDate.getDate());
		
		if (Text == null) {
			JOptionPane.showMessageDialog(null, "You need to ENTER your report !");
		} else {
			report.setContent(Text);
			
			if (report_model.Send(report)) {
				JOptionPane.showMessageDialog(null, "Sent Successfully !");
				jtextArea_send.setText("");
				jcomboBox_sendto.setSelectedIndex(0);
			} else {
				JOptionPane.showMessageDialog(null, "Send Failed !");
			}
		}
		System.out.println(users.getRoleID());
	}
	
	protected void jButton_Cancel_actionPerformed(ActionEvent e) {
		jtextArea_send.setText("");
		jcomboBox_sendto.setSelectedIndex(0);
	}
	
	/**************************End of Panel Send****************************/
	
	/**************************Start of Panel Details List****************************/
	protected void jMenuItem_Detail_actionPerformed(ActionEvent e) {
		panel_details.setVisible(true);
		panel_send.setVisible(false);	
		panel_list.setVisible(false);
		panel_history.setVisible(false);
		panel_RoleReportDetails.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Send From", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		Users users = (Users) dataMap.get("user");
		Report_model report_model = new Report_model();
		Role_model role_model = new Role_model();
		
		int selected = jtable_Reports_List.getSelectedRow();
		int id = Integer.parseInt(jtable_Reports_List.getValueAt(selected, 0).toString());
		
		reports = report_model.findID(id);
		jtextArea_reportdetails.setText(reports.getContent());
		int role = reports.getRole_sent();
		if (role == 2) {
			jtextField_RoleReportDetails.setText("Storage Manager");
		} else if (role == 3) {
			jtextField_RoleReportDetails.setText("Saler");
		} else if (role == 4) {
			jtextField_RoleReportDetails.setText("Sale Manager");
		} else if (role == 1) {
			jtextField_RoleReportDetails.setText("Admin");
		}
		jdateChooser_ReportDetails.setDate(reports.getCreate());
	}
	/**************************End of Panel Details List****************************/
	
	/**************************Start of Panel Details History****************************/
	protected void jMenuItem_DetailsHistory_actionPerformed(ActionEvent e) {
		panel_details.setVisible(true);
		panel_send.setVisible(false);	
		panel_list.setVisible(false);
		panel_history.setVisible(false);
		panel_RoleReportDetails.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Send To", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		Users users = (Users) dataMap.get("user");
		Report_model report_model = new Report_model();
		Role_model role_model = new Role_model();
		
		int selected = jtable_history.getSelectedRow();
		int id = Integer.parseInt(jtable_history.getValueAt(selected, 0).toString());
		
		reports = report_model.findID(id);
		jtextArea_reportdetails.setText(reports.getContent());
		int role = reports.getRole_report();
		if (role == 2) {
			jtextField_RoleReportDetails.setText("Storage Manager");
		} else if (role == 3) {
			jtextField_RoleReportDetails.setText("Saler");
		} else if (role == 4) {
			jtextField_RoleReportDetails.setText("Sale Manager");
		} else if (role == 1) {
			jtextField_RoleReportDetails.setText("Admin");
		}
		jdateChooser_ReportDetails.setDate(reports.getCreate());
	}
	/**************************End of Panel Details History****************************/
}
