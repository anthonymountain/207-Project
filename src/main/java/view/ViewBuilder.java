package view;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import view.components.RoundedButton;

/**
 * A base ViewBuilder for constructing views.
 */
public class ViewBuilder extends JPanel {

    private static final String FONT = "Futura";
    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final Color SPOTIFY_GREEN = new Color(30, 215, 96);
    public static final Color BUTTON_TEXT_COLOR = Color.WHITE;

    public static final Font LABEL_FONT = new Font(FONT, Font.PLAIN, 14);
    public static final Font BUTTON_FONT = new Font(FONT, Font.PLAIN, 16);
    private static final int MAGIC_NUMBER = 10;

    private String viewName;
    private final Map<String, JButton> buttonsMap;
    private final Map<String, JLabel> labelMap;
    private final JPanel headerPanel;
    private final JPanel buttonsPanel;
    private final JPanel mainPanel;
    private Dimension preferredSize;

    public ViewBuilder() {
        this.buttonsMap = new HashMap<>();
        this.labelMap = new HashMap<>();
        this.setLayout(new BorderLayout());
        this.setBackground(DARK_BACKGROUND);

        headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(DARK_BACKGROUND);
        this.add(headerPanel, BorderLayout.NORTH);

        // Main content area
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(DARK_BACKGROUND);
        this.add(mainPanel, BorderLayout.CENTER);

        // Buttons panel
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        // Vertical alignment
        buttonsPanel.setBackground(DARK_BACKGROUND);
        this.add(buttonsPanel, BorderLayout.CENTER);
        // Center the buttons in the panel
    }

    /**
     * Sets the preferred size of the view.
     * @param width the width of the view.
     * @param height the height of the view.
     * @return this builder
     */
    public ViewBuilder setPreferredSize(int width, int height) {
        this.preferredSize = new Dimension(width, height);
        return this;
    }

    /**
     * Adds a label to the header area (e.g., for the artist's name).
     * @param labelText the text for the label.
     * @return this builder
     */
    public ViewBuilder addHeaderLabel(String labelText) {
        final JLabel label = new JLabel(labelText);
        label.setFont(LABEL_FONT.deriveFont(Font.BOLD, 18));
        label.setForeground(BUTTON_TEXT_COLOR);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelMap.put(labelText, label);

        headerPanel.add(Box.createRigidArea(new Dimension(0, MAGIC_NUMBER)));
        headerPanel.add(label);
        return this;
    }

    /**
     * Adds a label.
     * @param labelText the text for the label.
     * @return this builder
     */
    public ViewBuilder addLabel(String labelText) {
        final JLabel label = new JLabel(labelText);
        label.setFont(LABEL_FONT);
        label.setForeground(BUTTON_TEXT_COLOR);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelMap.put(labelText, label);

        mainPanel.add(label);
        mainPanel.add(Box.createRigidArea(new Dimension(0, MAGIC_NUMBER)));
        return this;
    }

    /**
     * Adds a button.
     * @param buttonKey the key for the button in the button map.
     * @param buttonText the text for the button.
     * @return this builder
     */
    public ViewBuilder addButton(String buttonKey, String buttonText) {
        final JButton button = new RoundedButton(buttonText);
        button.setFont(BUTTON_FONT);
        button.setForeground(BUTTON_TEXT_COLOR);
        button.setBackground(SPOTIFY_GREEN);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonsMap.put(buttonKey, button);

        buttonsPanel.add(Box.createRigidArea(new Dimension(0, MAGIC_NUMBER)));
        buttonsPanel.add(button);
        return this;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    /**
     * Returns the button.
     * @param buttonKey the key for the button in the button map.
     * @return the button.
     */
    public JButton getButton(String buttonKey) {
        return buttonsMap.get(buttonKey);
    }

    /**
     * Returns the label.
     * @param name the name of the label to retrieve.
     * @return the label.
     */
    public JLabel getLabel(String name) {
        return labelMap.get(name);
    }

    /**
     * Builds the view.
     * @return the view.
     */
    public JPanel build() {
        if (this.preferredSize != null) {
            this.setPreferredSize(this.preferredSize);
        }

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(mainPanel);
        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        return this;
    }
}
