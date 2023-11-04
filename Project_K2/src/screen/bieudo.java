package screen;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
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
		double[] v = { 1, 2, 3, 1, 2, 3 };
		SwingChartExample swingChartExample = new SwingChartExample(300, 200, v);
		jpanel_1.add(swingChartExample);
	}

}
