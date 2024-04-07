package com.jabberpoint.accessor;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
}
