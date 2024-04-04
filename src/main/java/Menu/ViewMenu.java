package Menu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a view menu.
 */
public class ViewMenu implements MenuActions {

    /** The constant VIEW. */
    protected static final String VIEW = "View";
    /** The children. */
    private final List<MenuActions> children;
    /** The view menu. */
    private final Menu viewMenu;

    /**
     * Instantiates a new View menu.
     */
    public ViewMenu() {
        this.children = new ArrayList<>();
        this.viewMenu = new Menu(VIEW);
    }

    /**
     * Gets children.
     *
     * @return the children
     */
    public List<MenuActions> getChildren() {
        return children;
    }

    /**
     * Add children.
     *
     * @param child the child
     */
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

    /**
     * Make menu item menu item.
     *
     * @param name the name
     * @return the menu item
     */
    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }

    @Override
    public Menu getMenu() {
        return this.viewMenu;
    }
}
