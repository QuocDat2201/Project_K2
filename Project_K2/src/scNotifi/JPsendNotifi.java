package scNotifi;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import screen.JFrameLogin;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import entites.Report;

import javax.swing.border.LineBorder;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class JPsendNotifi extends JPanel {
	private  Map<String,Object> dataMap=new HashMap<String, Object>();
	private JPanel panel_list;
	private JTable jtable_Reports_List;
	private JTextField jtextField_search_list;
	private JTextField jtextField_search_history;
	private JTable jtable_history;
	/**
	 * Create the panel.
	 */
	public JPsendNotifi() {
		setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenuItem jMenuItem_Reports = new JMenuItem("Reports List");
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
		
		JPanel panel_search_list = new JPanel();
		panel_search_list.setBorder(new TitledBorder(null, "Search By Name", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_search_list.setBounds(10, 20, 292, 134);
		panel_list.add(panel_search_list);
		panel_search_list.setLayout(null);
		
		jtextField_search_list = new JTextField();
		jtextField_search_list.setBounds(10, 26, 272, 29);
		panel_search_list.add(jtextField_search_list);
		jtextField_search_list.setColumns(10);
		
		JButton jButton_search_list = new JButton("Search");
		jButton_search_list.setBounds(99, 65, 85, 29);
		panel_search_list.add(jButton_search_list);
		
		JPanel panel_sort_role = new JPanel();
		panel_sort_role.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sort By Role", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_sort_role.setBounds(312, 20, 292, 134);
		panel_list.add(panel_sort_role);
		panel_sort_role.setLayout(null);
		
		JComboBox jcomboBox_list = new JComboBox();
		jcomboBox_list.setBounds(10, 27, 272, 27);
		panel_sort_role.add(jcomboBox_list);
		
		JPanel panel_history = new JPanel();
		panel_history.setLayout(null);
		panel_history.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Reports History", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_main.add(panel_history, "name_1410858547499000");
		
		JScrollPane jscrollPane_history = new JScrollPane();
		jscrollPane_history.setBounds(10, 162, 595, 228);
		panel_history.add(jscrollPane_history);
		
		jtable_history = new JTable();
		jscrollPane_history.setViewportView(jtable_history);
		
		JPanel panel_search_history = new JPanel();
		panel_search_history.setLayout(null);
		panel_search_history.setBorder(new TitledBorder(null, "Search By Name", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_search_history.setBounds(10, 20, 292, 134);
		panel_history.add(panel_search_history);
		
		jtextField_search_history = new JTextField();
		jtextField_search_history.setColumns(10);
		jtextField_search_history.setBounds(10, 26, 272, 29);
		panel_search_history.add(jtextField_search_history);
		
		JButton jButton_search_history = new JButton("Search");
		jButton_search_history.setBounds(99, 65, 85, 29);
		panel_search_history.add(jButton_search_history);
		
		JPanel panel_sort_role_history = new JPanel();
		panel_sort_role_history.setLayout(null);
		panel_sort_role_history.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sort By Role", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_sort_role_history.setBounds(312, 20, 292, 134);
		panel_history.add(panel_sort_role_history);
		
		JComboBox comboBox_history = new JComboBox();
		comboBox_history.setBounds(10, 27, 272, 27);
		panel_sort_role_history.add(comboBox_history);
		
		JPanel panel_send = new JPanel();
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
	public JPsendNotifi(Object ob) {
		this();
		dataMap=(Map<String, Object>) ob;	
		initJFrame();
	}
	private void initJFrame() {
		

	}
	
	public void FillDataToJTableList(List<Report> reports) {
		
	}
}
