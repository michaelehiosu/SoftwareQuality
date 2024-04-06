package com.jabberpoint.slides;


import java.util.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlideTest {

  @Test
  void testAppendSlideItem2() {
    // Arrange
    Slide slide = new Slide();

    // Act
    slide.appendSlideItem(new BitmapItem(1, "Image Name"));

    // Assert
    assertEquals(1, slide.getSize());
  }


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


  @Test
  void testGetSlideItem2() {
    // Arrange
    Slide slide = new Slide();
    slide.appendText(1, "Not all who wander are lost");

    // Act and Assert
      assertInstanceOf(TextItem.class, slide.getSlideItem(0));
  }


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
