package menu;

import presentation.Presentation;

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
  protected static final String PREV = "Prev";


  public PreviousViewMenu(final Presentation presentation, final Frame parent)
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
        presentation.prevSlide();
      }
    });
  }


  @Override
  public String getName()
  {
    return PREV;
  }


  @Override
  public Menu getMenu()
  {
    return null;
  }
}
