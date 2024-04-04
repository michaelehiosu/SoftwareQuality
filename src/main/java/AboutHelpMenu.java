import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutHelpMenu extends SubMenus implements MenuActions
{
    protected static final String ABOUT = "About";

    public AboutHelpMenu(Presentation presentation, Frame parent)
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
                AboutBox.show(parent);
            }
        });
    }

    @Override
    public String getName()
    {
        return ABOUT;
    }

    @Override
    public Menu getMenu()
    {
        return null;
    }
}
