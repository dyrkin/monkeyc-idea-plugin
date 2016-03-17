package com.dyrkin.monkeyc.idea.plugin.module;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


//Languages
class PageTwo implements Page {
  private JPanel panel;
  JCheckBox eng;

  @Override
  public JPanel getPanel() {
    return panel;
  }

  public void setData(PageTwo data) {
  }

  public void getData(PageTwo data) {
  }

  public boolean isModified(PageTwo data) {
    return false;
  }


}
