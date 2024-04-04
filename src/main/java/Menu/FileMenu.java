package Menu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileMenu implements MenuActions {

    protected static final String FILE = "File";
    private final List<MenuActions> children;
    private final Menu fileMenu;

    /**
     * Constructs a new FileMenu.
     */
    public FileMenu() {
        this.children = new ArrayList<>();
        this.fileMenu = new Menu(FILE);
    }

    /**
     * Gets the children of the menu.
     *
     * @return The children of the menu.
     */
    public List<MenuActions> getChildren() {
        return children;
    }

    /**
     * Adds a child menu.
     *
     * @param child The child menu to add.
     */
    public void addChildren(MenuActions child) {
        this.children.add(child);
    }

    @Override
    public void performAction(MenuItem menuItem) {
        for (MenuActions child : children) {
            if (Objects.equals(child.getName(), "EXIT")) {
                fileMenu.addSeparator();
            }
            fileMenu.add(menuItem = mkMenuItem(child.getName()));
            child.performAction(menuItem);
        }
    }

    /**
     * Gets the name of the menu.
     *
     * @return The name of the menu.
     */
    @Override
    public String getName() {
        return FILE;
    }

    /**
     * Gets the menu associated with this action.
     *
     * @return The menu associated with this action.
     */
    @Override
    public Menu getMenu() {
        return this.fileMenu;
    }

    /**
     * Creates a new MenuItem.
     *
     * @param name The name of the menu item.
     * @return The created MenuItem.
     */
    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
