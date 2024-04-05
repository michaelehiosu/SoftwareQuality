package menu;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileMenu implements MenuActions {

  protected static final String FILE = "File";
  private final List<MenuActions> children;
  private final Menu fileMenu;


  public FileMenu() {
    this.children = new ArrayList<>();
    this.fileMenu = new Menu(FILE);
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
      if (Objects.equals(child.getName(), "EXIT")) {
        fileMenu.addSeparator();
      }
      fileMenu.add(menuItem = makeMenuItem(child.getName()));
      child.performAction(menuItem);
    }
  }


  @Override
  public String getName() {
    return FILE;
  }


  @Override
  public Menu getMenu() {
    return this.fileMenu;
  }


  public MenuItem makeMenuItem(String name) {
    return new MenuItem(name, new MenuShortcut(name.charAt(0)));
  }
}
