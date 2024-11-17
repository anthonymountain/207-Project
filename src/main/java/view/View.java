package view;

import java.awt.*;

import javax.swing.*;

/**
 * Base class for all views in the application.
 */
public abstract class View extends JPanel {
    // You can add any common components or methods for views here
    private String viewName;

    public String getViewName() {
        return this.viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
}