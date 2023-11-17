package scHome;

import javax.swing.JPanel;

import entites.Category;
import entites.Products;
import models.Category_model;
import models.Invoice_model;
import screen.JFrameLogin;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;

import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;

import com.toedter.calendar.JMonthChooser;
import javax.swing.event.AncestorListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPChartRevenue extends JPanel {
	private JPanel jpanel_1;
	private JMonthChooser jmonthChooser;

	/**
	 * Create the panel.
	 */
	public JPChartRevenue() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		
		jmonthChooser = new JMonthChooser();
		jmonthChooser.getComboBox().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
				do_jmonthChooserComboBox_componentMoved(e);
			}
		});
	
		jmonthChooser.getComboBox().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_jmonthChooserComboBox_propertyChange(evt);
			}
		});
	
		
		panel_2.add(jmonthChooser);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(JPChartRevenue.class.getResource("/Icon/Search.png")));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 5));
		panel_2.add(btnNewButton);

		jpanel_1 = new JPanel();
		panel.add(jpanel_1, BorderLayout.CENTER);
		jpanel_1. setLayout(new BorderLayout());;
		fill(1);
		
	}
	private void fill(int month) {
		try {
			System.out.println("avc");
		    Category_model category_model = new Category_model();
		    Invoice_model invoice_model = new Invoice_model();
		    List<Date> DATE = (List<Date>) invoice_model.findRevenueMap(month).get("dates");
		    List<Double> totals = (List<Double>) invoice_model.findRevenueMap(month).get("values");

		    String[] Date = new String[30];
		    double[] valuesArray = new double[30];
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		    for (int i = 0; i <30; i++) {
		    	Date[i]=paramString().valueOf(i+1) ;
		    	valuesArray[i]=0;
		    	for (int j = 0; j < DATE.size(); j++) {
		    		if (i+1 == Integer.valueOf(dateFormat.format(DATE.get(j)))) {
						valuesArray[i]=totals.get(j);
					} else {

					}
				}

				}
		    	


		    String namechart = "Biểu đồ doanh trong tháng "+(month);
		    int x = JFrameLogin.frameWidth - 140;
		    int y = JFrameLogin.frameHeight - 400;
		    a sA = new a(namechart, Date, x, y, valuesArray);
		    jpanel_1.removeAll();
		    jpanel_1.revalidate();
		    jpanel_1.add(sA);
		    jpanel_1.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void do_jmonthChooserComboBox_propertyChange(PropertyChangeEvent evt) {
		int month=	Integer.valueOf(jmonthChooser.getMonth()+1);
		fill(month);
	}

	protected void do_jmonthChooserComboBox_componentMoved(ComponentEvent e) {
		int month=	Integer.valueOf(jmonthChooser.getMonth()+1);
		fill(month);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		int month=	Integer.valueOf(jmonthChooser.getMonth()+1);
		fill(month);
	}
	}

