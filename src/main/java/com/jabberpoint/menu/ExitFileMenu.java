package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitFileMenu extends SubMenus
{

  protected static final String EXIT = "Exit";


  public ExitFileMenu(Presentation presentation, Frame parent)
  {
    super(presentation, parent);
  }

  @Override
  public void performAction(MenuItem menuItem)
  {
    menuItem.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent actionEvent)
      {
        presentation.exit(0);
      }
    });
  }

  @Override
  public String getName()
  {
    return EXIT;
  }


  @Override
  public Menu getMenu()
  {
    return null;
  }
}
