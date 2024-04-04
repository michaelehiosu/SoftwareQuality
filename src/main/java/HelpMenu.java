import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HelpMenu implements MenuActions
{
    protected static final String HELP = "Help";
    private List<MenuActions> children;
    private String name;
    private Menu helpMenu;

    public HelpMenu()
    {
        this.children = new ArrayList<>();
        this.helpMenu = new Menu(HELP);
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
            helpMenu.add(menuItem = mkMenuItem(child.getName()));
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

    public MenuItem mkMenuItem(String name)
    {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
