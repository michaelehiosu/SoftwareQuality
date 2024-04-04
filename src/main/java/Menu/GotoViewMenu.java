package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Presentation.Presentation;

/**
 * Represents a menu for navigating to a specific slide.
 */
public class GotoViewMenu extends SubMenus {

    /**
     * The message prompt for entering the page number.
     */
    protected static final String PAGENR = "Page number?";

    /**
     * The label for the "Go to" menu item.
     */
    protected static final String GOTO = "Go to";

    /**
     * Constructs a GotoViewMenu with the specified presentation and parent frame.
     *
     * @param presentation The Presentation object associated with this menu.
     * @param parent       The parent Frame of this menu.
     */
    public GotoViewMenu(final Presentation presentation, final Frame parent) {
        super(presentation, parent);
    }

    /**
     * Performs the action when the "Go to" menu item is selected.
     *
     * @param menuItem The MenuItem object representing the "Go to" menu item.
     */
    @Override
    public void performAction(final MenuItem menuItem) {
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String pageNumberStr = JOptionPane.showInputDialog(parent, PAGENR);
                int pageNumber = Integer.parseInt(pageNumberStr);
                presentation.setSlideNumber(pageNumber - 1);
            }
        });
    }

    /**
     * Gets the name of this menu.
     *
     * @return The name of the menu ("Go to").
     */
    @Override
    public String getName() {
        return GOTO;
    }

    /**
     * Gets the Menu object associated with this menu.
     *
     * @return Always returns null as there is no associated Menu object for this menu.
     */
    @Override
    public Menu getMenu() {
        return null;
    }
}
