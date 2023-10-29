package screen;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingConstants;

import org.mindrot.jbcrypt.BCrypt;

import entites.Role;
import entites.Users;
import models.Role_model;
import models.UsersModel;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPaddAcount extends JPanel {
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private JPanel panel;
	private JTextField jusername;
	private JComboBox jcomboBox;
	private JPasswordField Jpassword;
	private JPasswordField JConfirm_passwordField;

	/**
	 * Create the panel.
	 */
	public JPaddAcount() {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(123, 76, 162, 25);
		panel.add(lblNewLabel);

		jusername = new JTextField();
		jusername.setBounds(295, 75, 176, 28);
		panel.add(jusername);
		jusername.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(123, 111, 160, 25);
		panel.add(lblPassword);

		JLabel lblConfirmNewPassword = new JLabel("Confirm Password");
		lblConfirmNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmNewPassword.setBounds(123, 149, 162, 25);
		panel.add(lblConfirmNewPassword);

		JLabel lblNewLabel_1 = new JLabel("Register");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 21, 564, 32);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Role");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(123, 181, 162, 25);
		panel.add(lblNewLabel_2);

		jcomboBox = new JComboBox();
		jcomboBox.setBounds(295, 181, 176, 28);
		panel.add(jcomboBox);

		JButton Jbutton_register = new JButton("Register");
		Jbutton_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jbutton_register_actionPerformed(e);
			}
		});
		Jbutton_register.setBounds(243, 229, 85, 21);
		panel.add(Jbutton_register);

		Jpassword = new JPasswordField();
		Jpassword.setBounds(295, 110, 176, 28);
		panel.add(Jpassword);

		JConfirm_passwordField = new JPasswordField();
		JConfirm_passwordField.setBounds(295, 148, 176, 28);
		panel.add(JConfirm_passwordField);
//		panel.setLayout(new BorderLayout(0, 0));

	}

	public JPaddAcount(Object ob) {
		this();
		this.dataMap = (Map<String, Object>) ob;
		intiJfame();
	}

	private void intiJfame() {
		DefaultComboBoxModel<Role> model = new DefaultComboBoxModel<Role>();
		Role_model role_model = new Role_model();

		for (Role role : role_model.findAll()) {
			model.addElement(role);
		}
		jcomboBox.setModel(model);
		jcomboBox.setRenderer(new rederCombobox());
	}

	class rederCombobox extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Role role = (Role) value;
			return super.getListCellRendererComponent(list, role.getRole_Name(), index, isSelected, cellHasFocus);
		}

	}

	protected void Jbutton_register_actionPerformed(ActionEvent e) {
		Users users = new Users();
		UsersModel usersModel = new UsersModel();

		users.setUsername(jusername.getText().trim());
		String password = new String(Jpassword.getPassword());
		String confirm = new String(JConfirm_passwordField.getPassword());
		Role role = (Role) jcomboBox.getSelectedItem();
		users.setRoleID(role.getRole_id());
		
		for (Users users2 : usersModel.findAll()) {
			if (users2.getUsername().equalsIgnoreCase(jusername.getText().trim())) {
				JOptionPane.showMessageDialog(null, "Username already exists !");
			} else {
				if (password.equals(confirm)) {
					users.setPassword(BCrypt.hashpw(confirm, BCrypt.gensalt()));
					if (usersModel.register(users)) {
						JOptionPane.showMessageDialog(null, "Register Success !");
					} else {
						JOptionPane.showMessageDialog(null, "Register Fail !");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Password do not match");
				}
			}
		}
	}
}
