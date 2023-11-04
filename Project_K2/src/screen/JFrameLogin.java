package screen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import entites.Users;
import models.UsersModel;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import javax.swing.JComboBox;
public class JFrameLogin extends JFrame {
	private JPanel contentPane;
	private JTextField juser;
	private static Map<String, Object> dataMap = new HashMap<String, Object>();
	private JPasswordField jpass;
	static  int frameWidth ;
	static int frameHeight ;
	static Home home = new Home(dataMap);
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
					JFrameLogin frame = new JFrameLogin();
					frame.setVisible(true);
					home.addComponentListener(new ComponentAdapter() {
			            @Override
			            public void componentResized(ComponentEvent e) {			            	
			            	frameWidth = home.getWidth();
			           	    frameHeight = home.getHeight();
			           	    System.out.println(frameHeight+frameWidth);
			            }
			        });
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 347);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 159, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 24));
		lblNewLabel.setForeground(SystemColor.menu);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(425, 23, 121, 49);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Welcome ! Let's get started");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBackground(SystemColor.menu);
		lblNewLabel_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(348, 84, 271, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setIcon(new ImageIcon(
				JFrameLogin.class.getResource("/Icon/1564534_customer_man_user_account_profile_icon.png")));
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(SystemColor.menu);
		lblNewLabel_2.setBounds(348, 119, 121, 30);
		contentPane.add(lblNewLabel_2);
		juser=new JTextField();
		juser.setToolTipText("");
		juser.setBounds(468, 120, 151, 28);
		contentPane.add(juser);
		juser.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setIcon(new ImageIcon(JFrameLogin.class.getResource("/Icon/211855_locked_icon.png")));
		lblNewLabel_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2_1.setForeground(SystemColor.menu);
		lblNewLabel_2_1.setBounds(348, 161, 121, 27);
		contentPane.add(lblNewLabel_2_1);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setIcon(
				new ImageIcon(JFrameLogin.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setForeground(new Color(149, 0, 67));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnNewButton.setBounds(468, 194, 151, 28);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(0, 0, 324, 308);
		ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("/Icon/th.jpg")).getImage()
				.getScaledInstance(324, 308, Image.SCALE_SMOOTH)); // Thay thế bằng đường dẫn thực tế của hình ảnh

		// Đặt hình ảnh cho JLabel
		lblNewLabel_3.setIcon(icon);
		contentPane.add(lblNewLabel_3);

		jpass = new JPasswordField();
		jpass.setBounds(468, 160, 151, 28);
		contentPane.add(jpass);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(528, 195, 36, 26);
		contentPane.add(comboBox);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {// Login
		
		String username = juser.getText().trim();
		String password = new String(jpass.getPassword());
	
		UsersModel usersModel = new UsersModel();
		Users users = usersModel.login(username, password);
		System.out.println("addd");
		if (users == null) {
			JOptionPane.showMessageDialog(null, "Account Invalid");
		} else {
			dataMap.put("user", users);// dong luu du lieu thong tin ac dang nhap 			
			home.setVisible(true);
			this.setVisible(false);
		}
	}
}
