import java.awt.*;

public abstract class SubMenus implements MenuActions
{
    protected Presentation presentation;
    protected Frame parent;

    public SubMenus(Presentation presentation, Frame parent)
    {
        this.presentation = presentation;
        this.parent = parent;
    }
}
