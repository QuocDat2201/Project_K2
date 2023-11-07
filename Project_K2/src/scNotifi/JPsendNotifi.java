package scNotifi;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.HashMap;
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
import javax.swing.border.LineBorder;

public class JPsendNotifi extends JPanel {
	private  Map<String,Object> dataMap=new HashMap<String, Object>();
	/**
	 * Create the panel.
	 */
	public JPsendNotifi() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Mailbox", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_2, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar, BorderLayout.NORTH);
		
		JMenuItem jmenuInbox = new JMenuItem("Inbox");
		jmenuInbox.setHorizontalTextPosition(SwingConstants.LEFT);
		jmenuInbox.setHorizontalAlignment(SwingConstants.RIGHT);
		jmenuInbox.setIcon(new ImageIcon(JPsendNotifi.class.getResource("/Icon/inbox-mail.png")));
		jmenuInbox.setBackground(new Color(240, 240, 240));
		jmenuInbox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jmenuInbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmNewMenuItem_actionPerformed(e);
			}
		});
		menuBar.add(jmenuInbox);
		
		JMenuItem jmailbox = new JMenuItem("Sent mailbox");
		jmailbox.setHorizontalTextPosition(SwingConstants.LEFT);
		jmailbox.setHorizontalAlignment(SwingConstants.RIGHT);
		jmailbox.setIcon(new ImageIcon(JPsendNotifi.class.getResource("/Icon/send.png")));
		jmailbox.setBackground(new Color(240, 240, 240));
		jmailbox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(jmailbox);

	}
	public JPsendNotifi(Object ob) {
		this();
		dataMap=(Map<String, Object>) ob;	
		initJFrame();
	}
	private void initJFrame() {
		

	}

	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {
		System.out.println("abc");
	}
	
}
