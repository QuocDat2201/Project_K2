package screen;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPasswordField;

public class PlacehoclderPassField extends JPasswordField {
    private String placeholder;

    public PlacehoclderPassField(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (new String(getPassword()).isEmpty()) {
            g.setColor(Color.GRAY);
            g.drawString(placeholder, getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
        }
    }
}

