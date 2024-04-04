package Menu;

import Presentation.AboutBox;
import Presentation.Presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutHelpMenu extends SubMenus implements MenuActions {

    protected static final String ABOUT = "About";

    /**
     * Constructs a new AboutHelpMenu.
     *
     * @param presentation The presentation object.
     * @param parent       The parent frame.
     */
    public AboutHelpMenu(final Presentation presentation, final Frame parent) {
        super(presentation, parent);
    }

    @Override
    public void performAction(final MenuItem menuItem) {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AboutBox.show(parent);
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
        return ABOUT;
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
