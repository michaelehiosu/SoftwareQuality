package menu;

import java.awt.Menu;
import java.awt.MenuItem;

public interface MenuActions
{
  void performAction(MenuItem menuItem);

  String getName();

  Menu getMenu();
}

