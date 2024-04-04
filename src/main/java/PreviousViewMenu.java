import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousViewMenu extends SubMenus
{
    protected static final String PREV = "Prev";
    public PreviousViewMenu(Presentation presentation, Frame parent)
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
                presentation.prevSlide();
            }
        });
    }

    @Override
    public String getName()
    {
        return PREV;
    }

    @Override
    public Menu getMenu()
    {
        return null;
    }
}
