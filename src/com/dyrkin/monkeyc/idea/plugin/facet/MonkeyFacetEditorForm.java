package com.dyrkin.monkeyc.idea.plugin.facet;

import javax.swing.*;

/**
 * @author eugene zadyra
 */
public class MonkeyFacetEditorForm {
    private JPanel panel;
    private JComboBox<String> targetDevice;

    public JPanel getPanel() {
        return panel;
    }

    public String getTargetDeviceId() {
        return (String) targetDevice.getSelectedItem();
    }

    public void setTargetDeviceId(String targetDeviceId) {
        this.targetDevice.setSelectedItem(targetDeviceId);
    }


}
