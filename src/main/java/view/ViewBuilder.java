package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;

/**
 * A base ViewBuilder for constructing views.
 */
public class ViewBuilder extends JPanel {

    private String viewName;
    private final Map<String, JButton> buttonsMap;
    private final JPanel buttonsPanel;
    private final JPanel mainPanel;
    private final Controller controller;

    public ViewBuilder() {
        this.buttonsMap = new HashMap<>();
        this.setLayout(new BorderLayout());

        // Main content area
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.add(mainPanel, BorderLayout.CENTER);

        // Buttons panel
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    /**
     * Adds a label.
     * @param labelText the text for the label.
     * @return this builder
     */
    public ViewBuilder addLabel(String labelText) {
        final JLabel label = new JLabel(labelText);
        mainPanel.add(label);
        return this;
    }

    /**
     * Adds a button.
     * @param buttonKey the key for the button in the button map.
     * @param buttonText the text for the button.
     * @return this builder
     */
    public ViewBuilder addButton(String buttonKey, String buttonText) {
        final JButton button = new JButton(buttonText);
        buttonsMap.put(buttonKey, button);
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
     * Returns the button.
     * @param buttonKey the key for the button in the button map.
     * @return the button.
     */
    public void setController(Controller controller) {
        return buttonsMap.get();
    }

    /**
     * Builds the view.
     * @return the view.
     */
    public JPanel build() {
        this.add(mainPanel);
        this.add(buttonsPanel);
        return this;
    }
}
