package screen;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTextField;//a
//ad
public class PlacehoclderTextField extends JTextField {
    private String placeholder;//a

    public PlacehoclderTextField(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getText().isEmpty()) {
            g.setColor(Color.GRAY);
            g.drawString(placeholder, getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
        }
    }
}
