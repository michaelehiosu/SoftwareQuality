package com.jabberpoint.slides;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextItemTest {

  private TextItem textItem1;
  private TextItem textItem2;

  @BeforeEach
  void setup() {
    textItem1 = new TextItem(1, "Text");
    textItem2 = new TextItem(1, null);
  }

  @Test
  void testGetText_withtextItem1_shouldReturnTextString() {
    assertEquals("Text", textItem1.getText());
  }

  @Test
  void testGetText_withtextItem2_shouldReturnEmptyString() {
    assertEquals("", textItem2.getText());
  }


  @Test
  void testToString_withtextItem1() {
    assertEquals("Slides.TextItem[1,Text]", textItem1.toString());
  }
}
