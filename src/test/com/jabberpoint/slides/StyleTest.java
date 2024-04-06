package com.jabberpoint.slides;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.awt.Color;
import java.awt.color.ColorSpace;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StyleTest {

  @Test
  void testCreateStyles() {
    // Arrange and Act
    Style.createStyles();
  }


  @Test
  void testGetStyle() {
    // Arrange, Act and Assert
    Color color = Style.getStyle(1).color;
    ColorSpace expectedColorSpace = color.getColorSpace();
    assertSame(expectedColorSpace, color.darker().getColorSpace());
  }


  @Test
  void testGetStyle2() {
    // Arrange, Act and Assert
    Color color = Style.getStyle(5).color;
    ColorSpace expectedColorSpace = color.getColorSpace();
    assertSame(expectedColorSpace, color.darker().getColorSpace());
  }


  @Test
  void testNewStyle() throws NumberFormatException {
    // Arrange and Act
    new Style(1, Color.black, 1, 1);

  }


  @Test
  void testNewStyle2() throws NumberFormatException {
    // Arrange, Act and Assert
    Color color = (new Style(1, Color.decode("42"), 1, 1)).color;
    ColorSpace expectedColorSpace = color.getColorSpace();
    assertSame(expectedColorSpace, color.darker().getColorSpace());
  }


  @Test
  void testGetFont() {

    // Arrange and Act
    Style.getStyle(1).getFont(10.0f);
  }
}
