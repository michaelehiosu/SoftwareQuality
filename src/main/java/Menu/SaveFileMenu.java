package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import Presentation.Presentation;
import Presentation.Accessor;
import Presentation.XMLAccessor;

public class SaveFileMenu extends SubMenus {

    protected static final String SAVEFILE = "dump.xml";
    protected static final String IOEX = "IO Exception: ";
    protected static final String SAVEERR = "Save Error";
    protected static final String SAVE = "Save";

    /**
     * Constructs a new SaveFileMenu.
     *
     * @param presentation The presentation object.
     * @param parent       The parent frame.
     */
    public SaveFileMenu(final Presentation presentation, final Frame parent) {
        super(presentation, parent);
    }

    @Override
    public void performAction(final MenuItem menuItem) {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Accessor xmlAccessor = new XMLAccessor();
                try {
                    xmlAccessor.saveFile(presentation, SAVEFILE);
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(parent, IOEX + exc, SAVEERR, JOptionPane.ERROR_MESSAGE);
                }
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
        return SAVE;
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
