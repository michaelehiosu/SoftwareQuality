import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFileMenu extends SubMenus
{
    protected static final String NEW = "New";
    public NewFileMenu(Presentation presentation, Frame parent)
    {
        super(presentation, parent);
    }

    @Override
    public void performAction(MenuItem menuItem)
    {
        menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                presentation.clear();
                parent.repaint();
            }
        });
    }

    @Override
    public String getName()
    {
        return NEW;
    }

    @Override
    public Menu getMenu()
    {
        return null;
    }
}
