import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveFileMenu extends SubMenus
{
    protected static final String SAVEFILE = "dump.xml";
    protected static final String IOEX = "IO Exception: ";
    protected static final String SAVEERR = "Save Error";
    protected static final String SAVE = "Save";

    public SaveFileMenu(Presentation presentation, Frame parent)
    {
        super(presentation, parent);
    }

    @Override
    public void performAction(MenuItem menuItem)
    {
        menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Accessor xmlAccessor = new XMLAccessor();
                try
                {
                    xmlAccessor.saveFile(presentation, SAVEFILE);
                }
                catch (IOException exc)
                {
                    JOptionPane.showMessageDialog(parent, IOEX + exc, SAVEERR, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    @Override
    public String getName()
    {
        return SAVE;
    }

    @Override
    public Menu getMenu()
    {
        return null;
    }
}
