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


class DemoPresentationTest
{
  Presentation presentation;
  DemoPresentation demoPresentation;

  @BeforeEach
  void setUp()
  {
    presentation = new Presentation();
    demoPresentation = new DemoPresentation(presentation);
  }

  @Test
  void testLoadFile_ShouldNotThrowIOException()
  {
    assertDoesNotThrow(() -> {
      demoPresentation.loadFile("filename");
    });
  }

  @Test
  void testSaveFile_ShouldThrowIOException()
  {
    assertThrows(IOException.class, () -> {
      demoPresentation.saveFile("unusedFilename");
    });
  }

  @Test
  void testLoadFile_createsCorrectSlides() throws IOException {
    demoPresentation.loadFile("filename");
    Assertions.assertEquals(3, presentation.getSize());
  }

  @Test
  void testLoadFile_createsCorrectSlideItems() throws IOException {
    demoPresentation.loadFile("filename");
    Slide slide = presentation.getSlide(0);
    Assertions.assertEquals(10, slide.getSlideItems().size());
  }
}
