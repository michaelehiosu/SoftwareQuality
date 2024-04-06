package com.jabberpoint.slides;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlideTest {
  /**
   * Method under test: {@link Slide#appendSlideItem(SlideItem)}
   */
  @Test
  void testAppendSlideItem2() {
    // Arrange
    Slide slide = new Slide();

    // Act
    slide.appendSlideItem(new BitmapItem(1, "Image Name"));

    // Assert
    assertEquals(1, slide.getSize());
  }

  /**
   * Method under test: {@link Slide#appendText(int, String)}
   */
  @Test
  void testAppendText() {
    // Arrange
    Slide slide = new Slide();

    // Act
    slide.appendText(1, "Not all who wander are lost");

    // Assert
    SlideItem getResult = slide.getSlideItems().get(0);
    assertEquals("Not all who wander are lost", ((TextItem) getResult).getText());
    assertEquals(1, slide.getSize());
    assertEquals(1, getResult.getLevel());
  }

  /**
   * Method under test: {@link Slide#getSlideItem(int)}
   */
//  @Test
//  @Disabled("TODO: Complete this test")
//  void testGetSlideItem() {
//    // TODO: Diffblue Cover was only able to create a partial test for this method:
//    //   Reason: No inputs found that don't throw a trivial exception.
//    //   Diffblue Cover tried to run the arrange/act section, but the method under
//    //   test threw
//    //   java.lang.ArrayIndexOutOfBoundsException: 10 >= 0
//    //       at java.base/java.util.Vector.elementAt(Vector.java:466)
//    //       at com.jabberpoint.slides.Slide.getSlideItem(Slide.java:44)
//    //   See https://diff.blue/R013 to resolve this issue.
//
//    // Arrange and Act
//    (new Slide()).getSlideItem(10);
//  }
//
//  /**
//   * Method under test: {@link Slide#getSlideItem(int)}
//   */
  @Test
  void testGetSlideItem2() {
    // Arrange
    Slide slide = new Slide();
    slide.appendText(1, "Not all who wander are lost");

    // Act and Assert
      assertInstanceOf(TextItem.class, slide.getSlideItem(0));
  }

  /**
   * Method under test: {@link Slide#getSize()}
   */
  @Test
  void testGetSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new Slide()).getSize());
  }

  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Slide actualSlide = new Slide();
    actualSlide.setTitle("Dr");
    Vector<SlideItem> actualSlideItems = actualSlide.getSlideItems();

    // Assert that nothing has changed
    assertEquals("Dr", actualSlide.getTitle());
    assertSame(actualSlide.items, actualSlideItems);
  }
}
