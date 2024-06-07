package com.jabberpoint.slides;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BitmapItemTest
{
  @Test
  void testGettersAndSetters()
  {
    String imageName = "testImage.jpg";
    BitmapItem bitmapItem = new BitmapItem(1, imageName);
    String actualName = bitmapItem.getName();
    String actualToStringResult = bitmapItem.toString();
    assertEquals(imageName, actualName);
    assertNotNull(actualToStringResult);
  }

  @Test
  void testNewBitmapItem()
  {
    BitmapItem bitmapItem = new BitmapItem(1, "Image Name");
    assertNotNull(bitmapItem);
  }

  @Test
  void testNewBitmapItem2()
  {
    BitmapItem actualBitmapItem = new BitmapItem(1, "Image Name");
    assertEquals("Image Name", actualBitmapItem.getName());
    assertEquals(1, actualBitmapItem.getLevel());
  }

  @Test
  void testGetName() {
    String imageName = "testImage.jpg";
    BitmapItem bitmapItem = new BitmapItem(1, imageName);
    assertEquals(imageName, bitmapItem.getName());
  }

  @Test
  void testGetLevel() {
    int level = 1;
    BitmapItem bitmapItem = new BitmapItem(level, "testImage.jpg");
    assertEquals(level, bitmapItem.getLevel());
  }


}
