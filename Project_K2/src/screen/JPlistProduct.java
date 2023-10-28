package screen;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class JPlistProduct extends JPanel {
	private  Map<String,Object> dataMap=new HashMap<String, Object>();
	/**
	 * Create the panel.
	 */
	public JPlistProduct() {

	}
	public JPlistProduct(Object ob) {
     this();
     dataMap=(Map<String, Object>) ob;
	}

}
