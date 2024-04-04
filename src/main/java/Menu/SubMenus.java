package Menu;

import java.awt.*;
import Presentation.Presentation;

/**
 * Abstract class representing sub-menus.
 */
public abstract class SubMenus implements MenuActions {

    protected Presentation presentation;
    protected Frame parent;

    /**
     * Constructs a SubMenus object.
     *
     * @param presentation The presentation object.
     * @param parent       The parent frame.
     */
    public SubMenus(final Presentation presentation, final Frame parent) {
        this.presentation = presentation;
        this.parent = parent;
    }
}
