package menu;

import presentation.Presentation;

import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.Objects;

/**
 * The controller for the menu
 **/
public class MenuController extends MenuBar
{
  private static final long serialVersionUID = 227L;
  private final Frame parent;
  private final Presentation presentation;
  private MenuItem menuItem;

  public MenuController(final Frame frame, final Presentation presentation, final ArrayList<MenuActions> menuActions)
  {
    this.parent = frame;
    this.presentation = presentation;
    createMenu(menuActions);
  }

  public MenuController(final Frame frame, final Presentation presentation)
  {
    this.parent = frame;
    this.presentation = presentation;
    createDefaultMenu();
  }

  private void createDefaultMenu()
  {
    FileMenu fileMenu = new FileMenu();
    OpenFileMenu openFileMenu = new OpenFileMenu(presentation, parent);
    NewFileMenu newFileMenu = new NewFileMenu(presentation, parent);
    SaveFileMenu saveFileMenu = new SaveFileMenu(presentation, parent);
    ExitFileMenu exitFileMenu = new ExitFileMenu(presentation, parent);
    fileMenu.addChildren(openFileMenu);
    fileMenu.addChildren(newFileMenu);
    fileMenu.addChildren(saveFileMenu);
    fileMenu.addChildren(exitFileMenu);

    ViewMenu viewMenu = new ViewMenu();
    NextViewMenu nextViewMenu = new NextViewMenu(presentation, parent);
    PreviousViewMenu previousViewMenu = new PreviousViewMenu(presentation, parent);
    GotoViewMenu gotoViewMenu = new GotoViewMenu(presentation, parent);
    viewMenu.addChildren(nextViewMenu);
    viewMenu.addChildren(previousViewMenu);
    viewMenu.addChildren(gotoViewMenu);

    HelpMenu helpMenu = new HelpMenu();
    AboutHelpMenu aboutHelpMenu = new AboutHelpMenu(presentation, parent);
    helpMenu.addChildren(aboutHelpMenu);

    ArrayList<MenuActions> menuActions = new ArrayList<>();
    menuActions.add(fileMenu);
    menuActions.add(viewMenu);
    menuActions.add(helpMenu);

    createMenu(menuActions);
  }

  private void createMenu(final ArrayList<MenuActions> menuActions)
  {
    for (MenuActions component : menuActions)
    {
      component.performAction(menuItem);
      if (Objects.equals(component.getName(), "HELP"))
      {
        setHelpMenu(component.getMenu()); // needed for portability (Motif, etc.)
      }
      else
      {
        add(component.getMenu());
      }
    }
  }
}
