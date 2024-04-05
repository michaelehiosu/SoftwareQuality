package menu;

import presentation.Presentation;

import java.awt.Frame;


public abstract class SubMenus implements MenuActions {

  protected Presentation presentation;
  protected Frame parent;


  public SubMenus(final Presentation presentation, final Frame parent) {
    this.presentation = presentation;
    this.parent = parent;
  }
}
