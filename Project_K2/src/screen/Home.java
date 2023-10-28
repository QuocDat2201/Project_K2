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
import javax.swing.SwingConstants;
import javax.swing.JMenu;

public class Home extends JFrame {
	private  Map<String,Object> dataMap=new HashMap<String, Object>();
	private JPanel contentPane;
	private JPanel jpanel_2;
	private String title="Maneger"; 
    private static Home frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(254, 199, 222));
		getContentPane().add(panel, BorderLayout.WEST);
		
		JButton jbthome = new JButton("Home");
		jbthome.setHorizontalAlignment(SwingConstants.RIGHT);
		jbthome.setRequestFocusEnabled(false);
		jbthome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		jbthome.setBorderPainted(false);
		jbthome.setContentAreaFilled(false);
		jbthome.setIcon(new ImageIcon(Home.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(jbthome);
		
		JButton jbtsend = new JButton("Send");
		jbtsend.setHorizontalAlignment(SwingConstants.RIGHT);
		jbtsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
//		switch (acti) {
//		case 1: {
//			
//			JButton jbt1 = new JButton("New button");
//			jbt1.setBorderPainted(false);
//			jbt1.setContentAreaFilled(false);
//			jbt1.setIcon(new ImageIcon(Home.class.getResource("/Icon/39040_apply_gtk_icon.png")));
//			jbt1.setBorder(new EmptyBorder(10, 70, 10, 10));
//			panel.add(jbt1);
//			
//			JButton jbt2 = new JButton("n1\r\n");
//			jbt2.setContentAreaFilled(false);
//			jbt2.setBorderPainted(false);
//			jbt2.setIcon(new ImageIcon(Home.class.getResource("/Icon/39040_apply_gtk_icon.png")));
//			jbt2 .setBorder(new EmptyBorder(10, 70, 10, 10));
//			panel.add(jbt2,BorderLayout.LINE_END);
//			break;
//		}case 2:{
//			JButton jbtsen2 = new JButton("New button");
//			jbtsen2.setIcon(new ImageIcon(Home.class.getResource("/Icon/39040_apply_gtk_icon.png")));
//			jbtsen2 .setBorder(new EmptyBorder(10, 70, 10, 10));
//			panel.add(jbtsen2);
//			
//			JButton jbtsen1 = new JButton("New button");
//			jbtsen1.setIcon(new ImageIcon(Home.class.getResource("/Icon/39040_apply_gtk_icon.png")));
//			jbtsen1 .setBorder(new EmptyBorder(10, 70, 10, 10));
//			panel.add(jbtsen1);
//			break;
//		}
//		default:
//		{
//			System.out.println("br");
//		}
		jbtsend.setContentAreaFilled(false);
		jbtsend.setBorderPainted(false);
		jbtsend.setIcon(new ImageIcon(Home.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(jbtsend);
		
		JButton jbtinvoice = new JButton("Invoice");
		jbtinvoice.setHorizontalAlignment(SwingConstants.RIGHT);
		jbtinvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		
		
		jbtinvoice.setBorderPainted(false);
		jbtinvoice.setContentAreaFilled(false);
		jbtinvoice.setIcon(new ImageIcon(Home.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(jbtinvoice);
		
		JButton jbtlistproduct = new JButton("ListProduct");
		jbtlistproduct.setHorizontalAlignment(SwingConstants.RIGHT);
		jbtlistproduct.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));
		jbtlistproduct.setContentAreaFilled(false);
		jbtlistproduct.setBorderPainted(false);
		jbtlistproduct.setIcon(new ImageIcon(Home.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(jbtlistproduct);
		
		JButton jbtInfor = new JButton("Infor");
		jbtInfor.setHorizontalAlignment(SwingConstants.RIGHT);
		jbtInfor.setContentAreaFilled(false);
		jbtInfor.setBorderPainted(false);
		jbtInfor.setIcon(new ImageIcon(Home.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(jbtInfor);
		
		JButton btnNewButton_2_1_2 = new JButton("Infor");
		btnNewButton_2_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_2_1_2.setIcon(new ImageIcon(Home.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		btnNewButton_2_1_2.setContentAreaFilled(false);
		btnNewButton_2_1_2.setBorderPainted(false);
		panel.add(btnNewButton_2_1_2);
		
		JButton btnNewButton_3 = new JButton("Out");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setIcon(new ImageIcon(Home.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 0, 95));
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblNewLabel);
		
		jpanel_2 = new JPanel();
		getContentPane().add(jpanel_2, BorderLayout.CENTER);
		jpanel_2.setLayout(new BorderLayout(0, 0));
	}
	public Home(Object ob) {
		this();
		dataMap=(Map<String, Object>) ob;
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
        JPhome jPhome =new JPhome(dataMap);
        jpanel_2.removeAll();
		jpanel_2.revalidate();
		jpanel_2.add(jPhome);
		jpanel_2.setVisible(true);
		
		
	}
	
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		
		 JPsendNotifi jPsendNotifi=new JPsendNotifi(dataMap);
			
		 jpanel_2.removeAll();
			jpanel_2.revalidate();
			jpanel_2.add(jPsendNotifi);
			jpanel_2.setVisible(true);
			
	}
	
	public void clear(JPanel A ) {
		A.removeAll();
		A.revalidate();
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		JPaddAcount jPsendNotif =new JPaddAcount(dataMap);	
		clear(jpanel_2);
		
			jpanel_2.add(jPsendNotif);
			jpanel_2.setVisible(true);
	}
}
