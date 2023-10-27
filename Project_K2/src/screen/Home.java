package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class Home extends JFrame {
	private  Map<String,Object> dataMap=new HashMap<String, Object>();
	private JPanel contentPane;
	private JPanel jpanel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
		setTitle("Login");
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(254, 199, 222));
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Send");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(demo1.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Invoice");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setIcon(new ImageIcon(demo1.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("ListProduct");
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setIcon(new ImageIcon(demo1.class.getResource("/Icon/4172167_box_object_product_item_merchandise_icon.png")));
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Infor");
		btnNewButton_2_1.setContentAreaFilled(false);
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setIcon(new ImageIcon(demo1.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Out");
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setIcon(new ImageIcon(Home.class.getResource("/Icon/Exit.png")));
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 0, 95));
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("HOME");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblNewLabel);
		
		jpanel_2 = new JPanel();
		getContentPane().add(jpanel_2, BorderLayout.CENTER);
		jpanel_2.setLayout(null);
	}
	public Home(Object ob) {
		this();
		dataMap=(Map<String, Object>) ob;
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
        JPhome jPhome=new JPhome(dataMap);
		
		clear(jpanel_2);
		getContentPane().add(jPhome, BorderLayout.CENTER);
		
		
	}
	
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		 JPsendNotifi jPsendNotifi=new JPsendNotifi();
			
			clear(jpanel_2);
			getContentPane().add(jPsendNotifi, BorderLayout.CENTER);
	}
	
	
	
	
	
	public void clear(JPanel A ) {
		A.removeAll();
		A.revalidate();
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		JPaddAcount jPsendNotif =new JPaddAcount();	
		clear(jpanel_2);
		getContentPane().add(jPsendNotif, BorderLayout.CENTER);
	}
	
}
