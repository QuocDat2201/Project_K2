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

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingConstants;

import entites.Role;
import models.Role_model;

import javax.swing.JComboBox;

public class JPaddAcount extends JPanel {
	private  Map<String,Object> dataMap=new HashMap<String, Object>();
	private JPanel panel;
	private JTextField jpass;
	private JTextField jnewPassword;
	private JTextField jConfimNewPassword;
	private JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public JPaddAcount() {
         setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(34, 76, 145, 25);
		panel.add(lblNewLabel);
		
		jpass = new JTextField();
		jpass.setBounds(204, 76, 176, 28);
		panel.add(jpass);
		jpass.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(34, 112, 160, 32);
		panel.add(lblPassword);
		
		jnewPassword = new JPasswordField();
		jnewPassword.setColumns(10);
		jnewPassword.setBounds(204, 122, 176, 25);
		panel.add(jnewPassword);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm Password");
		lblConfirmNewPassword.setBounds(34, 155, 145, 39);
		panel.add(lblConfirmNewPassword);
		
		jConfimNewPassword = new JPasswordField();
		jConfimNewPassword.setColumns(10);
		jConfimNewPassword.setBounds(204, 169, 176, 28);
		panel.add(jConfimNewPassword);
		
		JLabel lblNewLabel_1 = new JLabel("ADD Account");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(80, 23, 269, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Role");
		lblNewLabel_2.setBounds(37, 218, 109, 25);
		panel.add(lblNewLabel_2);
		
		comboBox = new JComboBox();
		comboBox.setBounds(204, 219, 176, 25);
		panel.add(comboBox);
//		panel.setLayout(new BorderLayout(0, 0));

	}
	public JPaddAcount(Object ob) {
		this();
		dataMap=(Map<String, Object>) ob;	
		intiJfame();
	}
	private void intiJfame() {
		DefaultComboBoxModel<Role> model= new DefaultComboBoxModel<Role>();
		Role_model role_model = new Role_model();
		System.out.println("hjh");
		for (Role role : role_model.findAll()) {
			model.addElement(role);
			System.out.println("hjh");
		}
		comboBox.setModel(model);
		comboBox.setRenderer(new rederCombobox());
	}
	class rederCombobox extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Role role=(Role) value;
			return super.getListCellRendererComponent(list, role.getRole_Name(), index, isSelected, cellHasFocus);
		}
		
	}
}
