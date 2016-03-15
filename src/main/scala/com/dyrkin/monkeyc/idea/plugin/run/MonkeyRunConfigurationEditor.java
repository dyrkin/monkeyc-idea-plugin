package com.dyrkin.monkeyc.idea.plugin.run;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.List;

/**
 * @author eugene zadyra
 */
public class MonkeyRunConfigurationEditor extends SettingsEditor<MonkeyConfiguration> {

    private List<String> possibleTargets;
    private JPanel panel;
    private JComboBox<String> targetDevice;

    public MonkeyRunConfigurationEditor(List<String> possibleTargets) {
        this.possibleTargets = possibleTargets;
    }

    @Override
    protected void resetEditorFrom(MonkeyConfiguration monkeyModuleBasedConfiguration) {
        targetDevice.removeAllItems();
        for (String tg : possibleTargets) {
            targetDevice.addItem(tg);
        }
        targetDevice.setSelectedItem(monkeyModuleBasedConfiguration.targetDevice());
    }

    @Override
    protected void applyEditorTo(MonkeyConfiguration configuration) throws ConfigurationException {
        configuration.setTargetDevice((String) targetDevice.getSelectedItem());
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return panel;
    }


    private void createUIComponents() {


    }
}
