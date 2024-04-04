package Slides;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Vector;

// A slide. This class has a drawing functionality.

public class Slide
{
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    protected String title;
    protected Vector<SlideItem> items;

    public Slide()
    {
        items = new Vector<>();
    }

    public void appendSlideItem(SlideItem slideItem)
    {
        items.addElement(slideItem);
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

    public void appendText(int level, String message)
    {
        appendSlideItem(new TextItem(level, message));
    }

    public SlideItem getSlideItem(int number)
    {
        return items.elementAt(number);
    }

    public Vector<SlideItem> getSlideItems()
    {
        return items;
    }

    public int getSize()
    {
        return items.size();
    }

    public void draw(Graphics graphics, Rectangle area, ImageObserver imageObserver)
    {
        float scale = getScale(area);
        int y = area.y;
        // Title is handled separately
        SlideItem slideItem = new TextItem(0, getTitle());
        Style style = Style.getStyle(slideItem.getLevel());
        slideItem.draw(area.x, y, scale, graphics, style, imageObserver);
        y += slideItem.getBoundingBox(graphics, imageObserver, scale, style).height;
        for (int number = 0; number < getSize(); number++)
        {
            slideItem = getSlideItems().elementAt(number);
            style = Style.getStyle(slideItem.getLevel());
            slideItem.draw(area.x, y, scale, graphics, style, imageObserver);
            y += slideItem.getBoundingBox(graphics, imageObserver, scale, style).height;
        }
    }

    private float getScale(Rectangle area)
    {
        return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
    }
}
