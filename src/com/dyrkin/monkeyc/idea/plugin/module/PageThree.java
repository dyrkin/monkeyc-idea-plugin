package com.dyrkin.monkeyc.idea.plugin.module;

import javax.swing.*;

/**
 * @author eugene zadyra
 */
//Project template
class PageThree implements Page {
    private JPanel panel;
    JComboBox<String> template;
    JTextArea description;

    @Override
    public JPanel getPanel() {
        return panel;
    }

    public void setData(PageThree data) {
    }

    public void getData(PageThree data) {
    }

    public boolean isModified(PageThree data) {
        return false;
    }
}
