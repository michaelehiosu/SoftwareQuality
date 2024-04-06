package com.jabberpoint.slides;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import javax.swing.DebugGraphics;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TextItemTest {
  /**
   * Method under test: {@link TextItem#getText()}
   */
  @Test
  void testGetText() {
    // Arrange, Act and Assert
    assertEquals("Text", (new TextItem(1, "Text")).getText());
    assertEquals("", (new TextItem(1, null)).getText());
  }

  /**
   * Method under test: {@link TextItem#getText()}
   */
  @Test
  void testGetText2() {
    // Arrange
    TextItem textItem = new TextItem(1, "");
    textItem.draw(2, 3, 10.0f, new DebugGraphics(), null, mock(ImageObserver.class));

    // Act and Assert
    assertEquals("", textItem.getText());
  }

  /**
   * Method under test: {@link TextItem#getAttributedString(Style, float)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testGetAttributedString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot read the array length because "com.jabberpoint.slides.Style.styles" is null
    //       at com.jabberpoint.slides.Style.getStyle(Style.java:40)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TextItem textItem = new TextItem(1, "Text");

    // Act
    textItem.getAttributedString(Style.getStyle(1), 10.0f);
  }

  /**
   * Method under test: {@link TextItem#getAttributedString(Style, float)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testGetAttributedString2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot invoke "com.jabberpoint.slides.Style.getFont(float)" because "style" is null
    //       at com.jabberpoint.slides.TextItem.getAttributedString(TextItem.java:41)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new TextItem(1, "Text")).getAttributedString(null, 10.0f);
  }

  /**
   * Method under test:
   * {@link TextItem#getBoundingBox(Graphics, ImageObserver, float, Style)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testGetBoundingBox() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    // TODO: Populate arranged inputs
    TextItem textItem = null;
    Graphics graphics = null;
    ImageObserver observer = null;
    float scale = 0.0f;
    Style style = null;

    // Act
    Rectangle actualBoundingBox = textItem.getBoundingBox(graphics, observer, scale, style);

    // Assert
    // TODO: Add assertions on result
  }

  /**
   * Method under test:
   * {@link TextItem#draw(int, int, float, Graphics, Style, ImageObserver)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testDraw() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    // TODO: Populate arranged inputs
    TextItem textItem = null;
    int x = 0;
    int y = 0;
    float scale = 0.0f;
    Graphics graphics = null;
    Style style = null;
    ImageObserver imageObserver = null;

    // Act
    textItem.draw(x, y, scale, graphics, style, imageObserver);

    // Assert
    // TODO: Add assertions on result
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TextItem#TextItem()}
   *   <li>{@link TextItem#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Slides.TextItem[0,]", (new TextItem()).toString());
    assertEquals("Slides.TextItem[1,Text]", (new TextItem(1, "Text")).toString());
  }
}
