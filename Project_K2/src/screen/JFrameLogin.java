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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameLogin extends JFrame {
	private static JFrameLogin frame ;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
					frame = new JFrameLogin();
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
	public JFrameLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 327);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 159, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 24));
		lblNewLabel.setForeground(SystemColor.menu);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(177, 24, 121, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome ! Let's get started");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBackground(SystemColor.menu);
		lblNewLabel_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(100, 85, 271, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setIcon(new ImageIcon(JFrameLogin.class.getResource("/Icon/1564534_customer_man_user_account_profile_icon.png")));
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(SystemColor.menu);
		lblNewLabel_2.setBounds(100, 120, 121, 30);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(220, 121, 151, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setIcon(new ImageIcon(JFrameLogin.class.getResource("/Icon/211855_locked_icon.png")));
		lblNewLabel_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2_1.setForeground(SystemColor.menu);
		lblNewLabel_2_1.setBounds(100, 162, 121, 27);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(220, 161, 151, 28);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setIcon(new ImageIcon(JFrameLogin.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setForeground(new Color(149, 0, 67));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnNewButton.setBounds(220, 195, 151, 28);
		contentPane.add(btnNewButton);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {//Login
		Home home =new Home();
		home.setVisible(true);
		frame.setVisible(false);
//		UsersModel usersModel = new UsersModel() ; 
//		for(Users user : usersModel.findAll()) {
//			System.out.println(user.getUsername());
//		}
	}
}
