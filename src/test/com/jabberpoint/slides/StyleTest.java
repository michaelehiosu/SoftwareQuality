package com.jabberpoint.slides;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.awt.Color;
import java.awt.color.ColorSpace;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StyleTest {
  /**
   * Method under test: {@link Style#createStyles()}
   */
  @Test
  void testCreateStyles() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    Style.createStyles();
  }

  /**
   * Method under test: {@link Style#getStyle(int)}
   */
  @Test
  void testGetStyle() {
    // Arrange, Act and Assert
    Color color = Style.getStyle(1).color;
    ColorSpace expectedColorSpace = color.getColorSpace();
    assertSame(expectedColorSpace, color.darker().getColorSpace());
  }

  /**
   * Method under test: {@link Style#getStyle(int)}
   */
  @Test
  void testGetStyle2() {
    // Arrange, Act and Assert
    Color color = Style.getStyle(5).color;
    ColorSpace expectedColorSpace = color.getColorSpace();
    assertSame(expectedColorSpace, color.darker().getColorSpace());
  }

  /**
   * Method under test: {@link Style#getStyle(int)}
   */
  @Test
  void testNewStyle() throws NumberFormatException {
    // Arrange and Act
    new Style(1, Color.black, 1, 1);

  }

  /**
   * Method under test: {@link Style#Style(int, Color, int, int)}
   */
  @Test
  void testNewStyle2() throws NumberFormatException {
    // Arrange, Act and Assert
    Color color = (new Style(1, Color.decode("42"), 1, 1)).color;
    ColorSpace expectedColorSpace = color.getColorSpace();
    assertSame(expectedColorSpace, color.darker().getColorSpace());
  }

  /**
   * Method under test: {@link Style#toString()}
   */
  @Test
  void testGetFont() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    Style.getStyle(1).getFont(10.0f);
  }
}
