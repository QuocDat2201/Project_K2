package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JMenu;
import javax.swing.border.LineBorder;

public class Home extends JFrame {
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private JPanel contentPane;
	private JPanel jpanel_2;
	private String title = "Maneger";
	private static Home frame;
	private JButton jbtlistproduct;
	private JButton jbtinvoice;
	private JButton jbthome;
	private JPanel panel;
	private JButton jbtaccount;
	private JButton btnNewButton;
	private 
	Font defaultFont = new Font("Arial", Font.PLAIN, 14);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setTitle("Manager");
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 513);
		getContentPane().setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(new Color(254, 199, 222));
		getContentPane().add(panel, BorderLayout.WEST);

		jbthome = new JButton("Home");
		jbthome.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbthome.setHorizontalAlignment(SwingConstants.LEFT);
		jbthome.setMinimumSize(new Dimension(59, 20));
		jbthome.setMaximumSize(new Dimension(190, 50));
		jbthome.setBackground(new Color(128, 128, 0));
		jbthome.setBorder(new LineBorder(new Color(255, 191, 226), 4));
		jbthome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		jbthome.setIcon(new ImageIcon(Home.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(jbthome);

		jbtinvoice = new JButton("Invoice");
		jbtinvoice.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbtinvoice.setHorizontalAlignment(SwingConstants.LEFT);
		jbtinvoice.setMinimumSize(new Dimension(59, 20));
		jbtinvoice.setMaximumSize(new Dimension(190, 50));
		jbtinvoice.setBackground(new Color(128, 128, 0));
		jbtinvoice.setBorder(new LineBorder(new Color(255, 191, 226), 4));
		jbtinvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		jbtinvoice.setIcon(new ImageIcon(Home.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(jbtinvoice);

		jbtlistproduct = new JButton("Storage");
		jbtlistproduct.setMinimumSize(new Dimension(59, 20));
		jbtlistproduct.setMaximumSize(new Dimension(190, 50));
		jbtlistproduct.setBackground(new Color(128, 128, 0));
		jbtlistproduct.setBorder(new LineBorder(new Color(255, 191, 226), 4));
		jbtlistproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbtlistproduct_actionPerformed(e);
			}
		});
		jbtlistproduct.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));
		jbtlistproduct
				.setIcon(new ImageIcon(Home.class.getResource("/Icon/4172167_box_object_product_item_merchandise_icon.png")));
		panel.add(jbtlistproduct);

		JButton jbtsend = new JButton("Send");
		jbtsend.setMinimumSize(new Dimension(59, 20));
		jbtsend.setMaximumSize(new Dimension(190, 50));
		jbtsend.setBackground(new Color(128, 128, 0));
		jbtsend.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		jbtsend.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbtsend.setHorizontalAlignment(SwingConstants.LEFT);
		jbtsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		jbtsend.setIcon(new ImageIcon(Home.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(jbtsend);

		jbtaccount = new JButton("Account");
		jbtaccount.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbtaccount .setMinimumSize(new Dimension(59, 20));
		jbtaccount .setMaximumSize(new Dimension(190, 50));
		jbtaccount .setBackground(new Color(128, 128, 0));
		jbtaccount .setBorder(new LineBorder(new Color(255, 255, 255), 4));
		jbtaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbtaccount_actionPerformed(e);
			}
		});
		jbtaccount.setIcon(new ImageIcon(Home.class.getResource("/Icon/172626_user_male_icon.png")));
		panel.add(jbtaccount);

		btnNewButton = new JButton("Sign out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton.setMinimumSize(new Dimension(59, 20));
		btnNewButton.setMaximumSize(new Dimension(190, 50));
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 0, 95));
		getContentPane().add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel_1.add(lblNewLabel);

		jpanel_2 = new JPanel();
		getContentPane().add(jpanel_2, BorderLayout.CENTER);
		jpanel_2.setLayout(new BorderLayout(0, 0));
	}

	public Home(Object ob) {
		this();
		dataMap = (Map<String, Object>) ob;
		JPhome jPhome = new JPhome(dataMap);
		jpanel_2.removeAll();
		jpanel_2.revalidate();
		jpanel_2.add(jPhome);
		jpanel_2.setVisible(true);
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {// Home
		JPhome jPhome = new JPhome(dataMap);
		jpanel_2.removeAll();
		jpanel_2.revalidate();
		jpanel_2.add(jPhome);
		jpanel_2.setVisible(true);

	}

	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {// send

		JPsendNotifi jPsendNotifi = new JPsendNotifi(dataMap);

		jpanel_2.removeAll();
		jpanel_2.revalidate();
		jpanel_2.add(jPsendNotifi);
		jpanel_2.setVisible(true);

	}

	public void clear(JPanel A) {
		A.removeAll();
		A.revalidate();
	}

	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {// invoice
		JPaddInvoice jPsendNotif = new JPaddInvoice(dataMap);
		clear(jpanel_2);
		jpanel_2.add(jPsendNotif);
		jpanel_2.setVisible(true);
	}

	protected void do_jbtlistproduct_actionPerformed(ActionEvent e) {// Storage
		JPstorage jPstorage = new JPstorage(dataMap);
		clear(jpanel_2);
		jpanel_2.add(jPstorage);
		jpanel_2.setVisible(true);
	}

	protected void do_jbtaccount_actionPerformed(ActionEvent e) {// account
		JPaccount jPaccount=new JPaccount(dataMap);
		clear(jpanel_2);
		jpanel_2.add(jPaccount);
		jpanel_2.setVisible(true);
	}
	protected void btnNewButton_actionPerformed(ActionEvent e) {
		JFrameLogin jFrameLogin = new JFrameLogin();
		jFrameLogin.setVisible(true);
		this.setVisible(false);
	}
}
