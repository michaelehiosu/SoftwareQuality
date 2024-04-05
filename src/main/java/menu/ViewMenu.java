package menu;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.util.ArrayList;
import java.util.List;


public class ViewMenu implements MenuActions {

  protected static final String VIEW = "View";
  private List<MenuActions> children;
  private Menu viewMenu;


  public ViewMenu() {
    this.children = new ArrayList<>();
    this.viewMenu = new Menu(VIEW);
  }


  public List<MenuActions> getChildren() {
    return children;
  }


  public void addChildren(MenuActions child) {
    this.children.add(child);
  }

  @Override
  public void performAction(MenuItem menuItem) {
    for (MenuActions child : children) {
      menuItem = mkMenuItem(child.getName());
      viewMenu.add(menuItem);
      child.performAction(menuItem);
    }
  }

  @Override
  public String getName() {
    return VIEW;
  }


  public MenuItem mkMenuItem(String name) {
    return new MenuItem(name, new MenuShortcut(name.charAt(0)));
  }

  @Override
  public Menu getMenu() {
    return this.viewMenu;
  }
}
