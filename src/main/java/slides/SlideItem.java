package slides;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 * The abstract class for an item on a slide
 **/

public abstract class SlideItem {
  private int level = 0;

  public SlideItem(int lev) {
    level = lev;
  }


  public int getLevel() {
    return level;
  }


  public abstract Rectangle getBoundingBox(Graphics graphics, ImageObserver imageObserver, float scale, Style style);

  public abstract void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver imageObserver);
}
