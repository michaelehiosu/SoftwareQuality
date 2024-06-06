package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;
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
  private ArrayList<MenuActions> mainMenus;

  public MenuController(Frame frame, Presentation presentation, ArrayList<MenuActions> mainMenus)
  {
    this.parent = frame;
    this.presentation = presentation;
    this.menuItem = new MenuItem();
    this.mainMenus = mainMenus;
    createMenu();
  }

  public MenuController(Frame parent, Presentation presentation)
  {
    this.parent = parent;
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

    ArrayList<MenuActions> mainmenus = new ArrayList<>();
    mainmenus.add(fileMenu);
    mainmenus.add(viewMenu);
    mainmenus.add(helpMenu);

    this.mainMenus = mainmenus;
    createMenu();
  }

  private void createMenu()
  {
    for (MenuActions component : this.mainMenus)
    {
      component.performAction(menuItem);
      setMenu(component);

    }
  }


  private void setMenu(MenuActions component)
  {
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
