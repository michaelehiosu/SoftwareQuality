package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the previous view menu option.
 */
public class PreviousViewMenu extends SubMenus implements MenuActions
{
  protected static final String PREVIOUS = "Prev";

  public PreviousViewMenu(Presentation presentation, Frame parent)
  {
    super(presentation, parent);
  }

  @Override
  public void performAction(MenuItem menuItem)
  {
    menuItem.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent actionEvent)
      {
        presentation.prevSlide();
      }
    });
  }


  @Override
  public String getName()
  {
    return PREVIOUS;
  }


  @Override
  public Menu getMenu()
  {
    return null;
  }
}
