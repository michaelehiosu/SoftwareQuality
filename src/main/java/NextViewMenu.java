import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextViewMenu extends SubMenus
{
    protected static final String NEXT = "Next";
    public NextViewMenu(Presentation presentation, Frame parent)
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
                presentation.nextSlide();
            }
        });
    }

    @Override
    public String getName()
    {
        return NEXT;
    }

    @Override
    public Menu getMenu()
    {
        return null;
    }
}
