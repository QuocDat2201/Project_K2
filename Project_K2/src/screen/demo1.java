/**
 * 
 */
package screen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;

/**
 * 
 */
public class demo1 extends JFrame{
	private JPanel contentPane;
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo1 frame = new demo1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public demo1() {
		setTitle("Login");
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(254, 199, 222));
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon(demo1.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setIcon(new ImageIcon(demo1.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setIcon(new ImageIcon(demo1.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setIcon(new ImageIcon(demo1.class.getResource("/Icon/4172167_box_object_product_item_merchandise_icon.png")));
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setIcon(new ImageIcon(demo1.class.getResource("/Icon/4043232_avatar_batman_comics_hero_icon.png")));
		panel.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setIcon(new ImageIcon(demo1.class.getResource("/Icon/9035932_server_sharp_icon.png")));
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(null);
	}
}
