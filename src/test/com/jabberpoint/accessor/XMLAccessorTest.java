package com.jabberpoint.accessor;

import com.jabberpoint.presentation.Presentation;
import com.jabberpoint.slides.Slide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class XMLAccessorTest
{
  private Presentation presentation;
  private XMLAccessor xMLAccessor;

  @BeforeEach
  void setUp()
  {
    this.presentation = new Presentation();
    this.xMLAccessor = new XMLAccessor(presentation);
  }

  @Test
  void testLoadFile_correctFileName_shouldNotThrowIOException()
  {
    assertDoesNotThrow(() -> {
      xMLAccessor.loadFile("test.xml");
    });
  }

  @Test
  void testLoadFile_correctFileName_createsCorrectSlides() throws IOException {
    xMLAccessor.loadFile("test.xml");
    Assertions.assertEquals(5, presentation.getSize());
  }

  @Test
  void testLoadFile_correctFileName_createsCorrectSlideItems() throws IOException {
    xMLAccessor.loadFile("test.xml");
    Slide slide = presentation.getSlide(0); // Get the first slide
    Assertions.assertEquals(9, slide.getSlideItems().size());
  }

  @Test
  void testSaveFile_createsCorrectXMLFile() throws IOException {
    xMLAccessor.loadFile("test.xml");
    xMLAccessor.saveFile("dump.xml");
    Presentation newPresentation = new Presentation();
    XMLAccessor newAccessor = new XMLAccessor(newPresentation);
    newAccessor.loadFile("dump.xml");
    Assertions.assertEquals(presentation.getSize(), newPresentation.getSize());
  }

  @Test
  void testLoadFile_incorrectFileName_shouldThrowIOException()
  {
    assertThrows(IOException.class, () -> {
      xMLAccessor.loadFile("tes.xml");
    });
  }


  @Test
  void testSaveFile_shouldNotThrowIOException()
  {
    assertDoesNotThrow(() -> {
      xMLAccessor.saveFile("dump.xml");
    });
  }

}
