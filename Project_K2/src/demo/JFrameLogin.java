package demo;

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
					JFrameLogin frame = new JFrameLogin();
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
	//tuan cho dien
	public JFrameLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 327);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
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
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(SystemColor.menu);
		lblNewLabel_2.setBounds(100, 127, 121, 16);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(220, 121, 151, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2_1.setForeground(SystemColor.menu);
		lblNewLabel_2_1.setBounds(100, 167, 121, 16);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(220, 161, 151, 28);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnNewButton.setBounds(220, 201, 151, 28);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Don't have an account ?");
		lblNewLabel_3.setFont(new Font("Rockwell", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(SystemColor.menu);
		lblNewLabel_3.setBounds(85, 243, 167, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setForeground(SystemColor.menu);
		btnNewButton_1.setBounds(264, 237, 107, 28);
		contentPane.add(btnNewButton_1);
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		UsersModel usersModel = new UsersModel() ; 
		for(Users user : usersModel.findAll()) {
			System.out.println(user.getUsername());
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		UsersModel usersModel = new UsersModel() ; 
		for(Users user : usersModel.findAll()) {
			System.out.println(user.getUsername());
		}
	}
}
