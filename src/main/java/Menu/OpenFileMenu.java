package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import Presentation.Presentation;
import Presentation.Accessor;
import Presentation.XMLAccessor;

public class OpenFileMenu extends SubMenus {

    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String TESTFILE = "test.xml";
    protected static final String OPEN = "Open";

    /**
     * Constructs a new OpenFileMenu.
     *
     * @param presentation The presentation object.
     * @param parent       The parent frame.
     */
    public OpenFileMenu(final Presentation presentation, final Frame parent) {
        super(presentation, parent);
    }

    @Override
    public void performAction(final MenuItem menuItem) {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.clear();
                Accessor xmlAccessor = new XMLAccessor();
                try {
                    xmlAccessor.loadFile(presentation, TESTFILE);
                    presentation.setSlideNumber(0);
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(parent, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
                }
                parent.repaint();
            }
        });
    }

    /**
     * Gets the name of the menu.
     *
     * @return The name of the menu.
     */
    @Override
    public String getName() {
        return OPEN;
    }

    /**
     * Gets the menu associated with this action.
     *
     * @return The menu associated with this action.
     */
    @Override
    public Menu getMenu() {
        return null;
    }
}
