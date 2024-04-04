import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewMenu implements MenuActions
{
    protected static final String VIEW = "View";
    private List<MenuActions> children;
    private String name;
    private Menu viewMenu;
    private MenuItem menuItem;

    public ViewMenu()
    {
        this.children = new ArrayList<>();
        this.viewMenu = new Menu(VIEW);
    }

    public List<MenuActions> getChildren()
    {
        return children;
    }

    public void addChildren(MenuActions children)
    {
        this.children.add(children);
    }

    @Override
    public void performAction(MenuItem menuItem)
    {
        for (MenuActions child : children)
        {
            viewMenu.add(menuItem = mkMenuItem(child.getName()));
            child.performAction(menuItem);
        }
    }

    @Override
    public String getName()
    {
        return VIEW;
    }

    public MenuItem mkMenuItem(String name)
    {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }

    @Override
    public Menu getMenu() {
        return this.viewMenu;
    }
}
