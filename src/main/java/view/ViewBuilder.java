package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

    public ViewBuilder addLabel(String labelText) {
        final JLabel label = new JLabel(labelText);
        components.add(label);
        mainPanel.add(label);
        return this;
    }

    public ViewBuilder addButton(String buttonText, Runnable onClick) {
        final JButton button = new JButton(buttonText);
        components.add(button);
        buttonsPanel.add(button);
        return this;
    }

    public ViewBuilder addComponent(JComponent component) {
        components.add(component);
        mainPanel.add(component);
        return this;
    }

    public String getViewName() {
        return viewName;
    }

    public JPanel build() {
        return this;
    }
}
