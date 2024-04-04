package Menu;

import java.awt.Menu;
import java.awt.MenuItem;

public interface MenuActions {

    // Perform action for the given menu item
    void performAction(MenuItem menuItem);

    // Get the name of the action
    String getName();

    // Get the menu associated with this action
    Menu getMenu();
}

