package Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Presentation.Presentation;

public class NextViewMenu extends SubMenus {

    protected static final String NEXT = "Next";

    public NextViewMenu(final Presentation presentation, final Frame parent) {
        super(presentation, parent);
    }

    @Override
    public void performAction(final MenuItem menuItem) {
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.nextSlide();
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
        return NEXT;
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
