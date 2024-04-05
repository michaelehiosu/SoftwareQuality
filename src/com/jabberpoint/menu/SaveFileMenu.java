package menu;

import assessor.Accessor;
import presentation.Presentation;
import assessor.XMLAccessor;

import javax.swing.JOptionPane;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveFileMenu extends SubMenus {

  protected static final String SAVEFILE = "dump.xml";
  protected static final String IOEX = "IO Exception: ";
  protected static final String SAVEERR = "Save Error";
  protected static final String SAVE = "Save";


  public SaveFileMenu(final Presentation presentation, final Frame parent) {
    super(presentation, parent);
  }

  @Override
  public void performAction(final MenuItem menuItem) {
    menuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Accessor xmlAccessor = new XMLAccessor();
        try {
          xmlAccessor.saveFile(presentation, SAVEFILE);
        } catch (IOException exc) {
          JOptionPane.showMessageDialog(parent, IOEX + exc, SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }


  @Override
  public String getName() {
    return SAVE;
  }


  @Override
  public Menu getMenu() {
    return null;
  }
}
