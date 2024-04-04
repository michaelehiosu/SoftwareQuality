import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GotoViewMenu extends SubMenus
{
    protected static final String PAGENR = "Page number?";
    protected static final String GOTO = "Go to";

    public GotoViewMenu(Presentation presentation, Frame parent)
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
                String pageNumberStr = JOptionPane.showInputDialog(PAGENR);
                int pageNumber = Integer.parseInt(pageNumberStr);
                presentation.setSlideNumber(pageNumber - 1);
            }
        });
    }

    @Override
    public String getName()
    {
        return GOTO;
    }

    @Override
    public Menu getMenu()
    {
        return null;
    }
}
