package Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Presentation.Presentation;

/**
 * Represents the previous view menu option.
 */
public class PreviousViewMenu extends SubMenus implements MenuActions {
    protected static final String PREV = "Prev";

    /**
     * Constructs a PreviousViewMenu object.
     *
     * @param presentation The presentation object.
     * @param parent       The parent frame.
     */
    public PreviousViewMenu(final Presentation presentation, final Frame parent) {
        super(presentation, parent);
    }

    /**
     * Performs the action when the menu item is clicked.
     *
     * @param menuItem The menu item that triggered the action.
     */
    @Override
    public void performAction(final MenuItem menuItem) {
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.prevSlide();
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
        return PREV;
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
