package com.dyrkin.monkeyc.idea.plugin.module;

import javax.swing.*;

/**
 * @author eugene zadyra
 */
//Project type + Platform
class PageOne implements Page {
    private JPanel panel;
    JComboBox<String> projectType;
    JCheckBox squareWatch;
    JCheckBox tallWatch;
    JCheckBox roundWatch;
    JCheckBox semiRoundWatch;
    JCheckBox forerunner630;
    JCheckBox forerunner235;
    JCheckBox forerunner230;
    JCheckBox vivoactive;
    JCheckBox fenix3;
    JCheckBox fenix3hr;
    JCheckBox d2Bravo;
    JCheckBox forerunner920;
    JCheckBox epix;
    JCheckBox vivoactiveHr;

    @Override
    public JPanel getPanel() {
        return panel;
    }

    public void setData(PageOne data) {
    }

    public void getData(PageOne data) {
    }

    public boolean isModified(PageOne data) {
        return false;
    }
}
