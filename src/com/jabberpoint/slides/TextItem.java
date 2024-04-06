package slides;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextItem extends SlideItem
{
  private final String text;

  public TextItem(int level, String text)
  {
    super(level);
    this.text = text;
  }

  public TextItem()
  {
    this(0, "");
  }

  public String getText()
  {
    return text == null ? "" : text;
  }

  public AttributedString getAttributedString(Style style, float scale)
  {
    AttributedString attributedString = new AttributedString(getText());
    attributedString.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, text.length());
    return attributedString;
  }

  @Override
  public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style style)
  {
    List<TextLayout> layouts = getLayouts(graphics, style, scale);
    int xsize = 0;
    int ysize = (int) (style.leading * scale);

    Iterator<TextLayout> iterator = layouts.iterator();
    while (iterator.hasNext())
    {
      TextLayout layout = iterator.next();
      Rectangle2D bounds = layout.getBounds();
      if (bounds.getWidth() > xsize)
      {
        xsize = (int) bounds.getWidth();
      }
      if (bounds.getHeight() > 0)
      {
        ysize += bounds.getHeight();
      }
      ysize += layout.getLeading() + layout.getDescent();
    }
    return new Rectangle((int) (style.indent * scale), 0, xsize, ysize);
  }


  @Override
  public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver imageObserver)
  {
    if (text == null || text.length() == 0)
    {
      return;
    }

    List<TextLayout> layouts = getLayouts(graphics, style, scale);
    Point pen = new Point(x + (int) (style.indent * scale), y + (int) (style.leading * scale));
    Graphics2D g2d = (Graphics2D) graphics;
    g2d.setColor(style.color);

    Iterator<TextLayout> it = layouts.iterator();
    while (it.hasNext())
    {
      TextLayout layout = it.next();
      pen.y += layout.getAscent();
      layout.draw(g2d, pen.x, pen.y);
      pen.y += layout.getDescent();
    }
  }

  private List<TextLayout> getLayouts(Graphics graphics, Style style, float scale)
  {
    List<TextLayout> layouts = new ArrayList<TextLayout>();
    AttributedString attrStr = getAttributedString(style, scale);
    Graphics2D g2d = (Graphics2D) graphics;
    FontRenderContext frc = g2d.getFontRenderContext();
    LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
    float wrappingWidth = (Slide.WIDTH - style.indent) * scale;
    while (measurer.getPosition() < getText().length())
    {
      TextLayout layout = measurer.nextLayout(wrappingWidth);
      layouts.add(layout);
    }
    return layouts;
  }

  public String toString()
  {
    return "Slides.TextItem[" + getLevel() + "," + getText() + "]";
  }
}
