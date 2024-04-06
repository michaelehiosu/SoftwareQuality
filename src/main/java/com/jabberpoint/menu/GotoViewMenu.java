package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;

import javax.swing.JOptionPane;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GotoViewMenu extends SubMenus
{
  protected static final String PAGENR = "Page number?";


  protected static final String GOTO = "Go to";


  public GotoViewMenu(Presentation presentation, Frame parent)
  {
    super(presentation, parent);
  }


  @Override
  public void performAction(final MenuItem menuItem)
  {
    menuItem.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent actionEvent)
      {
        String pageNumberStr = JOptionPane.showInputDialog(parent, PAGENR);
        int pageNumber = Integer.parseInt(pageNumberStr);
        presentation.setSlideNumber(pageNumber - 1);
      }
    });
  }

  @Override
  public String getName()
  {
    return GOTO;
  }


  @Override
  public Menu getMenu()
  {
    return null;
  }
}
