package screen;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class JPinfor extends JPanel {
	private  Map<String,Object> dataMap=new HashMap<String, Object>();
	/**
	 * Create the panel.
	 */
	public JPinfor() {

	}
	public JPinfor(Object ob) {
		dataMap=(Map<String, Object>) ob;
	}

}
