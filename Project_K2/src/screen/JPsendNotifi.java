package screen;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

public class JPsendNotifi extends JPanel {
	private  Map<String,Object> dataMap=new HashMap<String, Object>();
	/**
	 * Create the panel.
	 */
	public JPsendNotifi() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Send");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(180, 95, 130, 95);
		panel.add(lblNewLabel);

	}

}
