import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileMenu implements MenuActions
{
    protected static final String FILE = "File";
    private List<MenuActions> children;
    private String name;
    private Menu fileMenu;

    public FileMenu()
    {
        this.children = new ArrayList<>();
        this.fileMenu = new Menu(FILE);
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
            if(Objects.equals(child.getName(), "EXIT")) {
                fileMenu.addSeparator();
            }
            fileMenu.add(menuItem = mkMenuItem(child.getName()));
            child.performAction(menuItem);
        }
    }

    @Override
    public String getName()
    {
        return FILE;
    }

    @Override
    public Menu getMenu()
    {
        return this.fileMenu;
    }

    public MenuItem mkMenuItem(String name)
    {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
