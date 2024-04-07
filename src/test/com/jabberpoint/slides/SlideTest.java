package com.jabberpoint.slides;


import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;

class SlideTest
{

  @Test
  void testAppendSlideItem2()
  {
    Slide slide = new Slide();
    slide.appendSlideItem(new BitmapItem(1, "Image Name"));

    assertEquals(1, slide.getSize());
  }


  @Test
  void testAppendText()
  {
    Slide slide = new Slide();

    slide.appendText(1, "Not all who wander are lost");

    SlideItem getResult = slide.getSlideItems().get(0);
    assertEquals("Not all who wander are lost", ((TextItem) getResult).getText());
    assertEquals(1, slide.getSize());
    assertEquals(1, getResult.getLevel());
  }


  @Test
  void testGetSlideItem2()
  {
    Slide slide = new Slide();
    slide.appendText(1, "Not all who wander are lost");

    assertInstanceOf(TextItem.class, slide.getSlideItem(0));
  }


  @Test
  void testGetSize()
  {
    assertEquals(0, (new Slide()).getSize());
  }

  @Test
  void testGettersAndSetters()
  {
    Slide actualSlide = new Slide();
    actualSlide.setTitle("Dr");
    Vector<SlideItem> actualSlideItems = actualSlide.getSlideItems();

    assertEquals("Dr", actualSlide.getTitle());
    assertSame(actualSlide.items, actualSlideItems);
  }
}
