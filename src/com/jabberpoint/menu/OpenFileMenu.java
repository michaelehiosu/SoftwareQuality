package menu;

import assessor.Accessor;
import assessor.XMLAccessor;
import presentation.Presentation;

import javax.swing.JOptionPane;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OpenFileMenu extends SubMenus
{
  protected static final String IOEX = "IO Exception: ";
  protected static final String LOADERR = "Load Error";
  protected static final String TESTFILE = "test.xml";
  protected static final String OPEN = "Open";

  public OpenFileMenu(final Presentation presentation, final Frame parent)
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
        presentation.clear();
        Accessor xmlAccessor = new XMLAccessor();
        try
        {
          xmlAccessor.loadFile(presentation, TESTFILE);
          presentation.setSlideNumber(0);
        } catch (IOException exc)
        {
          JOptionPane.showMessageDialog(parent, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
        }
        parent.repaint();
      }
    });
  }


  @Override
  public String getName()
  {
    return OPEN;
  }


  @Override
  public Menu getMenu()
  {
    return null;
  }
}
