package com.jabberpoint.slides;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;

class BitmapItemTest {
  @Test
  void testGettersAndSetters() {
    // Arrange
    String imageName = "testImage.jpg"; // Provide a valid image name
    BitmapItem bitmapItem = new BitmapItem(1, imageName);

    // Act
    String actualName = bitmapItem.getName();
    String actualToStringResult = bitmapItem.toString();

    // Assert
    // Add assertions on the result
    assertEquals(imageName, actualName);
    assertNotNull(actualToStringResult);
    // Add more assertions as needed based on the expected behavior of getName and toString methods
  }


  @Test
  void testNewBitmapItem() {
    // Arrange and Act
    BitmapItem bitmapItem = new BitmapItem(1, "Image Name");

    // Assert
    // No specific assertions needed, as long as no exceptions are thrown during object creation
    assertNotNull(bitmapItem);
  }



  @Test
  void testNewBitmapItem2() {
    // Arrange and Act
    BitmapItem actualBitmapItem = new BitmapItem(1, "Image Name");

    // Assert
    assertEquals("Image Name", actualBitmapItem.getName());
    assertEquals(1, actualBitmapItem.getLevel());
  }
}
