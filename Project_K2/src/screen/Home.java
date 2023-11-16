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
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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

import entites.Role;
import entites.Users;
import models.Role_model;
import scAcount.JPaccount;
import scCustomer.JPmenuSuppliers;
import scCustomer.JPmenucustomer;
import scCustomer.JPsuppliers;
import scHome.JPhome;
import scInvoice.JPaddInvoice;
import scNotifi.JPsendNotifi;
import scStorage.JPstorage;
import java.awt.Point;
import java.awt.ComponentOrientation;

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
	Font defaultFont = new Font("Arial", Font.PLAIN, 14);
	public static JButton jbcusstomer;
	private JButton jbtaccount_2;
	private JLabel jnamuser;
	private JLabel jrole;

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
	// commet

	/**
	 * Create the frame.
	 */
	public Home() {
		setTitle("Manager");
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 514);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 45, 107, 430);
		panel.setBackground(new Color(0, 255, 255));
		getContentPane().add(panel);

		jbthome = new JButton("Home");
		jbthome.setFont(new Font("Arial", Font.BOLD, 15));
		jbthome.setForeground(new Color(255, 255, 255));
		jbthome.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbthome.setHorizontalAlignment(SwingConstants.LEFT);
		jbthome.setMinimumSize(new Dimension(59, 20));
		jbthome.setMaximumSize(new Dimension(190, 50));
		jbthome.setBackground(new Color(0, 128, 255));
		jbthome.setBorder(new LineBorder(new Color(0, 255, 255)));
		jbthome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		jbthome.setIcon(new ImageIcon(Home.class.getResource("/Icon/299061_house_icon (1).png")));
		panel.add(jbthome);

		jbtinvoice = new JButton("Invoice");
		jbtinvoice.setFont(new Font("Arial", Font.BOLD, 15));
		jbtinvoice.setForeground(new Color(255, 255, 255));
		jbtinvoice.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbtinvoice.setHorizontalAlignment(SwingConstants.LEFT);
		jbtinvoice.setMinimumSize(new Dimension(59, 20));
		jbtinvoice.setMaximumSize(new Dimension(190, 50));
		jbtinvoice.setBackground(new Color(0, 128, 255));
		jbtinvoice.setBorder(new LineBorder(new Color(0, 255, 255)));
		jbtinvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		jbtinvoice.setIcon(new ImageIcon(Home.class.getResource("/Icon/Modify.png")));
		panel.add(jbtinvoice);

		jbtlistproduct = new JButton("Storage");
		jbtlistproduct.setFont(new Font("Arial", Font.BOLD, 15));
		jbtlistproduct.setForeground(new Color(255, 255, 255));
		jbtlistproduct.setHorizontalAlignment(SwingConstants.LEFT);
		jbtlistproduct.setMinimumSize(new Dimension(59, 20));
		jbtlistproduct.setMaximumSize(new Dimension(190, 50));
		jbtlistproduct.setBackground(new Color(0, 128, 255));
		jbtlistproduct.setBorder(new LineBorder(new Color(0, 255, 255)));
		jbtlistproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbtlistproduct_actionPerformed(e);
			}
		});

		jbcusstomer = new JButton("Cusstomer");
		jbcusstomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbcusstomer_actionPerformed(e);
			}
		});
		jbcusstomer.setFont(new Font("Arial", Font.BOLD, 15));
		jbcusstomer.setForeground(new Color(255, 255, 255));
		jbcusstomer.setHorizontalAlignment(SwingConstants.LEFT);
		jbcusstomer.setIcon(
				new ImageIcon(Home.class.getResource("/Icon/403022_business man_male_user_avatar_profile_icon.png")));
		jbcusstomer.setMinimumSize(new Dimension(59, 20));
		jbcusstomer.setMaximumSize(new Dimension(190, 50));
		jbcusstomer.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbcusstomer.setBorder(new LineBorder(new Color(0, 255, 255)));
		jbcusstomer.setBackground(new Color(0, 128, 255));
		panel.add(jbcusstomer);

		jbtaccount_2 = new JButton("Supplier");
		jbtaccount_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbtaccount_2_actionPerformed(e);
			}
		});
		jbtaccount_2.setFont(new Font("Arial", Font.BOLD, 15));
		jbtaccount_2.setForeground(new Color(255, 255, 255));
		jbtaccount_2.setIcon(
				new ImageIcon(Home.class.getResource("/Icon/Profile.png")));
		jbtaccount_2.setHorizontalAlignment(SwingConstants.LEFT);
		jbtaccount_2.setMinimumSize(new Dimension(59, 20));
		jbtaccount_2.setMaximumSize(new Dimension(190, 50));
		jbtaccount_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbtaccount_2.setBorder(new LineBorder(new Color(0, 255, 255)));
		jbtaccount_2.setBackground(new Color(0, 128, 255));
		panel.add(jbtaccount_2);
		jbtlistproduct.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));
		jbtlistproduct.setIcon(
				new ImageIcon(Home.class.getResource("/Icon/warehouse.png")));
		panel.add(jbtlistproduct);

		JButton jbtreport = new JButton("Reports");
		jbtreport.setFont(new Font("Arial", Font.BOLD, 15));
		jbtreport.setForeground(new Color(255, 255, 255));
		jbtreport.setMinimumSize(new Dimension(59, 20));
		jbtreport.setMaximumSize(new Dimension(190, 50));
		jbtreport.setBackground(new Color(0, 128, 255));
		jbtreport.setBorder(new LineBorder(new Color(0, 255, 255)));
		jbtreport.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbtreport.setHorizontalAlignment(SwingConstants.LEFT);
		jbtreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		jbtreport.setIcon(new ImageIcon(Home.class.getResource("/Icon/report.png")));
		panel.add(jbtreport);

		jbtaccount = new JButton("Account");
		jbtaccount.setFont(new Font("Arial", Font.BOLD, 15));
		jbtaccount.setForeground(new Color(255, 255, 255));
		jbtaccount.setHorizontalAlignment(SwingConstants.LEFT);
		jbtaccount.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbtaccount.setMinimumSize(new Dimension(59, 20));
		jbtaccount.setMaximumSize(new Dimension(190, 50));
		jbtaccount.setBackground(new Color(0, 128, 255));
		jbtaccount.setBorder(new LineBorder(new Color(0, 255, 255)));
		jbtaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbtaccount_actionPerformed(e);
			}
		});
		jbtaccount.setIcon(new ImageIcon(Home.class.getResource("/Icon/user.png")));
		panel.add(jbtaccount);

		btnNewButton = new JButton("Sign out");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton.setMinimumSize(new Dimension(59, 20));
		btnNewButton.setMaximumSize(new Dimension(190, 50));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setBorder(new LineBorder(new Color(0, 255, 255)));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/Icon/Back.png")));
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(107, 0, 657, 47);
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(0, 128, 255));
		getContentPane().add(panel_1);
				panel_1.setLayout(null);
				
				JLabel lblNewLabel_2 = new JLabel("Hello");
				lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
				lblNewLabel_2.setBounds(6, 6, 55, 16);
				panel_1.add(lblNewLabel_2);
				
				jnamuser = new JLabel("jnameuser");
				jnamuser.setFont(new Font("Arial", Font.BOLD, 13));
				jnamuser.setBounds(61, 6, 123, 16);
				panel_1.add(jnamuser);
				
				JLabel lblNewLabel_2_1 = new JLabel("Role");
				lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 13));
				lblNewLabel_2_1.setBounds(6, 25, 55, 16);
				panel_1.add(lblNewLabel_2_1);
				
				jrole = new JLabel("jrole\r\n");
				jrole.setFont(new Font("Arial", Font.BOLD, 13));
				jrole.setBounds(61, 25, 123, 16);
				panel_1.add(jrole);

		jpanel_2 = new JPanel();
		jpanel_2.setBounds(107, 45, 657, 430);
		jpanel_2.setBackground(new Color(192, 192, 192));
		getContentPane().add(jpanel_2);
		jpanel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 64, 128));
		panel_2.setBounds(0, 0, 107, 47);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/Icon/boxes.png")));
		lblNewLabel_1.setBounds(33, 6, 46, 35);
		panel_2.add(lblNewLabel_1);
		
		jpanel_2.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {
				Dimension newSize = jpanel_2.getSize();
				JPstorage jPstorage = new JPstorage();
				jPstorage.setSize(newSize);
				jPstorage.setPreferredSize(newSize);
				jPstorage.revalidate();
			}
			
		});

	}

	public Home(Map<String, Object> ob) {
		this();
		this.dataMap = ob;
		initJFrame();
	}

	private void initJFrame() {
		ClearScreen();
		Users user=(Users) dataMap.get("user");
		jnamuser.setText(user.getUsername());
		Role_model role_model=new Role_model();
		for (Role role : role_model.findAll()) {
			if (user.getRoleID()==role.getRole_id()) {
				jrole.setText(role.getRole_Name());
				break;
			} else {

			}
		}
		
		JPhome jPhome = new JPhome(dataMap);
		jpanel_2.add(jPhome);
		jPhome.setVisible(true);
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {// Home
		ClearScreen();
		JPhome jPhome = new JPhome(dataMap);
		jpanel_2.add(jPhome);
		jPhome.setVisible(true);

	}

	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {// send
		ClearScreen();
		JPsendNotifi jPsendNotifi = new JPsendNotifi(dataMap);
		jpanel_2.add(jPsendNotifi);
		jPsendNotifi.setVisible(true);
		

	}

	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {// invoice
		ClearScreen();
		JPaddInvoice jPaddInvoice = new JPaddInvoice();
		jpanel_2.add(jPaddInvoice);
		jPaddInvoice.setVisible(true);
	}

	protected void do_jbtlistproduct_actionPerformed(ActionEvent e) {// Storage
		ClearScreen();
		JPstorage jPstorage = new JPstorage(dataMap);
		jpanel_2.add(jPstorage);
		jPstorage.setVisible(true);
		
		jPstorage.setSize(jpanel_2.getSize());
	    jPstorage.setPreferredSize(jpanel_2.getPreferredSize());
	    jPstorage.revalidate();
	}
//huydz
	protected void do_jbtaccount_actionPerformed(ActionEvent e) {// account
		ClearScreen();
		JPaccount jPaccount = new JPaccount(dataMap);
		jpanel_2.add(jPaccount);
		jPaccount.setVisible(true);
	}

	protected void btnNewButton_actionPerformed(ActionEvent e) {
		JFrameLogin jFrameLogin = new JFrameLogin();
		jFrameLogin.setVisible(true);
		this.setVisible(false);
	}

	private void ClearScreen() {
		jpanel_2.removeAll();
		jpanel_2.revalidate();
//		jpanel_2.repaint();
	}
	protected void do_jbcusstomer_actionPerformed(ActionEvent e) {
		JPmenucustomer jcustomer=new JPmenucustomer();
		ClearScreen();
		jpanel_2.add(jcustomer);
		jcustomer.setVisible(true);

	}
	
	protected void do_jbtaccount_2_actionPerformed(ActionEvent e) {
		JPmenuSuppliers jPmenuSuppliers = new JPmenuSuppliers() ; 
		ClearScreen();
		jpanel_2.add(jPmenuSuppliers);
		jPmenuSuppliers.setVisible(true);
		
	}
}
