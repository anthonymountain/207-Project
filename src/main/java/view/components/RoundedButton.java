package view.components;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * A custom button with rounded corners and hover effects.
 */
public class RoundedButton extends JButton {
    private boolean hovered = false;
    private final int arcSize = 30;

    public RoundedButton(String text) {
        super(text);
        setFont(new Font("Futura", Font.PLAIN, 16));
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setBackground(new Color(30, 215, 96));
        setContentAreaFilled(false);
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hovered = true;
                setBackground(getBackground().darker());
                repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hovered = false;
                setBackground(new Color(30, 215, 96));
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final int inset = hovered ? 2 : 0;
        final int x = inset;
        final int y = inset;
        final int width = getWidth() - 2 * inset;
        final int height = getHeight() - 2 * inset;

        g2.setColor(getBackground());
        g2.fillRoundRect(x, y, width, height, arcSize, arcSize);

        g2.setColor(getForeground());
        g2.setFont(getFont());
        final FontMetrics fm = g2.getFontMetrics();
        final int textX = (getWidth() - fm.stringWidth(getText())) / 2;
        final int textY = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
        g2.drawString(getText(), textX, textY);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        final Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground().darker());
        g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, arcSize, arcSize);
        g2.dispose();
    }
}
