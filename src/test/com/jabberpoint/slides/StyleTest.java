package com.jabberpoint.slides;

import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.awt.color.ColorSpace;

import static org.junit.jupiter.api.Assertions.assertSame;

class StyleTest
{

  @Test
  void testCreateStyles()
  {
    Style.createStyles();
  }


  @Test
  void testGetStyle()
  {
    Color color = Style.getStyle(1).color;
    ColorSpace expectedColorSpace = color.getColorSpace();
    assertSame(expectedColorSpace, color.darker().getColorSpace());
  }


  @Test
  void testGetStyle2()
  {
    Color color = Style.getStyle(5).color;
    ColorSpace expectedColorSpace = color.getColorSpace();
    assertSame(expectedColorSpace, color.darker().getColorSpace());
  }


  @Test
  void testNewStyle() throws NumberFormatException
  {
    new Style(1, Color.black, 1, 1);
  }


  @Test
  void testNewStyle2() throws NumberFormatException
  {
    Color color = (new Style(1, Color.decode("42"), 1, 1)).color;
    ColorSpace expectedColorSpace = color.getColorSpace();
    assertSame(expectedColorSpace, color.darker().getColorSpace());
  }


  @Test
  void testGetFont()
  {
    Style.getStyle(1).getFont(10.0f);
  }
}
