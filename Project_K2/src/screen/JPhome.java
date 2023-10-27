package screen;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class JPhome extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPhome() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setBounds(189, 93, 198, 75);
		panel.add(lblNewLabel);

	}

}
