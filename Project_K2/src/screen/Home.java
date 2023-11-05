package screen;
<<<<<<< HEAD

//commitmoi nhat
=======
//commitmoi nhat 1
>>>>>>> branch 'main' of https://github.com/QuocDat2201/Project_K2.git
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
	static JButton jbcusstomer;
	private JButton jbtaccount_2;

<<<<<<< HEAD
=======
	/**
	 * Launch the application.
	 */
>>>>>>> branch 'main' of https://github.com/QuocDat2201/Project_K2.git
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
					System.out.println("ok");

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
		setBounds(100, 100, 741, 514);
		getContentPane().setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(new Color(254, 199, 222));
		getContentPane().add(panel, BorderLayout.WEST);

		jbthome = new JButton("Home");
		jbthome.setFont(new Font("Segoe Print", Font.BOLD, 15));
		jbthome.setForeground(new Color(0, 0, 0));
		jbthome.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbthome.setHorizontalAlignment(SwingConstants.LEFT);
		jbthome.setMinimumSize(new Dimension(59, 20));
		jbthome.setMaximumSize(new Dimension(190, 50));
		jbthome.setBackground(new Color(0, 255, 0));
		jbthome.setBorder(new LineBorder(new Color(255, 128, 255), 3));
		jbthome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		jbthome.setIcon(new ImageIcon(Home.class.getResource("/Icon/299061_house_icon (1).png")));
		panel.add(jbthome);

		jbtinvoice = new JButton("Invoice");
		jbtinvoice.setFont(new Font("Segoe Print", Font.BOLD, 15));
		jbtinvoice.setForeground(new Color(0, 0, 0));
		jbtinvoice.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbtinvoice.setHorizontalAlignment(SwingConstants.LEFT);
		jbtinvoice.setMinimumSize(new Dimension(59, 20));
		jbtinvoice.setMaximumSize(new Dimension(190, 50));
		jbtinvoice.setBackground(new Color(255, 0, 0));
		jbtinvoice.setBorder(new LineBorder(new Color(255, 128, 255), 3));
		jbtinvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		jbtinvoice.setIcon(new ImageIcon(Home.class.getResource("/Icon/Modify.png")));
		panel.add(jbtinvoice);

		jbtlistproduct = new JButton("Storage");
		jbtlistproduct.setFont(new Font("Segoe Print", Font.BOLD, 15));
		jbtlistproduct.setForeground(new Color(0, 0, 0));
		jbtlistproduct.setHorizontalAlignment(SwingConstants.LEFT);
		jbtlistproduct.setMinimumSize(new Dimension(59, 20));
		jbtlistproduct.setMaximumSize(new Dimension(190, 50));
		jbtlistproduct.setBackground(new Color(0, 255, 0));
		jbtlistproduct.setBorder(new LineBorder(new Color(255, 128, 255), 3));
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
		jbcusstomer.setFont(new Font("Segoe Print", Font.BOLD, 15));
		jbcusstomer.setForeground(new Color(0, 0, 0));
		jbcusstomer.setHorizontalAlignment(SwingConstants.LEFT);
		jbcusstomer.setIcon(
				new ImageIcon(Home.class.getResource("/Icon/403022_business man_male_user_avatar_profile_icon.png")));
		jbcusstomer.setMinimumSize(new Dimension(59, 20));
		jbcusstomer.setMaximumSize(new Dimension(190, 50));
		jbcusstomer.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbcusstomer.setBorder(new LineBorder(new Color(255, 128, 255), 3));
		jbcusstomer.setBackground(new Color(0, 255, 0));
		panel.add(jbcusstomer);

		jbtaccount_2 = new JButton("Account");
		jbtaccount_2.setFont(new Font("Segoe Print", Font.BOLD, 15));
		jbtaccount_2.setForeground(new Color(0, 0, 0));
		jbtaccount_2.setIcon(
				new ImageIcon(Home.class.getResource("/Icon/1298747_instagram_brand_logo_social media_icon.png")));
		jbtaccount_2.setHorizontalAlignment(SwingConstants.LEFT);
		jbtaccount_2.setMinimumSize(new Dimension(59, 20));
		jbtaccount_2.setMaximumSize(new Dimension(190, 50));
		jbtaccount_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbtaccount_2.setBorder(new LineBorder(new Color(255, 128, 255), 3));
		jbtaccount_2.setBackground(new Color(255, 0, 0));
		panel.add(jbtaccount_2);
		jbtlistproduct.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));
		jbtlistproduct.setIcon(
				new ImageIcon(Home.class.getResource("/Icon/4172167_box_object_product_item_merchandise_icon.png")));
		panel.add(jbtlistproduct);

		JButton jbtsend = new JButton("Send");
		jbtsend.setFont(new Font("Segoe Print", Font.BOLD, 15));
		jbtsend.setForeground(new Color(0, 0, 0));
		jbtsend.setMinimumSize(new Dimension(59, 20));
		jbtsend.setMaximumSize(new Dimension(190, 50));
		jbtsend.setBackground(new Color(255, 0, 0));
		jbtsend.setBorder(new LineBorder(new Color(255, 128, 255), 3));
		jbtsend.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbtsend.setHorizontalAlignment(SwingConstants.LEFT);
		jbtsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		jbtsend.setIcon(new ImageIcon(Home.class.getResource("/Icon/Comment.png")));
		panel.add(jbtsend);

		jbtaccount = new JButton("Account");
		jbtaccount.setFont(new Font("Segoe Print", Font.BOLD, 15));
		jbtaccount.setForeground(new Color(0, 0, 0));
		jbtaccount.setHorizontalAlignment(SwingConstants.LEFT);
		jbtaccount.setHorizontalTextPosition(SwingConstants.RIGHT);
		jbtaccount.setMinimumSize(new Dimension(59, 20));
		jbtaccount.setMaximumSize(new Dimension(190, 50));
		jbtaccount.setBackground(new Color(0, 255, 0));
		jbtaccount.setBorder(new LineBorder(new Color(255, 128, 255), 3));
		jbtaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbtaccount_actionPerformed(e);
			}
		});
		jbtaccount.setIcon(new ImageIcon(Home.class.getResource("/Icon/172626_user_male_icon.png")));
		panel.add(jbtaccount);

		btnNewButton = new JButton("Sign out");
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton.setMinimumSize(new Dimension(59, 20));
		btnNewButton.setMaximumSize(new Dimension(190, 50));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBorder(new LineBorder(new Color(255, 128, 255), 3));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/Icon/Back.png")));
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 0, 95));
		getContentPane().add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel_1.add(lblNewLabel);

		jpanel_2 = new JPanel();
		jpanel_2.setBackground(new Color(192, 192, 192));
		getContentPane().add(jpanel_2, BorderLayout.CENTER);
		jpanel_2.setLayout(new BorderLayout(0, 0));

	}

	public Home(Map<String, Object> ob) {
		this();
		this.dataMap = ob;
		initJFrame();
	}

	private void initJFrame() {
		ClearScreen();
		Home home = new Home();
		jpanel_2.add(home);
		home.setVisible(true);
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {// Home
		ClearScreen();
		JPhome jPhome = new JPhome(dataMap);
		jpanel_2.add(jPhome);
		jPhome.setVisible(true);

	}

	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {// send
<<<<<<< HEAD
		ClearScreen();
=======
>>>>>>> branch 'main' of https://github.com/QuocDat2201/Project_K2.git
		JPsendNotifi jPsendNotifi = new JPsendNotifi(dataMap);
<<<<<<< HEAD
=======
		jpanel_2.removeAll();
		jpanel_2.revalidate();
>>>>>>> branch 'main' of https://github.com/QuocDat2201/Project_K2.git
		jpanel_2.add(jPsendNotifi);
		jPsendNotifi.setVisible(true);

	}

	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {// invoice
		ClearScreen();
		JPaddInvoice jPsendNotif = new JPaddInvoice(dataMap);
		jpanel_2.add(jPsendNotif);
		jPsendNotif.setVisible(true);
	}

	protected void do_jbtlistproduct_actionPerformed(ActionEvent e) {// Storage
		ClearScreen();
		JPstorage jPstorage = new JPstorage(dataMap);
		jpanel_2.add(jPstorage);
		jPstorage.setVisible(true);
	}

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
<<<<<<< HEAD

	private void ClearScreen() {
		jpanel_2.removeAll();
		jpanel_2.revalidate();
		jpanel_2.repaint();
=======
	protected void do_jbcusstomer_actionPerformed(ActionEvent e) {
		JPcustomer jcustomer=new JPcustomer();
		jpanel_2.removeAll();
		jpanel_2.revalidate();
		jpanel_2.add(jcustomer);
		jpanel_2.setVisible(true);

>>>>>>> branch 'main' of https://github.com/QuocDat2201/Project_K2.git
	}
}
