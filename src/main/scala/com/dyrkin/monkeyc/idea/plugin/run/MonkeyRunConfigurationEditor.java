package com.dyrkin.monkeyc.idea.plugin.run;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author eugene zadyra
 */
public class MonkeyRunConfigurationEditor extends SettingsEditor<MonkeyConfiguration> {

    private Project project;
    private JPanel panel;
    private JComboBox<String> targetDevice;

    public MonkeyRunConfigurationEditor(Project project) {
        this.project = project;
    }

    @Override
    protected void resetEditorFrom(MonkeyConfiguration monkeyModuleBasedConfiguration) {
        targetDevice.addItem(monkeyModuleBasedConfiguration.targetDevice());
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
        // TODO: place custom component creation code here
    }
}
