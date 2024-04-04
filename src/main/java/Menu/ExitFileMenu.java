package Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Presentation.Presentation;

public class ExitFileMenu extends SubMenus {

    protected static final String EXIT = "Exit";

    /**
     * Constructs a new ExitFileMenu.
     *
     * @param presentation The presentation object.
     * @param parent       The parent frame.
     */
    public ExitFileMenu(final Presentation presentation, final Frame parent) {
        super(presentation, parent);
    }

    @Override
    public void performAction(final MenuItem menuItem) {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.exit(0);
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
        return EXIT;
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
