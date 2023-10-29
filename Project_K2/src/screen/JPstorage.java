package screen;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class JPstorage extends JPanel {
	private  Map<String,Object> dataMap=new HashMap<String, Object>();
	/**
	 * Create the panel.
	 */
	public JPstorage() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

	}
	public JPstorage(Object ob) {
     this();
     dataMap=(Map<String, Object>) ob;
     //hello
	}

}
