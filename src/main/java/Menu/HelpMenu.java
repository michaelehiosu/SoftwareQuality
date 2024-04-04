package Menu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a help menu.
 */
public class HelpMenu implements MenuActions {

    /**
     * The constant HELP.
     */
    protected static final String HELP = "Help";
    /**
     * The children.
     */
    private final List<MenuActions> children;
    /**
     * The help menu.
     */
    private final Menu helpMenu;

    /**
     * Instantiates a new Help menu.
     */
    public HelpMenu() {
        this.children = new ArrayList<>();
        this.helpMenu = new Menu(HELP);
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
            helpMenu.add(menuItem);
            child.performAction(menuItem);
        }
    }

    @Override
    public String getName() {
        return HELP;
    }

    @Override
    public Menu getMenu() {
        return this.helpMenu;
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
}
