package menu;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.util.ArrayList;
import java.util.List;


public class HelpMenu implements MenuActions
{
  protected static final String HELP = "Help";

  private final List<MenuActions> children;

  private final Menu helpMenu;


  public HelpMenu()
  {
    this.children = new ArrayList<>();
    this.helpMenu = new Menu(HELP);
  }


  public List<MenuActions> getChildren()
  {
    return children;
  }


  public void addChildren(MenuActions child)
  {
    this.children.add(child);
  }

  @Override
  public void performAction(MenuItem menuItem)
  {
    for (MenuActions child : children)
    {
      menuItem = makeMenuItem(child.getName());
      helpMenu.add(menuItem);
      child.performAction(menuItem);
    }
  }

  @Override
  public String getName()
  {
    return HELP;
  }

  @Override
  public Menu getMenu()
  {
    return this.helpMenu;
  }


  public MenuItem makeMenuItem(String name)
  {
    return new MenuItem(name, new MenuShortcut(name.charAt(0)));
  }
}
