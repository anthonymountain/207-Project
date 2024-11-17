package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * A base ViewBuilder for constructing views.
 */
public class ViewBuilder extends JPanel {

    private final String viewName;
    private final List<JComponent> components;
    private final JPanel buttonsPanel;
    private final JPanel mainPanel;

    public ViewBuilder(String viewName) {
        this.viewName = viewName;
        this.components = new ArrayList<>();
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
        components.add(label);
        mainPanel.add(label);
        return this;
    }

    /**
     * Adds a button.
     * @param buttonText the text for the button.
     * @return this builder
     */
    public ViewBuilder addButton(String buttonText) {
        final JButton button = new JButton(buttonText);
        components.add(button);
        buttonsPanel.add(button);
        return this;
    }

    /**
     * Adds a component.
     * @param component the component to be added.
     * @return this builder
     */
    public ViewBuilder addComponent(JComponent component) {
        components.add(component);
        mainPanel.add(component);
        return this;
    }

    public String getViewName() {
        return viewName;
    }

    /**
     * Builds the view.
     * @return the view.
     */
    public JPanel build() {
        return this;
    }
}
