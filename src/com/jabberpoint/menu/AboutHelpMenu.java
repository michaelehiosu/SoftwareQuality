package menu;

import components.AboutBox;
import presentation.Presentation;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutHelpMenu extends SubMenus implements MenuActions
{

  protected static final String ABOUT = "About";


  public AboutHelpMenu(final Presentation presentation, final Frame parent)
  {
    super(presentation, parent);
  }

  @Override
  public void performAction(final MenuItem menuItem)
  {
    menuItem.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent actionEvent)
      {
        AboutBox.show(parent);
      }
    });
  }


  @Override
  public String getName()
  {
    return ABOUT;
  }


  @Override
  public Menu getMenu()
  {
    return null;
  }
}
