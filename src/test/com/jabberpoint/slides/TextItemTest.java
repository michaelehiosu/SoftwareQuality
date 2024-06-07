package com.jabberpoint.slides;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TextItemTest {

    private TextItem textItem1;
    private TextItem textItem2;

    @BeforeEach
    void setup() {
        textItem1 = new TextItem(1, "Text");
        textItem2 = new TextItem(1, null);
    }

    @Test
    void testGetText_withTextItem1_shouldReturnTextString() {
        assertEquals("Text", textItem1.getText());
    }

    @Test
    void testGetText_withTextItem2_shouldReturnEmptyString() {
        assertEquals("", textItem2.getText());
    }

    @Test
    void testToString_withTextItem1() {
        assertEquals("Slides.TextItem[1,Text]", textItem1.toString());
    }

    @Test
    void testGetLevel_withTextItem1_shouldReturnCorrectLevel() {
        assertEquals(1, textItem1.getLevel());
    }

    @Test
    void testGetLevel_withTextItem2_shouldReturnCorrectLevel() {
        assertEquals(1, textItem2.getLevel());
    }

    @Test
    void testGetAttributedString_withTextItem1_shouldReturnNonNullValue() {
        Style style = new Style(0, Color.red, 48, 20);
        float scale = 1.0f;
        assertNotNull(textItem1.getAttributedString(style, scale));
    }
}
