package com.jabberpoint.components;

import com.jabberpoint.presentation.Presentation;
import com.jabberpoint.presentation.PresentationObserver;
import com.jabberpoint.slides.Slide;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


/** Components.SlideViewerComponent is a graphical component that can show slides **/

public class SlideViewerComponent extends JComponent implements PresentationObserver
{
  private static final long serialVersionUID = 227L;
  private static final Color BGCOLOR = Color.white;
  private static final Color COLOR = Color.black;
  private static final String FONTNAME = "Dialog";
  private static final int FONTSTYLE = Font.BOLD;
  private static final int FONTHEIGHT = 10;
  private static final int XPOS = 1100;
  private static final int YPOS = 20;
  private Slide slide;
  private Font labelFont;
  private Presentation presentation;
  private JFrame parent;

  public SlideViewerComponent(Presentation presentation, JFrame parent)
  {
    setBackground(BGCOLOR);
    this.presentation = presentation;
    labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
    this.parent = parent;
  }

  public Dimension getPreferredSize()
  {
    return new Dimension(Slide.WIDTH, Slide.HEIGHT);
  }

  @Override
  public void update(Slide slide)
  {
    if (slide == null)
    {
      repaint();
      return;
    }

    this.slide = slide;
    repaint();
    parent.setTitle(presentation.getTitle());
  }


  public void paintComponent(Graphics graphics)
  {
    fillArea(graphics);
    if (shouldDrawSlide())
    {
      drawSlideText(graphics);
      drawSlide(graphics);
    }
  }

  private void fillArea(Graphics graphics)
  {
    graphics.setColor(BGCOLOR);
    graphics.fillRect(0, 0, getSize().width, getSize().height);
  }

  private boolean shouldDrawSlide()
  {
    return presentation.getSlideNumber() >= 0 && slide != null;
  }

  private void drawSlideText(Graphics graphics)
  {
    graphics.setFont(labelFont);
    graphics.setColor(COLOR);
    graphics.drawString("Slides.Slide " + (1 + presentation.getSlideNumber()) + " of " + presentation.getSize(), XPOS, YPOS);
  }

  private void drawSlide(Graphics graphics)
  {
    Rectangle area = createRectangle();
    slide.draw(graphics, area, this);
  }


  private Rectangle createRectangle()
  {
    return new Rectangle(0, YPOS, getWidth(), getHeight() - YPOS);
  }
}
