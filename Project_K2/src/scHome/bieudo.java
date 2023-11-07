package scHome;

import javax.swing.JPanel;

import screen.JFrameLogin;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;

import java.awt.FlowLayout;
import javax.swing.JLabel;

public class bieudo extends JPanel {
	private JPanel jpanel_1;

	/**
	 * Create the panel.
	 */
	public bieudo() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Bieu do");
		panel_2.add(lblNewLabel);

		jpanel_1 = new JPanel();
		panel.add(jpanel_1, BorderLayout.CENTER);
		initJframe();
		
	}

	private void initJframe() {
		int w=JFrameLogin.frameWidth-160;
		int h=JFrameLogin.frameHeight-280;
		double[] b = { 1, 2, 3, 1, 2, 3 };
		fill(w, h, b);
	}
	private void fill(int w, int h,double[]v) {
		
		SwingChartExample swingChartExample = new SwingChartExample(w,h, v);
		jpanel_1.add(swingChartExample);
	}
	
}
